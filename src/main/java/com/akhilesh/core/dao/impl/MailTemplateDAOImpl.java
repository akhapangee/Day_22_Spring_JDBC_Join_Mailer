/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this jdbcTemplate file, choose Tools | Templates
 * and open the jdbcTemplate in the editor.
 */
package com.akhilesh.core.dao.impl;

import com.akhilesh.core.dao.MailTemplateDAO;
import com.akhilesh.core.entity.MailTemplate;
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
@Repository(value = "mailTemplateDAO")
public class MailTemplateDAOImpl implements MailTemplateDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<MailTemplate> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from mail_templates";
        return jdbcTemplate.query(sql, new RowMapper<MailTemplate>() {
            @Override
            public MailTemplate mapRow(ResultSet rs, int i) throws SQLException {
                MailTemplate template = new MailTemplate();
                template.setId(rs.getInt("id"));
                template.setSlug(rs.getString("slug"));
                template.setContent(rs.getString("content"));
                template.setName(rs.getString("name"));
                template.setAddedDate(rs.getDate("added_date"));
                template.setStatus(rs.getBoolean("status"));
                return template;
            }
        });
    }

    @Override
    public MailTemplate getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from mail_templates where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<MailTemplate>() {
            @Override
            public MailTemplate mapRow(ResultSet rs, int i) throws SQLException {
                MailTemplate template = new MailTemplate();
                template.setId(rs.getInt("id"));
                template.setSlug(rs.getString("slug"));
                template.setContent(rs.getString("content"));
                template.setName(rs.getString("name"));
                template.setAddedDate(rs.getDate("added_date"));
                template.setStatus(rs.getBoolean("status"));
                return template;
            }
        });
    }

    @Override
    public int insert(MailTemplate t) throws ClassNotFoundException, SQLException {
        String sql = "insert into mail_templates(name, slug, content, status)"
                + "where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
            t.getName(), t.getSlug(), t.getContent(), t.isStatus(), t.getId()
        });
    }

    @Override
    public int update(MailTemplate t) throws ClassNotFoundException, SQLException {
        String sql = "update mail_templates set name=?, slug=?, content=?, status=? "
                + "where id=?";
        return jdbcTemplate.update(sql, new Object[]{
            t.getName(), t.getSlug(), t.getContent(), t.isStatus(),t.getId()
        });
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from mail_templates where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
            id
        });
    }

    @Override
    public MailTemplate getBySlug(String slug) throws ClassNotFoundException, SQLException {
        String sql = "select * from mail_templates where slug=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{slug}, new RowMapper<MailTemplate>() {
            @Override
            public MailTemplate mapRow(ResultSet rs, int i) throws SQLException {
                MailTemplate template = new MailTemplate();
                template.setId(rs.getInt("id"));
                template.setSlug(rs.getString("slug"));
                template.setContent(rs.getString("content"));
                template.setName(rs.getString("name"));
                template.setAddedDate(rs.getDate("added_date"));
                template.setStatus(rs.getBoolean("status"));
                return template;
            }
        });
    }

}
