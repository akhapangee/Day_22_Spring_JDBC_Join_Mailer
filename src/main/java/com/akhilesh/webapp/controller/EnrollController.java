package com.akhilesh.webapp.controller;

import com.akhilesh.core.dao.CourseDAO;
import com.akhilesh.core.dao.EnquiryDAO;
import com.akhilesh.core.dao.MailTemplateDAO;
import com.akhilesh.core.entity.Course;
import com.akhilesh.core.entity.Enquiry;
import com.akhilesh.core.entity.MailTemplate;
import com.akhilesh.core.util.Mailer;
import com.akhilesh.core.util.Parser;
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

    @Autowired
    private MailTemplateDAO mailTemplateDAO;

    @Autowired
    private Mailer mailer;

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
            MailTemplate template = mailTemplateDAO.getBySlug("Enroll-Confirmation");
            Parser parser = new Parser();
            Course course = courseDAO.getById(enquiry.getCourse().getId());
            parser.addData("NAME", (enquiry.getFirstName() + " " + enquiry.getLastName()))
                    .addData("COURSE", course.getName());

            String content = parser.parse(template.getContent());

            //send email now
//            mailer.setHost("smtp.vianet.com.np");
//            mailer.setFrom("akhiesh.khapangee@bottomline.com");
            mailer.setTo(enquiry.getEmail());
            mailer.setSubject(template.getName());
            mailer.setBody(content);
            mailer.send();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/enroll/thankyou";
    }

    @RequestMapping(value = "/thankyou", method = RequestMethod.GET)
    public String thankyou(Model model) {
        return "enroll/thankyou";
    }

}
