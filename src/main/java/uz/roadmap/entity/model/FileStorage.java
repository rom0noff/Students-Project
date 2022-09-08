package uz.roadmap.entity.model;

import lombok.*;
import uz.roadmap.entity.entity.FileStorageStatus;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "fileStorage")
public class FileStorage implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String extension;
    private Long fileSize;
    private String contentType;
    private String uploadPath;
    private FileStorageStatus storageStatus;
}
