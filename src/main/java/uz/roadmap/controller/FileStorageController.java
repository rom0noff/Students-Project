package uz.roadmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.roadmap.service.FileStorageService;

@RestController
@RequestMapping("/api/file")
public class FileStorageController {
    //
    @Autowired
    private FileStorageService fileStorageService;
    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestParam("file")MultipartFile multipartFile){
            fileStorageService.save(multipartFile);
            return ResponseEntity.ok(multipartFile.getOriginalFilename());
    }
}
