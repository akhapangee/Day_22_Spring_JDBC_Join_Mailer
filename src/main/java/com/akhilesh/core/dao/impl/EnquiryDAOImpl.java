/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this jdbcTemplate file, choose Tools | Templates
 * and open the jdbcTemplate in the editor.
 */
package com.akhilesh.core.dao.impl;

import com.akhilesh.core.builder.EnquiryBuilder;
import com.akhilesh.core.dao.EnquiryDAO;
import com.akhilesh.core.entity.Course;
import com.akhilesh.core.entity.Enquiry;
import com.akhilesh.core.entity.EnquiryStatus;
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
@Repository(value = "enquiryDAO")
public class EnquiryDAOImpl implements EnquiryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from enquiries";
        return jdbcTemplate.query(sql, new RowMapper<Enquiry>() {
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                Enquiry enquiry = EnquiryBuilder.create()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setEmail(rs.getString("email"))
                        .setContactNo(rs.getString("contact_no"))
                        .setMessage(rs.getString("message"))
                        .setEnquiryDate(rs.getDate("enquiry_date"))
                        .setCourse(new Course(rs.getInt("course_id")))
                        .setStatus(new EnquiryStatus(rs.getInt("status")))
                        .build();
                return enquiry;
            }
        });
    }

    @Override
    public Enquiry getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from enquiries where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Enquiry>() {
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                return EnquiryBuilder.create()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setEmail(rs.getString("email"))
                        .setContactNo(rs.getString("contact_no"))
                        .setMessage(rs.getString("message"))
                        .setCourse(new Course(rs.getInt("course_id")))
                        .setStatus(new EnquiryStatus(rs.getInt("status")))
                        .build();
            }
        });
    }

    @Override
    public int insert(Enquiry t) throws ClassNotFoundException, SQLException {
        String sql = "insert into enquiries(first_name, last_name, email, contact_no, message, course_id, status )"
                + "values (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            t.getFirstName(), t.getLastName(), t.getEmail(), t.getContactNo(), t.getMessage(),
            t.getCourse().getId(),t.getStatus().getId()
        });
    }

    @Override
    public int update(Enquiry t) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from enquiries where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
            id
        });
    }

    @Override
    public List<Enquiry> getEnquiries() throws ClassNotFoundException, SQLException {
         String sql = "select e.*, c.name as course_name, "
                 + "es.name as status_name, es.color from enquiries e "
                 + "join courses c on c.id = e.course_id "
                 + "join enquiry_status es on es.id = e.status order by e.id asc";
        return jdbcTemplate.query(sql, new RowMapper<Enquiry>() {
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                Course course = new Course(rs.getInt("course_id"));
                course.setName(rs.getString("course_name"));
                EnquiryStatus status = new EnquiryStatus(rs.getInt("status"));
                status.setName(rs.getString("status_name"));
                status.setColor(rs.getString("color"));
                Enquiry enquiry = EnquiryBuilder.create()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setEmail(rs.getString("email"))
                        .setContactNo(rs.getString("contact_no"))
                        .setCourse(course)
                        .setMessage(rs.getString("message"))
                        .setEnquiryDate(rs.getDate("enquiry_date"))
                        .setStatus(status)
                        .build();
                return enquiry;
            }
        });
    }

}
