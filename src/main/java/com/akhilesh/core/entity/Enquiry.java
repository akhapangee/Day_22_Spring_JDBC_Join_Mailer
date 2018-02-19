package com.akhilesh.core.entity;

import java.util.Date;

/**
 *
 * @author Akhilesh
 */
public class Enquiry {
    private int id;
    private String firstName, lastName, email, contactNo;
    private Course course;
    private String message;
    private Date enquiryDate;
    private EnquiryStatus status;

    public Enquiry() {
    }

    public Enquiry(int id, String firstName, String lastName, String email, String contactNo, Course course, EnquiryStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.course = course;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public Date getEnquiryDate() {
        return enquiryDate;
    }

    public void setEnquiryDate(Date enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Course getCourse() {
        return course;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public EnquiryStatus getStatus() {
        return status;
    }

    public void setStatus(EnquiryStatus status) {
        this.status = status;
    }
    
    
}
