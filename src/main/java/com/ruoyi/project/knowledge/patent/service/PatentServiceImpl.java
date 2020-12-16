package com.ruoyi.project.knowledge.patent.service;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.ruoyi.common.constant.PatentConstants;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.knowledge.patent.domain.Patent;
import com.ruoyi.project.knowledge.patent.domain.PatentVO;
import com.ruoyi.project.knowledge.patent.mapper.PatentMapper;
import com.ruoyi.project.knowledge.tree.mapper.TreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.image.IntegerComponentRaster;

import javax.transaction.TransactionRequiredException;
import java.sql.SQLData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wxk
 * @date 2020/12/14 21:49
 */
@Service("patent")
public class PatentServiceImpl implements IPatentService{
    @Autowired
    private PatentMapper patentMapper;
    @Autowired
    private TreeMapper treeMapper;
    @Override
    public List<PatentVO> selectPatentVOList(PatentVO patentVO) {
        List<PatentVO> patents=patentMapper.selectPatentVOList(patentVO);
        return patents;
    }

    @Override
    public String checkPatentNameUnique(String patentName) {
        Patent patent=patentMapper.selectPatentByName(patentName);
        System.out.println("patent = " + patent);
        if (patent != null) {
            return PatentConstants.PATENT_NAME_NOT_UNIQUE;
        }
        return PatentConstants.PATENT_NAME_UNIQUE;
    }

    @Override
    public AjaxResult insertPatent(Patent patent, String userName ) {
        patent.setCreateBy(userName);
        patent.setDId(treeMapper.selectDIdByEmpNo( patent.getPatentAuthor()));
        System.out.println(" ===================================== " );
        System.out.println("patentVO = " + patent);
        System.out.println(" ===================================== " );
        Integer row=patentMapper.insertPatent(patent);
        if (row==1){
            return AjaxResult.success("添加专利成功！");
        }
        return AjaxResult.error("添加专利失败！");
    }

    @Override
    public PatentVO selectPatentById(Integer patentId) {
        PatentVO patent =patentMapper.selectPatentById(patentId);
        return patent;
    }

    @Override
    public AjaxResult updatePatentById(Patent patent, String userName) {
        patent.setUpdateBy(userName);
        patent.setDId(treeMapper.selectDIdByEmpNo( patent.getPatentAuthor()));
        Integer row=patentMapper.updatePatentById(patent);
        if (row==1){
            return AjaxResult.success("修改专利成功！");
        }
        return AjaxResult.error("修改专利失败！");
    }

    @Override
    public AjaxResult deletePatentById(Integer[] ids) {
        Integer rows=patentMapper.deletePatentById(ids);
        if (rows==ids.length){
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("删除失败！");
    }

    public List<PatentVO> selectdName() {
        List<PatentVO> dNames=patentMapper.selectCondDName();
        return dNames;
    }
    public List<String> selectCondStatus() {
        List<String> status = patentMapper.selectCondStatus();
        return status;
    }
    public List<String> selectCondType() {
        List<String> types = patentMapper.selectCondType();
        return types;
    }

}
