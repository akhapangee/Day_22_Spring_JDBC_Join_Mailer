package com.akhilesh.webapp.controller;

import com.akhilesh.core.dao.MailTemplateDAO;
import com.akhilesh.core.entity.MailTemplate;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping(value = "/admin/templates")
public class AdminMailTemplateController {

    @Autowired
    private MailTemplateDAO mailTemplateDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("templates", mailTemplateDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/mailtemplates/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create() {
        return "admin/mailtemplates/create";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(MailTemplate template) {
        try {
            mailTemplateDAO.insert(template);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/mailtemplates/index";
    }

}
