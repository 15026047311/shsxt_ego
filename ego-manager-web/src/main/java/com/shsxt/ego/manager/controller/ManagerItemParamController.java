package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Controller
public class ManagerItemParamController {
    @Resource
    private IManagerItemParamService managerItemParamService;

    //分页查询数据
    @RequestMapping("item/param/list")
    @ResponseBody
    public PageResult<TbItemParam> itemList(ItemQuery itemQuery){
        return managerItemParamService.itemList(itemQuery);
    }
    //判断商品规格信息是否有重复的数据
    @RequestMapping({"item/param/query/{itemCatId}","item/param/query/itemcatid/{itemCatId}"})
    @ResponseBody
    public EgoResult queryItemParamByItemCatId(@PathVariable Long itemCatId){
        return managerItemParamService.queryItemParamByItemCatId(itemCatId);
    }
    //新增商品信息,保存按钮
    @RequestMapping("item/param/save/{itemCatId}")
    @ResponseBody
    public EgoResult saveItem(@PathVariable Long itemCatId,String paramData){
        return managerItemParamService.saveItem(itemCatId,paramData);
    }
    //批量删除商品规格信息
    @RequestMapping("item/param/delete")
    @ResponseBody
    public EgoResult deleteItemParam(Long[] ids){
        return managerItemParamService.deleteItemParamBatch(ids);
    }


}
