package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.manager.service.IManagerContentCategoryService;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4 0004.
 */
@Controller
public class ManagerContentCategoryController {
    @Resource  //因为不是.class文件注入,用的类型名称注入所以用Resources
    private IManagerContentCategoryService managerContentCategoryService;
    //查询树形结构的数据
    @RequestMapping("content/category/list")
    @ResponseBody
    public List<TreeDto> queryContentCategoryListByParentId(@RequestParam(defaultValue = "0") Long id){
        return managerContentCategoryService.queryContentCategoryListByParentId(id);
    }
    //跟新数据,保存数据
    @RequestMapping("content/category/create")
    @ResponseBody
    public EgoResult save(TbContentCategory contentCategory){
        return  managerContentCategoryService.save(contentCategory);
    }


}
