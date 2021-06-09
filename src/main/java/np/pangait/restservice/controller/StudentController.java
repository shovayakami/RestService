package np.pangait.restservice.controller;

import np.pangait.restservice.model.Student;
import np.pangait.restservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@NonNull @RequestBody Student student){
        studentService.addStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") UUID id){
        return studentService.getStudentById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") UUID id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") UUID id, @NonNull @RequestBody Student studentToUpdate) {
        studentService.updateStudent(id, studentToUpdate);
    }
}
