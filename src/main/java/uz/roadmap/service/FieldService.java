package uz.roadmap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.roadmap.entity.model.Field;
import uz.roadmap.entity.model.University;
import uz.roadmap.repository.FieldRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {
    //
    @Autowired
    private FieldRepository fieldRepository;

    public Field save(Field field){
        return fieldRepository.save(field);
    }
    public List<Field> findAll(){
        return (List<Field>) fieldRepository.findAll();
    }
    public Optional<Field> findById(Long id){
        return fieldRepository.findById(id);
    }
    public String deleteAll(){
        fieldRepository.deleteAll();
        return "deletedAll";
    }
    public String deleteId(Long id){
        fieldRepository.deleteById(id);
        return id + " deleted";
    }
}
