package com.shsxt.ego.manager.service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.common.utils.IDUtils;
import com.shsxt.ego.manager.service.IManagerItemService;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.pojo.TbItemParamItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ManagerItemServiceImpl implements IManagerItemService {
    //注入代理类
    @Resource
    private IItemService itemServiceProxy;
    //分页查询的方法
    @Override
    public PageResult<TbItem> itemList(ItemQuery itemQuery) {
        return itemServiceProxy.queryItemsListByParams(itemQuery);
    }
//商品上架
    @Override
    public EgoResult reshelf(Long[] ids) {
        //通过代理类,获得想要的服务,调用service层的实现方法
        return itemServiceProxy.updateItemStatusBatch(ids,1);

    }
//商品下架
    @Override
    public EgoResult instock(Long[] ids) {
        //通过代理类,获得想要的服务,调用service层的实现方法
        return itemServiceProxy.updateItemStatusBatch(ids,2);
    }
    //商品批量删除
    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        return itemServiceProxy.deleteItemBatch(ids);
    }
//新增 商品信息
    @Override
    public EgoResult saveItem(TbItem item, String desc,String paramData) {
        //设置商品id,uuid保证商品id不重复
        Long itemId = IDUtils.genItemId();//工具类生成id值
        Date time = new Date();//当前时间对象
        item.setId(itemId);//设置id值
        item.setCreated(time);//设置当前时间
        item.setUpdated(time);//设置当前时间
        item.setStatus((byte) 1);//设置状态码
        TbItemDesc itemDesc = new TbItemDesc();//商品描述对象
        itemDesc.setItemId(itemId);//
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(time);
        itemDesc.setUpdated(time);
        //商品规格记录
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(paramData);
        itemParamItem.setUpdated(time);
        itemParamItem.setCreated(time);
        return itemServiceProxy.saveItem(item,itemDesc,itemParamItem);
    }


}
