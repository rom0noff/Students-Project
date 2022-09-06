package uz.roadmap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.roadmap.entity.model.Students;
import uz.roadmap.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    //
    @Autowired
    private StudentRepository studentRepository;

    public Students save(Students students){
        return studentRepository.save(students);
    }
    public List<Students> findAll(){
        return (List<Students>) studentRepository.findAll();
    }
    public Optional<Students> findById(Long id){
        return studentRepository.findById(id);
    }
    public String deletedAll(){
        studentRepository.deleteAll();
        return "deleted ALl";
    }
    public String deleteById(Long id){
        studentRepository.deleteById(id);
        return id + " deleted";
    }

    public Page<Students> findAll(Pageable pageable){
        return studentRepository.findAll(pageable);
    }
}
