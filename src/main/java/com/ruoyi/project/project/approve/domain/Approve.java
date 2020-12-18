package com.ruoyi.project.project.approve.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Approve {

    private int pid;
    private String ename;
    private String pname;
    private int ptype;
    private int ptask;
    private int pdegree;
    private int pcheck;
    private int papprove;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pstarttime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pendtime;
}
