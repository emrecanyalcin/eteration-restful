package com.restful.eteration.Controller;

import com.restful.eteration.Exception.ResourceNotFoundException;
import com.restful.eteration.Model.Students;
import com.restful.eteration.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return studentsRepository.findAll();
    }

    @PostMapping("/students")
    public Students createStudents(@Validated @RequestBody Students students){
        return studentsRepository.save(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getEmployeeById(@PathVariable(value = "id") int studentsId)
            throws ResourceNotFoundException {
        Students students = studentsRepository.findById(studentsId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentsId));
        return ResponseEntity.ok().body(students);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Students> updateStudents(@PathVariable(value = "id") int studentsId, @RequestBody Students studentsDetails) throws ResourceNotFoundException{

        Students students = studentsRepository.findById(studentsId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentsId));
        students.setName(studentsDetails.getName());
        students.setSurname(studentsDetails.getSurname());
        students.setEmail(studentsDetails.getEmail());
        studentsRepository.save(students);
        final Students updatedStudents = studentsRepository.save(students);
        return ResponseEntity.ok(updatedStudents);

    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudents(@PathVariable(value = "id") int studentsId) throws ResourceNotFoundException{
        Students students = studentsRepository.findById(studentsId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentsId));

        studentsRepository.deleteById(studentsId);
        return ResponseEntity.ok().build();

    }
}
