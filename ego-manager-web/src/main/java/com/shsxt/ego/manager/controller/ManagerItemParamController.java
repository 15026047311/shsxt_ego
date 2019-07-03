package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("item/param/list")
    @ResponseBody
    public PageResult<TbItemParam> itemList(ItemQuery itemQuery){
        return managerItemParamService.itemList(itemQuery);
    }

}
