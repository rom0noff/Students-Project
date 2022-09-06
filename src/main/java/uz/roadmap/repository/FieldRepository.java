package uz.roadmap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.roadmap.entity.model.Field;

@Repository
public interface FieldRepository extends CrudRepository<Field, Long> {
    //
}
