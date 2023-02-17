package com.example.demo.subdemo3;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id;
    private String name;
    private Integer parentId;
    private String content;
    private Integer subId;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getIntelegal() {
        return intelegal;
    }

    public void setIntelegal(String intelegal) {
        this.intelegal = intelegal;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", subId=" + subId +
                ", intelegal='" + intelegal + '\'' +
                '}';
    }
}
