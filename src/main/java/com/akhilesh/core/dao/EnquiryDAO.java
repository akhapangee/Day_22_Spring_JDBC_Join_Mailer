/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.core.dao;

import com.akhilesh.core.entity.Enquiry;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akhilesh
 */
public interface EnquiryDAO extends GenericDAO<Enquiry>{
    List<Enquiry> getEnquiries() throws ClassNotFoundException,SQLException;
}
