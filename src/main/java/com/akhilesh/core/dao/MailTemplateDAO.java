package com.akhilesh.core.dao;

import com.akhilesh.core.entity.MailTemplate;
import java.sql.SQLException;

/**
 *
 * @author Akhilesh
 */
public interface MailTemplateDAO extends GenericDAO<MailTemplate>{
    MailTemplate getBySlug(String slug) throws ClassNotFoundException, SQLException;
}
