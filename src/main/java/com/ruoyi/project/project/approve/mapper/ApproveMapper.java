package com.ruoyi.project.project.approve.mapper;

import com.ruoyi.project.project.approve.domain.Approve;
import com.ruoyi.project.project.check.domain.Check;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApproveMapper {


    List<Approve> selectApproveAll();

    Approve selectprojectApproveById(int pid);

    int updateApprove(Approve approve);
}
