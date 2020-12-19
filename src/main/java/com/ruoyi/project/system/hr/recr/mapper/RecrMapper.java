package com.ruoyi.project.system.hr.recr.mapper;

import com.ruoyi.project.system.hr.recr.domain.Recr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 康师傅biangbiang面
 * @date 2020/12/17 16:00
 * 今天写完十万个Bug了吗？
 */
public interface RecrMapper {
    List<Recr> selectRecrList(Recr recr);

    int addRecr(Recr recr);

    Recr selectRecrById(@Param("rid")Integer rid);

    List<String> selectRecrForApproStatus(@Param("ids") String[] ids);

    int editRecrById(Recr recr);

    int removeRecrByIds(@Param("ids") String[] ids);
}
