package com.ruoyi.project.project.message.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Message {

    private int pid;
    private int pnumber;
    private String pname;
    private String ename;
    private String pstyle;
    private String ptype;
    private String username;
    private String remark;
    private int pstatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pstarttmie;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pendtime;


}
