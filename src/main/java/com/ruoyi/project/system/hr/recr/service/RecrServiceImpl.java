package com.ruoyi.project.system.hr.recr.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.hr.recr.domain.Recr;
import com.ruoyi.project.system.hr.recr.mapper.RecrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/17 16:01
 * 今天写完十万个Bug了吗？
 */
@Service("recr")
public class RecrServiceImpl implements IRecrService {
    @Autowired
    private RecrMapper recrMapper;
    @Override
    public List<Recr> selectRecrList(Recr recr) {
        List<Recr> list = recrMapper.selectRecrList(recr);
        return list;
    }

    @Override
    public boolean addRecr(Recr recr) {
        recr.setApproStatus("审批中");
      int row  = recrMapper.addRecr(recr);
      if (row>=0){
          return true;
      }
        return false;
    }

    @Override
    public Recr selectRecrById(Integer rid) {
        Recr recr = recrMapper.selectRecrById(rid);
        return recr;
    }

    @Override
    public List<String> selectRecrForApproStatus() {
        List<String> stringList =  recrMapper.selectRecrForApproStatus(null);
        return stringList;
    }

    @Override
    public boolean editRecrById(Recr recr) {
      int row = recrMapper.editRecrById(recr);
      if (row>=0){
          return true;
      }
        return false;
    }

    @Override
    public AjaxResult removeRecrByIds(String[] ids) {
        List<String> stringList = recrMapper.selectRecrForApproStatus(ids);
        for (String ApproStatus : stringList) {
            if (ApproStatus=="审批中"){
                return AjaxResult.error("请驳回后再删除");
            }
        }
      int row = recrMapper.removeRecrByIds(ids);
        if (row>=0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    public List<Recr> getStatus(){
        return recrMapper.selectRecrList(null);
    }
}
