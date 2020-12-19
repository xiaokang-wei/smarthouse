package com.ruoyi.project.knowledge.project.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.knowledge.project.domain.Project;
import com.ruoyi.project.knowledge.project.domain.ProjectVO;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/17 19:55
 */
public interface IProjectService {

    List<ProjectVO> selectProjectVOList(ProjectVO projectVO);

    List<ProjectVO> selectProjectList();

    AjaxResult insertProject(Project project);

    AjaxResult changeMark(Project project);

    AjaxResult deleteProjectById(Integer[] ids);

    String selectSrcById(Integer pNo);

}
