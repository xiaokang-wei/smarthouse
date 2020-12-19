package com.ruoyi.project.knowledge.project.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.knowledge.project.domain.Project;
import com.ruoyi.project.knowledge.project.domain.ProjectVO;
import com.ruoyi.project.knowledge.project.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wxk
 * @date 2020/12/17 19:55
 */
@Service
public class ProjectService implements IProjectService{
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectVO> selectProjectVOList(ProjectVO projectVO) {
        List<ProjectVO> projectVOs = projectMapper.selectProjectVOList(projectVO);
        System.out.println("projectVOs = " + projectVOs);
        return projectVOs;
    }

    @Override
    public List<ProjectVO> selectProjectList() {
        List<ProjectVO> projectList=projectMapper.selectProjectList();
        return projectList;
    }

    @Override
    public AjaxResult insertProject(Project project) {
        project.setPStartTime(new Date());
        project.setPEndTime(new Date());
        project.setPDesc("我是描述");
        Integer row=projectMapper.insertProject(project);
        if (row==1){
            return AjaxResult.success("录入项目信息成功！");
        }
        return AjaxResult.error("录入项目信息失败！");
    }

    @Override
    public AjaxResult changeMark(Project project) {
        Integer row=projectMapper.changeMark(project);
        if (row==1){
            return AjaxResult.success("标记成功！");
        }
        return AjaxResult.error("标记失败！");
    }

    @Override
    public AjaxResult deleteProjectById(Integer[] ids) {
        Integer row=projectMapper.deleteProjectById(ids);
        if (row==ids.length){
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("删除失败！");
    }

    @Override
    public String selectSrcById(Integer pNo) {
        String src=projectMapper.selectSrcById(pNo);
        return src;
    }
}
