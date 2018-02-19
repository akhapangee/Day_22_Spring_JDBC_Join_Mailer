package com.akhilesh.webapp.controller;

import com.akhilesh.core.dao.CourseDAO;
import com.akhilesh.core.dao.EnquiryDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Akhilesh
 */
@Controller
@RequestMapping(value = "/admin/enquiries")
public class AdminEnquiryController {

    @Autowired
    private CourseDAO courseDAO;
    
    @Autowired
    private EnquiryDAO enquiryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("courses", courseDAO.getAll());
            model.addAttribute("enquiries", enquiryDAO.getEnquiries());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/enquiries/index";
    }

}
