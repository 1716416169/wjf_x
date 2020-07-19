package com.wjfnews.wjf_x.admin.controller;

import io.swagger.models.auth.In;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("admin")
public class fileUploadController {

    @Value("${ftp.ipPath}")
    public String ipPath;

    @Value("${ftp.port}")
    public Integer port;

    @Value("${ftp.user}")
    public String user;

    @Value("${ftp.password}")
    public String password;

    @Value("${ftp.upLoadPath}")
    public String upLoadPath;
        @PostMapping("fileUpload")
        public HashMap<Object, Object> fileUpload(MultipartFile file) throws Exception {
            System.out.println(ipPath+"   "+port+"   "+user+"   "+password);

            String oldFileName = file.getOriginalFilename();
            String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + eName;
            InputStream Stream = file.getInputStream();
            Path directory = Paths.get("pic/");
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
                System.out.println(directory);
            }
            Files.copy(Stream, directory.resolve(newFileName));
            File path = new File(directory.resolve(newFileName).toString());

            //1、连接ftp服务器
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(ipPath, port);
            //2、登录ftp服务器
            ftpClient.login(user, password);
            //3、读取本地文件
            FileInputStream inputStream = new FileInputStream(path);
            //4、上传文件
            //1）指定上传目录
            ftpClient.changeWorkingDirectory(upLoadPath);
            //2）指定文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //第一个参数：文件在远程服务器的名称
            //第二个参数：文件流
            ftpClient.storeFile(newFileName, inputStream);
            //5、退出登录
            ftpClient.logout();
            HashMap<Object, Object> objectHashMap = new HashMap<>();
            objectHashMap.put("src","http://47.93.234.52:80/img/"+newFileName);
            return objectHashMap;
        }

    @PostMapping("fileUploadToLocation")
    public HashMap<Object, Object> fileUploadToLocation(MultipartFile file) throws IOException {
        String oldFileName = file.getOriginalFilename();
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + eName;
        InputStream inputStream = file.getInputStream();
        Path directory = Paths.get("pic/");
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
            System.out.println(directory);
        }
        Files.copy(inputStream, directory.resolve(newFileName));

        File path = new File(directory.resolve(newFileName).toString());
        String canonicalPath = path.getCanonicalPath();
        System.out.println("绝对路径："+canonicalPath);
        System.out.println("相对路劲："+directory.resolve(newFileName).toString());
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("src",canonicalPath);
        return objectHashMap;
    }
}
