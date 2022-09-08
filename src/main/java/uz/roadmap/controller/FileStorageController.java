package uz.roadmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.roadmap.service.FileStorageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileStorageController {
    //
    @Autowired
    private FileStorageService fileStorageService;
    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestParam("file")MultipartFile multipartFile) throws IOException {
            fileStorageService.save(multipartFile);
            return ResponseEntity.ok(multipartFile.getOriginalFilename());
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        return ResponseEntity.ok(fileStorageService.deleteAll());
    }
}
