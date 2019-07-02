package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemDescMapper;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemMapper;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemParamItemMapper;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/1 0001.
 */

/**
 * service层提供
 * 1.实现service层接口的方法
 */
@Service
public class ItemServiceImpl implements IItemService {
     @Autowired
    private TbItemMapper itemMapper;//mapper的dao层商品信息
    @Autowired
    private TbItemDescMapper itemDescMapper;//mapper的dao层商品信息
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;//mapper的dao层商品信息
    @Override
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery){
        //启动分页
        PageHelper.startPage(itemQuery.getPage(),itemQuery.getRows());
        List<TbItem> itemList = itemMapper.queryItemsByParams(itemQuery);
        PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
        PageResult<TbItem> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return  pageResult;
    }
//重写商品的上架和下架,跟新状态码
    @Override
    public EgoResult updateItemStatus(TbItem item) {
        itemMapper.updateByPrimaryKeySelective(item);//调用mapper层更新方法
        return new EgoResult();//返回是否成功的状态
    }
//批量更新
    @Override
    public EgoResult updateItemStatusBatch(Long[] ids, int type) {
        Map<String,Object> param=new HashMap<>();
        param.put("ids",ids);//
        param.put("type",type);//状态类型1,上架,2,下架,3,删除
        itemMapper.updateItemStatusBatch(param);
        return new EgoResult();
    }
//批量删除
    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        /**
         * 包含的表
         * tb_item更新操作
         * tb_item_desc,真删除操作
         * tb_item_param_item真删除操作
         */
        Map<String,Object> param=new HashMap<>();
        param.put("ids",ids);
        itemMapper.deleteItemBatch(param);
        //删除商品的描述记录
        itemDescMapper.deleteItemDescBatch(param);
        //删除商品规格记录
        itemParamItemMapper.deleteItemParamItemBatch(param);
        return new EgoResult();
    }

}
