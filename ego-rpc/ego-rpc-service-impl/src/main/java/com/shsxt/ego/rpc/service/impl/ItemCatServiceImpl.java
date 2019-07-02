package com.shsxt.ego.rpc.service.impl;

import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemCatMapper;
import com.shsxt.ego.rpc.service.IItemCatService;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/2 0002.
 */
@Service
public class ItemCatServiceImpl implements IItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TreeDto> queryItemCatsByParentId(Long id) {
  //获取父节点目录
        return tbItemCatMapper.queryItemCatsByParentId(id);
    }
}
