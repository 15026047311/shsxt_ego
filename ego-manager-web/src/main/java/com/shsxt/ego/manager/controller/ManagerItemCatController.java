package com.shsxt.ego.manager.controller;

import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.service.IItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/2 0002.
 */
@Controller
public class ManagerItemCatController {
    @Resource
    //注入代理类
    private IItemCatService itemCatServiceProxy;
    @RequestMapping("item/cat/list")
    @ResponseBody
    public List<TreeDto> queryItemCatsByParentId(@RequestParam(defaultValue = "0") Long id ){
        return itemCatServiceProxy.queryItemCatsByParentId(id);
    }

}
