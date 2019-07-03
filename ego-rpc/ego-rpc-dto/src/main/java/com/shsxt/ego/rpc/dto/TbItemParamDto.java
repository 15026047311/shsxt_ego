package com.shsxt.ego.rpc.dto;

import com.shsxt.ego.rpc.pojo.TbItemParam;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
public class TbItemParamDto extends TbItemParam implements Serializable {
    private String itemCatName;

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }
}
