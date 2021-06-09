package np.pangait.restservice.service;

import np.pangait.restservice.dao.StudentDao;
import np.pangait.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mysql") StudentDao studentDao) {

        this.studentDao = studentDao;
    }

    public int addStudent(Student student) {
       // studentDao.insertStudent(student);
        return studentDao.insertStudent(student);
       // return student.getId();
    }

    public List<Student> getAllStudent() {
        return studentDao.selectAllStudent();
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentDao.selectStudentById(id);
    }
    public int deleteStudent(UUID id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(UUID id, Student newStudent) {
        return studentDao.updateStudentById(id, newStudent);
    }
}