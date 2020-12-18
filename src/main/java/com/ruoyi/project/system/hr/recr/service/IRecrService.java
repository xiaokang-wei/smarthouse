package com.ruoyi.project.system.hr.recr.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.hr.recr.domain.Recr;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/17 16:00
 * 今天写完十万个Bug了吗？
 */
public interface IRecrService {
    List<Recr> selectRecrList(Recr recr);

    boolean addRecr(Recr recr);

    Recr selectRecrById(Integer rid);

    List<String> selectRecrForApproStatus();

    boolean editRecrById(Recr recr);

    AjaxResult removeRecrByIds(String[] ids);
}
