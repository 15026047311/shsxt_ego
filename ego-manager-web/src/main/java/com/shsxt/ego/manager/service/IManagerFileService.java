package com.shsxt.ego.manager.service;

import com.shsxt.ego.common.model.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
public interface IManagerFileService {
    public PictureResult uploadFile(MultipartFile mf);

}
