package com.ruoyi.project.project.degree.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Degree {

    private int pid;
    private String ename;
    private String pname;
    private int ptype;
    private int ptask;
    private int pdegree;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pstarttime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pendtime;
}
