package com.ruoyi.project.knowledge.project.mapper;

import com.ruoyi.project.knowledge.project.domain.Project;
import com.ruoyi.project.knowledge.project.domain.ProjectVO;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/17 19:56
 */
public interface ProjectMapper {
    List<ProjectVO> selectProjectVOList(ProjectVO projectVO);

    List<ProjectVO> selectProjectList();

    Integer insertProject(Project project);

    Integer changeMark(Project project);

    Integer deleteProjectById(Integer[] ids);

    String selectSrcById(Integer pNo);
}
