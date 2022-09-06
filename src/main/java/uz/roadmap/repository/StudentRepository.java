package uz.roadmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.roadmap.entity.model.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    //
}
