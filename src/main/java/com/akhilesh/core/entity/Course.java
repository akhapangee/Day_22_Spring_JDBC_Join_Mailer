package com.akhilesh.core.entity;

/**
 *
 * @author Akhilesh
 */
public class Course {

    private int id;
    private String name;
    private String code;
    private int fees;
    private boolean status;

    public Course() {
    }
    
    public Course(int id) {
        this.id =id;
    }

    public Course(int id, String name, String code, int fees) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.fees = fees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public boolean isStatus() {
        return status;
    }

    
    public void setStatus(boolean status) {
        this.status = status;
    }
    

}
