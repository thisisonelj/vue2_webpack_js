package com.example.demo.subdemo3;

import lombok.Data;
/*
子类信息
 */
@Data
public class SubUser {
    private Integer id;
    private String name;
    private Integer subId;
    private String content;
    private String intelegal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntelegal() {
        return intelegal;
    }

    public void setIntelegal(String intelegal) {
        this.intelegal = intelegal;
    }

    @Override
    public String toString() {
        return "SubUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subId=" + subId +
                ", content='" + content + '\'' +
                ", intelegal='" + intelegal + '\'' +
                '}';
    }
}
