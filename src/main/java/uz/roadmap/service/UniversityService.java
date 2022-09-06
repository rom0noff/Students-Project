package uz.roadmap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.roadmap.entity.model.University;
import uz.roadmap.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    //
    @Autowired
    private UniversityRepository universityRepository;

    public University save(University university){
        return universityRepository.save(university);
    }
    public List<University> findAll(){
        return (List<University>) universityRepository.findAll();
    }
    public Optional<University> findById(Long id){
        return universityRepository.findById(id);
    }
    public String deleteAll(){
        universityRepository.deleteAll();
        return "deletedAll";
    }
    public String deleteId(Long id){
        universityRepository.deleteById(id);
        return id + " deleted";
    }
}
