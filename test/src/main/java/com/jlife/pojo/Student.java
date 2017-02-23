package com.jlife.pojo;

import java.io.Serializable;

/**
 * Created by chenjianan on 2016/11/13-18:43.
 * <p>
 * Describe:
 */
public class Student implements Serializable{
    private Long id;
    private String name;
    private SelfCard selfCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SelfCard getSelfCard() {
        return selfCard;
    }

    public void setSelfCard(SelfCard selfCard) {
        this.selfCard = selfCard;
    }
}
