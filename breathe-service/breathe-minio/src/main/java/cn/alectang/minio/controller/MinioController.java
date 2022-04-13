package cn.alectang.minio.controller;


import cn.alectang.common.utils.R;
import cn.alectang.minio.service.MinioService;
import cn.alectang.minio.utils.FileTypeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author crush
 */
@Api(tags = "minio接口")
@RequestMapping("/minio")
@RestController
public class MinioController {

    private final MinioService minioService;


    public MinioController(MinioService minioService) {
        this.minioService = minioService;
    }

    @ApiOperation("上传文件")
    @PostMapping("/upload/{bucketName}")
    public String uploadFile(MultipartFile file,@PathVariable("bucketName") String bucketName) {

        String url = minioService.putObject(file, bucketName);
        return url;
    }

    //不需要 添加桶
//    @PostMapping("/addBucket/{bucketName}")
//    public String addBucket(@PathVariable String bucketName) {
//        minioService.makeBucket(bucketName);
//        return "创建成功！！！";
//    }

//    @GetMapping("/show/{bucketName}")
//    public List<String> show(@PathVariable String bucketName) {
//        return minioService.listObjectNames(bucketName);
//    }
//
//    @GetMapping("/showBucketName")
//    public List<String> showBucketName() {
//        return minioService.listBucketName();
//    }

//    @ApiOperation("显示桶中的名字和下载地址")
//    @GetMapping("/showListObjectNameAndDownloadUrl/{bucketName}")
//    public Map<String, String> showListObjectNameAndDownloadUrl(@PathVariable String bucketName) {
//        Map<String, String> map = new HashMap<>();
//        List<String> listObjectNames = minioService.listObjectNames(bucketName);
//        String url = "localhost:8085/minio/download/" + bucketName + "/";
//        listObjectNames.forEach(System.out::println);
//        for (int i = 0; i <listObjectNames.size() ; i++) {
//            map.put(listObjectNames.get(i),url+listObjectNames.get(i));
//        }
//        return map;
//    }

//    @ApiOperation("删除桶")
//    @DeleteMapping("/removeBucket/{bucketName}")
//    public String delBucketName(@PathVariable String bucketName) {
//        return minioService.removeBucket(bucketName) == true ? "删除成功" : "删除失败";
//    }

//    @ApiOperation("删除桶中的对象")
//    @DeleteMapping("/removeObject/{bucketName}/{objectName}")
//    public String delObject(@PathVariable("bucketName") String bucketName, @PathVariable("objectName") String objectName) {
//        return minioService.removeObject(bucketName, objectName) == true ? "删除成功" : "删除失败";
//    }

//    @ApiOperation("删除桶中所有对象")
//    @DeleteMapping("/removeListObject/{bucketName}")
//    public String delListObject(@PathVariable("bucketName") String bucketName, @RequestBody List<String> objectNameList) {
//        return minioService.removeListObject(bucketName, objectNameList) == true ? "删除成功" : "删除失败";
//    }

    @ApiOperation("下载桶中的对象")
    @RequestMapping("/download/{bucketName}/{objectName}")
    public void download(HttpServletResponse response, @PathVariable("bucketName") String bucketName, @PathVariable("objectName") String objectName) {
        InputStream in = null;
        try {
            in = minioService.downloadObject(bucketName, objectName);
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(objectName, "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            //将字节从InputStream复制到OutputStream 。
            IOUtils.copy(in, response.getOutputStream());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
