package uz.roadmap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.roadmap.entity.entity.FileStorageStatus;
import uz.roadmap.entity.model.FileStorage;
import uz.roadmap.repository.FileStorageRepository;

@Service
public class FileStorageService {
    //
    @Autowired
    private FileStorageRepository fileStorageRepository;

    public void save(MultipartFile multipartFile){
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setStorageStatus(FileStorageStatus.DRAFT);
        fileStorageRepository.save(fileStorage);
    }

    public String getExt(String fileName){
        String ext = null;
        if(fileName != null && fileName.isEmpty()){
            int dot = fileName.lastIndexOf('.');
            if(dot > 0 && dot <= fileName.length() - 2){
                ext = fileName.substring(dot + 1);
            }
        }
        return ext;
    }
}
