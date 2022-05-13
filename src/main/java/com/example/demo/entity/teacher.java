package com.example.demo.entity;

import lombok.Data;

@Data
public class teacher {
    int tid;
    String name=null;
    public teacher(String name ){
//        this.setTid(tid);
        this.setName(name);
    }
    public teacher(){};
}
