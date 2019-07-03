package com.shsxt.ego.manager.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.shsxt.ego.common.model.PictureResult;
import com.shsxt.ego.manager.service.IManagerFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Service
public class ManagerFileServiceImpl implements IManagerFileService {
    private String ak ="3K77OJ214syThkwIbX8skAMHcEYmZJuqGcTSEEW1";//访问
    private String sk = "DpQoXLAfJWJJblp-kdBm4t573Tzf_cEmq6xLoFW3";//密钥
    private String bucket = "20190701";//访问名称
    private String basePath="http://pty9die0h.bkt.clouddn.com/";//公共地址
    @Override
    public PictureResult uploadFile(MultipartFile mf) {
        PictureResult result = new PictureResult();//返回状态
        try {
            if (null != mf && mf.getSize() > 0) {//判断上传到服务器的图片状态
                Configuration cfg = new Configuration(Zone.zone0());//配置上传图片的参数
                UploadManager uploadManager = new UploadManager(cfg);//上传图片的管理对象
                String fileName = mf.getOriginalFilename();//获取图片名称
                String ext = fileName.substring(fileName.lastIndexOf("."));// 切割,以.切割文件后缀
                String key = System.currentTimeMillis() + ext;//存储文件的key值,以文件名+当前时间
                Auth auth = Auth.create(ak, sk);//创建访问对象
                String upToken = auth.uploadToken(bucket);//访问存储空间的名称
                Response response = uploadManager.put(mf.getInputStream(), key, upToken, null, null);//上传到七牛服务器的图片成功后,响应图片
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);//通过json响应数据
                result.setError(0);//成功
                result.setMessage("ok");//前台响应
                result.setUrl(basePath+key);//七牛公共地址+ 图片的名称,返回地址
            }else{
                result.setError(1);//失败
                result.setMessage("error");//错误页面
                result.setUrl("");//返回空地址
            }
        } catch (Exception e) {
            e.printStackTrace();//打印错误信息
            result.setError(1);
            result.setMessage("error");
            result.setUrl("");
        }
        return result;//返回结果对象
    }
}
