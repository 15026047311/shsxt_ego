package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerItemService;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/7/1 0001.
 */
@Controller
public class ManagerItemController {
    @Resource
    private IManagerItemService managerItemService;
    //分页查询
    @RequestMapping("item/list")
    @ResponseBody
    public PageResult<TbItem> itemList(ItemQuery itemQuery){
        return managerItemService.itemList(itemQuery);
    }
//商品的上架
    @RequestMapping("item/reshelf")
    @ResponseBody
    public EgoResult reshelf(Long[] ids){
        return managerItemService.reshelf(ids);
    }
    //商品下架
    @RequestMapping("item/instock")
    @ResponseBody
    public EgoResult instock(Long[] ids){
        //调用商品展示方法
        return  managerItemService.instock(ids);
    }
    @RequestMapping("item/delete")
    @ResponseBody
    public EgoResult delete(Long[] ids){
        return managerItemService.deleteItemBatch(ids);
    }
    //商品保存
    @RequestMapping("item/save")
    @ResponseBody
    public EgoResult save(TbItem item,String desc,String itemParams){
        return managerItemService.saveItem(item,desc,itemParams);
    }
}
