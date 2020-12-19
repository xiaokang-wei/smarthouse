package com.ruoyi.project.project.approve.service;


import com.ruoyi.project.project.approve.domain.Approve;
import com.ruoyi.project.project.check.domain.Check;

import java.util.List;

public interface IApproveService {


    List<Approve> selectApproveAll();

    Approve selectprojectApproveById(int pid);

    int updateApprove(Approve approve);
}
