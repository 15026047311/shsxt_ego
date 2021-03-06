package com.shsxt.ego.rpc.mapper.db.dao;

import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbItemCat;
import sun.reflect.generics.tree.Tree;

import javax.swing.table.TableRowSorter;
import java.util.List;

public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
    List<TreeDto> queryItemCatsByParentId(Long id);
    //portal层前台门户网站显示树形数据
    List<TbItemCat> queryAllItemCats();
}