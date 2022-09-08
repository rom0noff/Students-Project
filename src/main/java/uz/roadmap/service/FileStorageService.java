package uz.roadmap.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.roadmap.entity.entity.FileStorageStatus;
import uz.roadmap.entity.model.FileStorage;
import uz.roadmap.repository.FileStorageRepository;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileStorageService {
    //

    private final FileStorageRepository fileStorageRepository;


    public FileStorageService( FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public void save(MultipartFile multipartFile) throws IOException {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setStorageStatus(FileStorageStatus.DRAFT);

        File uploadFolder = new File("/Desktop/upload");
            if(!uploadFolder.exists() && uploadFolder.mkdirs()){
                System.out.println("yaratildi");
            }
            fileStorage.setUploadPath(uploadFolder+"/" +fileStorage.getName());
            uploadFolder = uploadFolder.getAbsoluteFile();
            File file = new File(uploadFolder+"/"+ fileStorage.getName());
            try {
                multipartFile.transferTo(file);
            }catch (IOException e){
                e.printStackTrace();
            }
            fileStorageRepository.save(fileStorage);
    }

    public String deleteAll(){
        fileStorageRepository.deleteAll();
        return "deleteAll";
    }

    public String getExt(String fileName){
        String ext = null;
        if(fileName != null && !fileName.isEmpty()){
            int dot = fileName.lastIndexOf('.');
            if(dot > 0 && dot <= fileName.length() - 2){
                ext = fileName.substring(dot + 1);
            }
        }
        return ext;
    }
}
