package com.jlife.pojo;

import java.io.Serializable;

/**
 * Created by chenjianan on 2016/11/13-18:43.
 * <p>
 * Describe:
 */
public class SelfCard  implements Serializable {
    private Long id;
    private Long studentId;
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
