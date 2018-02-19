/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this jdbcTemplate file, choose Tools | Templates
 * and open the jdbcTemplate in the editor.
 */
package com.akhilesh.core.dao.impl;

import com.akhilesh.core.dao.CourseDAO;
import com.akhilesh.core.entity.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Akhilesh
 */
@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from courses";
        return jdbcTemplate.query(sql, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setFees(rs.getInt("fees"));
                course.setCode(rs.getString("code"));
                course.setName(rs.getString("name"));
                return course;
            }
        });
    }

    @Override
    public Course getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from courses where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setFees(rs.getInt("fees"));
                course.setCode(rs.getString("code"));
                course.setName(rs.getString("name"));
                return course;
            }
        });
    }

    @Override
    public int insert(Course t) throws ClassNotFoundException, SQLException {
        String sql = "insert into courses(name, code, fees, status)"
                + "where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
            t.getName(),t.getCode(),t.getFees(),t.isStatus(), t.getId()
        });
    }

    @Override
    public int update(Course t) throws ClassNotFoundException, SQLException {
        String sql = "update courses set name=?, code=?, fees=?, status=?"
                + "values(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            t.getName(),t.getCode(),t.getFees(),t.isStatus()
        });
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from courses where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
           id
        });
    }

}
