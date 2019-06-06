package tn.isetso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tn.isetso.dao.MembreRepository;
import tn.isetso.service.AccountService;
import tn.isetso.service.S3Services;

@RestController
public class UploadFileController {

    @Autowired
    S3Services s3Services;
    @Autowired
    AccountService accountService;

    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file , @RequestParam("userId") Long id , @RequestParam("type") String type) {
        String keyName = file.getOriginalFilename();
        s3Services.uploadFile(keyName, file);
        accountService.updateImageUser(keyName,id,type);
        System.out.println(keyName);
        return "Upload Successfully";
    }
}

