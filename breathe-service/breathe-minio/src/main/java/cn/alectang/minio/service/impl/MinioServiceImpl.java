package cn.alectang.minio.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.minio.config.MinioProperties;
import cn.alectang.minio.service.MinioService;
import cn.alectang.minio.utils.FileTypeUtils;
import cn.alectang.minio.utils.MinioUtil;
import io.minio.MinioClient;
import io.minio.messages.Bucket;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @Author crush
 * @Date 2021/7/25 9:58
 * @Description: MinioServiceImpl
 */
@Service
public class MinioServiceImpl implements MinioService {

    private final MinioUtil minioUtil;
    private final MinioClient minioClient;
    private final MinioProperties minioProperties;

    public MinioServiceImpl(MinioUtil minioUtil, MinioClient minioClient, MinioProperties minioProperties) {
        this.minioUtil = minioUtil;
        this.minioClient = minioClient;
        this.minioProperties = minioProperties;
    }

    @Override
    public boolean bucketExists(String bucketName) {
        return minioUtil.bucketExists(bucketName);
    }


    @Override
    public void makeBucket(String bucketName) {
        minioUtil.makeBucket(bucketName);
    }

    @Override
    public List<String> listBucketName() {
        return minioUtil.listBucketNames();
    }

    @Override
    public List<Bucket> listBuckets() {
        return minioUtil.listBuckets();
    }

    @Override
    public boolean removeBucket(String bucketName) {
        return minioUtil.removeBucket(bucketName);
    }


    @Override
    public List<String> listObjectNames(String bucketName) {
        return minioUtil.listObjectNames(bucketName);
    }


    @Override
    public String putObject(MultipartFile file, String bucketName) {
        String fileType = FileTypeUtils.getFileType(file);
        if (fileType == null) {
            throw new BreatheException(20001,"不支持的文件格式。请确认格式,重新上传！！！");
        }
        try {
            bucketName = StringUtils.isNotBlank(bucketName) ? bucketName : minioProperties.getBucketName();
            if (!this.bucketExists(bucketName)) {
                this.makeBucket(bucketName);
            }
            String fileName = file.getOriginalFilename();

            String objectName = UUID.randomUUID().toString().replaceAll("-", "")
                    + fileName.substring(fileName.lastIndexOf("."));
            minioUtil.putObject(bucketName, file, objectName,fileType);
            return minioProperties.getEndpoint()+"/"+bucketName+"/"+objectName;
        } catch (Exception e) {
            throw new BreatheException(20001,"上传失败");
        }
    }

    @Override
    public InputStream downloadObject(String bucketName, String objectName) {
        return minioUtil.getObject(bucketName,objectName);
    }

    @Override
    public boolean removeObject(String bucketName, String objectName) {
        return minioUtil.removeObject(bucketName, objectName);
    }

    @Override
    public boolean removeListObject(String bucketName, List<String> objectNameList) {
        return minioUtil.removeObject(bucketName,objectNameList);
    }

    @Override
    public String getObjectUrl(String bucketName,String objectName) {
        return minioUtil.getObjectUrl(bucketName, objectName);
    }
}