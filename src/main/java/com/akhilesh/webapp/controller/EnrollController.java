package com.akhilesh.webapp.controller;

import com.akhilesh.core.dao.CourseDAO;
import com.akhilesh.core.dao.EnquiryDAO;
import com.akhilesh.core.entity.Enquiry;
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
@RequestMapping(value = "/enroll")
public class EnrollController {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private EnquiryDAO enquiryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("courses", courseDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "enroll/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(Enquiry enquiry) {
        try {
            enquiryDAO.insert(enquiry);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/enroll/thankyou";
    }

    @RequestMapping(value = "/thankyou",method = RequestMethod.GET)
    public String thankyou(Model model) {
        return "enroll/thankyou";
    }

}
