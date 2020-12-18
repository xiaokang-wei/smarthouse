package com.ruoyi.project.project.approve.service;


import com.ruoyi.project.project.approve.domain.Approve;
import com.ruoyi.project.project.approve.mapper.ApproveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApproveServiceImpl implements IApproveService {

    @Autowired
    private ApproveMapper approveMapper;


    @Override
    public List<Approve> selectApproveAll() {
        return approveMapper.selectApproveAll();
    }

    @Override
    public Approve selectprojectApproveById(int pid) {
        return approveMapper.selectprojectApproveById(pid);
    }

    @Override
    public int updateApprove(Approve approve) {
        return approveMapper.updateApprove(approve);
    }
}
