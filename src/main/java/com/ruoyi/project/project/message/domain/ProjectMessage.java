package com.ruoyi.project.project.message.domain;

import lombok.Data;



@Data
public class ProjectMessage extends Message{

    private int userid;
    private String usertype;
    private int cid;
    private String cname;
    private String company;
    private String ctype;
    private String phone;
    private String ptype;
    private String penvironment;
    private String pcondition;
}
