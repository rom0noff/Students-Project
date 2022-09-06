package uz.roadmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.roadmap.entity.model.FileStorage;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
}
