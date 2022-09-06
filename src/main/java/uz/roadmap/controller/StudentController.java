package uz.roadmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.roadmap.entity.model.Students;
import uz.roadmap.service.StudentService;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController{
    //
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody Students students){
        return ResponseEntity.ok(studentService.save(students));
    }
    @GetMapping("/showAll")
    public ResponseEntity showAllInfo(Pageable pageable){
        return ResponseEntity.ok(studentService.findAll(pageable));
    }
    @GetMapping("/showId")
    public ResponseEntity showIdInfo(@RequestBody Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @PutMapping("/change")
    public ResponseEntity changeInfo(@RequestBody Students students){
        Optional<Students> show = studentService.findById(students.getId());
        if(students.getBirthdate() != null){
            show.get().setBirthdate(students.getBirthdate());
        }
        if(students.getCreated_at() != null){
            show.get().setCreated_at(students.getCreated_at());
        }
        if(students.getDescription() != null){
            show.get().setDescription(students.getDescription());
        }
        if(students.getFirst_name() != null){
            show.get().setFirst_name(students.getFirst_name());
        }
        if(students.getGender() != null){
            show.get().setGender(students.getGender());
        }
        if(students.getLast_name() != null){
            show.get().setLast_name(students.getLast_name());
        }
        if(students.getMiddle_name() != null){
            show.get().setMiddle_name(students.getMiddle_name());
        }
        if(students.getStudy_state_date() != null){
            show.get().setStudy_state_date(students.getStudy_state_date());
        }
        if(students.getStudy_end_date() != null){
            show.get().setStudy_end_date(students.getStudy_end_date());
        }
        return ResponseEntity.ok(studentService.save(show.get()));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteInfo(){
        return ResponseEntity.ok(studentService.deletedAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteById(id));
    }
}
