package com.akhilesh.core.builder;

import com.akhilesh.core.entity.Course;
import com.akhilesh.core.entity.Enquiry;
import com.akhilesh.core.entity.EnquiryStatus;
import java.util.Date;

/**
 *
 * @author Akhilesh
 */
public class EnquiryBuilder {

    private int id;
    private String firstName, lastName, email, contactNo, message;
    private Course course;
    private Date enquiryDate;
    private EnquiryStatus status;

    private EnquiryBuilder() {

    }

    public static EnquiryBuilder create() {
        return new EnquiryBuilder();
    }

    public EnquiryBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EnquiryBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EnquiryBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EnquiryBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public EnquiryBuilder setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public EnquiryBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public EnquiryBuilder setCourse(Course course) {
        this.course = course;
        return this;
    }

    public EnquiryBuilder setStatus(EnquiryStatus status) {
        this.status = status;
        return this;
    }
    public EnquiryBuilder setEnquiryDate(Date enquiryDate) {
        this.enquiryDate = enquiryDate;
        return this;
    }

    public Enquiry build() {
        Enquiry enquiry = new Enquiry(id, firstName, lastName, email, contactNo, course, status);
        enquiry.setEnquiryDate(enquiryDate);
        return enquiry;
    }

}
