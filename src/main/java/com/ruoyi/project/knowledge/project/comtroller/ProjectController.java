package com.ruoyi.project.knowledge.project.comtroller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.knowledge.patent.domain.Patent;
import com.ruoyi.project.knowledge.patent.domain.PatentVO;
import com.ruoyi.project.knowledge.patent.service.IPatentService;
import com.ruoyi.project.knowledge.project.domain.Project;
import com.ruoyi.project.knowledge.project.domain.ProjectVO;
import com.ruoyi.project.knowledge.project.service.IProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin2.main.client.MozillaServiceDelegate;

import java.util.List;

/**
 * @author wxk
 * @date 2020/12/17 14:47
 */
@Controller
@RequestMapping("/knowledge/project")
public class ProjectController extends BaseController {
    private String prefix = "knowledge/project";
    @Autowired
   private IProjectService projectService;

    @RequiresPermissions("knowledge:project:view")
    @GetMapping()
    public String operlog() {
        return prefix + "/project";
    }



    @RequiresPermissions("knowledge:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectVO projectVO)
    {
        System.out.println("projectVO = " + projectVO);
        startPage();
        List<ProjectVO> list = projectService.selectProjectVOList(projectVO);
        System.out.println("list = " + list);
        return getDataTable(list);
    }

    @RequiresPermissions("knowledge:project:add")
    @GetMapping("/add")
    public String add(Model model)
    {
        List<ProjectVO> list = projectService.selectProjectList();
        model.addAttribute("projects",list);
        System.out.println("projectlist = " + list);
        return prefix + "/add";
    }
    /**
     * 新增保存
     */
    @RequiresPermissions("knowledge:project:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(Project project)
    {
        return projectService.insertProject(project);
    }

    @RequiresPermissions("knowledge:project:edit")
    @PostMapping("/changeMark")
    @ResponseBody
    public AjaxResult changeMark(Project project)
    {
        System.out.println("project = " + project);
        return projectService.changeMark(project);
    }

    @PostMapping("/add/imgupload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file)throws Exception{
        {
            try {
                //上传文件的路径
                String filePath= RuoYiConfig.getUploadPath();
                System.out.println("filePath = " + filePath);
                //上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url= ServerConfig.getUrl()+fileName;
                AjaxResult ajax = AjaxResult.success();
                ajax.put("fileName",fileName);
                ajax.put("url",url);
                System.out.println("=======================ajax = " + ajax);
                return ajax;

            }catch (Exception e){
                return AjaxResult.error(e.getMessage());
            }
        }
    }
    @RequiresPermissions("knowledge:project:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult deletePatentByIds(Integer[] ids) {
        return projectService.deleteProjectById(ids);
    }

    @RequiresPermissions("knowledge:patent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectVO projectVO)
    {
        List<ProjectVO> list = projectService.selectProjectVOList(projectVO);
        ExcelUtil<ProjectVO> util = new ExcelUtil<>(ProjectVO.class);
        return util.exportExcel(list, "专利数据");
    }
//    查询项目文件列表
    @RequiresPermissions("system:patent:list")
    @GetMapping("/detail/{pNo}")
    public String detail(@PathVariable("pNo") Integer pNo, ModelMap mmap)
    {
        mmap.put("url", projectService.selectSrcById(pNo));
        return prefix + "/detail";
    }



}
