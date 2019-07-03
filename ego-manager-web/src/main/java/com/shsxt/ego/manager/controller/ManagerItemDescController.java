package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.service.IItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Controller
public class ManagerItemDescController {
    @Resource//用Autowired报错
    private IItemDescService itemDescServiceProxy;
    @RequestMapping("/item/desc/{itemId}")
    @ResponseBody
    public EgoResult queryItemDescByItemId(@PathVariable Long itemId){
        EgoResult egoResult = new EgoResult();
        TbItemDesc itemDesc = itemDescServiceProxy.queryItemDescByItemId(itemId);
        if (null != itemDesc){
            egoResult.setData(itemDesc);
        }else{
            egoResult.setStatus(500);
            egoResult.setMsg("记录不存在");
        }
        return egoResult;
    }

}
