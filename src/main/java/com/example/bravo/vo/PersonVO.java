package com.example.bravo.vo;

import java.util.Map;

public class PersonVO {
    Long id;
    String name;
    Map<String,Integer> attrs;

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

    public Map<String, Integer> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Integer> attrs) {
        this.attrs = attrs;
    }

    public PersonVO(Long id, String name, Map<String, Integer> attrs) {
        this.id = id;
        this.name = name;
        this.attrs = attrs;
    }
}
