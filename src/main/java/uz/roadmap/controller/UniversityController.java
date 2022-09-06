package uz.roadmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.roadmap.entity.model.University;
import uz.roadmap.service.UniversityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/university")
public class UniversityController {
    //
    @Autowired
    private UniversityService universityService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody University university){
        return ResponseEntity.ok(universityService.save(university));
    }
    @GetMapping("/showAll")
    public ResponseEntity showAllInfo(){
        return ResponseEntity.ok(universityService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showIdInfo(@RequestBody Long id){
        return ResponseEntity.ok(universityService.findById(id));
    }
    @PutMapping("/change")
    public ResponseEntity changeInfo(@RequestBody University university){
        Optional<University> show = universityService.findById(university.getId());
        if(university.getName() != null){
            show.get().setName(university.getName());
        }
        return ResponseEntity.ok(universityService.save(show.get()));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInfo(){
        return ResponseEntity.ok(universityService.deleteAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(universityService.deleteId(id));
    }

}
