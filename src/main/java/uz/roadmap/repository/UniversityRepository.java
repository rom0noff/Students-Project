package uz.roadmap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.roadmap.entity.model.University;

@Repository
public interface UniversityRepository extends CrudRepository<University,Long> {
    //
}
