package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.dto.TbItemParamDto1;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemParamItemMapper;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemParamMapper;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public PageResult<TbItemParam> queryItemsListByParams(ItemQuery itemQuery) {
        //启动分页
        PageHelper.startPage(itemQuery.getPage(),itemQuery.getRows());
        List<TbItemParam> itemList = itemParamMapper.queryItemsByParams(itemQuery);
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(itemList);
        PageResult<TbItemParam> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return  pageResult;
    }
}
