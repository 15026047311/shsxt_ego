package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.PictureResult;
import com.shsxt.ego.manager.service.IManagerFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Controller
public class ManagerFileController {
    @Autowired
    private IManagerFileService managerFileService;
    @RequestMapping("pic/upload")
    @ResponseBody
    public PictureResult uploadFile02(HttpServletRequest request){
        MultipartHttpServletRequest mhsh = (MultipartHttpServletRequest) request;
        MultipartFile mf = mhsh.getFile("uploadFile");
        return managerFileService.uploadFile(mf);

    }


}
