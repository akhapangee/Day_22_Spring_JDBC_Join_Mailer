package com.akhilesh.webapp.controller;

import com.akhilesh.core.dao.MailTemplateDAO;
import com.akhilesh.core.entity.MailTemplate;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("template", mailTemplateDAO.getById(id));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/mailtemplates/edit";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(MailTemplate template) {
        try {
            if (template.getId() == 0) {
                mailTemplateDAO.insert(template);
            } else {
                mailTemplateDAO.update(template);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/admin/templates";
    }

}
