package uz.roadmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.roadmap.entity.model.Field;
import uz.roadmap.service.FieldService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/field")
public class FieldController {
    //
    @Autowired
    private FieldService fieldService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody Field field){
        return ResponseEntity.ok(fieldService.save(field));
    }
    @GetMapping("/showAll")
    public ResponseEntity showAllInfo(){
        return ResponseEntity.ok(fieldService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showIdInfo(@RequestBody Long id){
        return ResponseEntity.ok(fieldService.findById(id));
    }
    @PutMapping("/change")
    public ResponseEntity changeInfo(@RequestBody Field field){
        Optional<Field> show = fieldService.findById(field.getId());
        if(field.getName() != null){
            show.get().setName(field.getName());
        }
        return ResponseEntity.ok(fieldService.save(show.get()));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInfo(){
        return ResponseEntity.ok(fieldService.deleteAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(fieldService.deleteId(id));
    }
}
