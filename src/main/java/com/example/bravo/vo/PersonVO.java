package com.example.bravo.vo;

import java.util.Map;

public class PersonVO {
    Integer id;
    String name;
    Map<String,Integer> attrs;

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

    public Map<String, Integer> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Integer> attrs) {
        this.attrs = attrs;
    }

    public PersonVO(Integer id, String name, Map<String, Integer> attrs) {
        this.id = id;
        this.name = name;
        this.attrs = attrs;
    }
}
