package com.fisher.upload.web;

import com.fisher.upload.service.IQiNiuService;
import com.fisher.upload.util.QiNiuPutRet;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@RequestMapping("/upload")
@RestController
public class UploadController {

    @Autowired
    private IQiNiuService qiNiuService;

    @Autowired
    private Gson gson;

    /**
     * 图片的上传
     *
     * @param file
     * @return
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String fileName = file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream);
            if (response.isOK()) {
                QiNiuPutRet ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);
                String imageUrl = "http://pkbnsx71f.bkt.clouddn.com/" + ret.key;
                return ResponseEntity.ok(imageUrl);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }


        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        //return ResponseEntity.ok(qiNiuService.uploadFile(file.getInputStream()));
    }

}
