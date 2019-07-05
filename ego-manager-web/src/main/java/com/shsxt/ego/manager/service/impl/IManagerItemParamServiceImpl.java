package com.shsxt.ego.manager.service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.ItemParamService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Service
public class IManagerItemParamServiceImpl implements IManagerItemParamService {
    @Resource
    private ItemParamService itemParamServiceProxy;//代理接口
//分页查询方法
    @Override
    public PageResult<TbItemParam> itemList(ItemQuery itemQuery) {
        return itemParamServiceProxy.queryItemsListByParams(itemQuery);
    }
//判断商品规格信息是否重复
    @Override
    public EgoResult queryItemParamByItemCatId(Long itemCatId) {
        /**
         * 1,存在提示已存在
         * 2.没有的新增数据
         */
        //查询后台数据查看是否已存在
       TbItemParam itemParam = itemParamServiceProxy.queryItemParamByItemCatId(itemCatId);
        EgoResult egoResult = new EgoResult();
        if (null != itemParam){
            egoResult.setData(itemParam);
            egoResult.setMsg("该模板已存在");
        }

        return egoResult;
    }
//保存,新增商品规格信息,id是自增数据
    @Override
    public EgoResult saveItem(Long itemCatId, String paramData) {
        TbItemParam itemParam =new TbItemParam();
        itemParam.setItemCatId(itemCatId);//通过表单新增的数据
        itemParam.setParamData(paramData);//通过表单新增的数据
        itemParam.setCreated(new Date());//
        itemParam.setUpdated(new Date());
        itemParamServiceProxy.saveItem(itemParam);
        return new EgoResult();
    }
//批量删除操作
    @Override
    public EgoResult deleteItemParamBatch(Long[] ids) {
        return itemParamServiceProxy.deleteItemParamBatch(ids);
    }
}
