package com.akhilesh.core.entity;

import java.util.Date;

/**
 *
 * @author Akhilesh
 */
public class MailTemplate {

    private int id;
    private String slug;
    private String name, content;
    private Date addedDate;
    private boolean status;

    public MailTemplate() {
    }

    public MailTemplate(int id) {
        this.id = id;
    }

    public MailTemplate(int id, String slug, String name, String content, Date added_date, boolean status) {
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.content = content;
        this.addedDate = added_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

}
