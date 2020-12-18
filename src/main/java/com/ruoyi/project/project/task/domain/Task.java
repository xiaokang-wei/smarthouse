package com.ruoyi.project.project.task.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Task {

    private int pid;
    private String pname;
    private String ptype;
    private int ptask;
    private String ename;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pstarttime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   pendtime;

}
