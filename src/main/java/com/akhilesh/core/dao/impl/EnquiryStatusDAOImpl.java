/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this jdbcTemplate file, choose Tools | Templates
 * and open the jdbcTemplate in the editor.
 */
package com.akhilesh.core.dao.impl;

import com.akhilesh.core.dao.EnquiryStatusDAO;
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
@Repository(value="enquiryStatusDAO")
public class EnquiryStatusDAOImpl implements EnquiryStatusDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<EnquiryStatus> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from enquiry_status";
        return jdbcTemplate.query(sql, new RowMapper<EnquiryStatus>() {
            @Override
            public EnquiryStatus mapRow(ResultSet rs, int i) throws SQLException {
                EnquiryStatus status = new EnquiryStatus();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                status.setColor(rs.getString("color"));
                return status;
            }
        });
    }

    @Override
    public EnquiryStatus getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from enquiry_status where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<EnquiryStatus>() {
            @Override
            public EnquiryStatus mapRow(ResultSet rs, int i) throws SQLException {
                EnquiryStatus status = new EnquiryStatus();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                status.setColor(rs.getString("color"));

                return status;
            }
        });
    }

    @Override
    public int insert(EnquiryStatus t) throws ClassNotFoundException, SQLException {
        String sql = "insert into enquiry_status(name,color)"
                + "where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
            t.getName(), t.getColor()
        });
    }

    @Override
    public int update(EnquiryStatus t) throws ClassNotFoundException, SQLException {
        String sql = "update enquiry_status set name=?, color=? "
                + "values(?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            t.getName(), t.getColor()
        });
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from enquiry_status where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
            id
        });
    }

}
