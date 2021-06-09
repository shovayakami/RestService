package np.pangait.restservice.dao;

import np.pangait.restservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("fakeDao")
public class FakeStudentDataAccessService implements StudentDao {
    private static List<Student> DB = new ArrayList<>();

    @Override
    public int insertStudent(UUID id, Student student) {
        DB.add(new Student(id, student.getName()));
        return 1;
    }
    @Override
    public List<Student> selectAllStudent() {
        return DB;
    }
    @Override
    public Optional<Student> selectStudentById(UUID id) {
        Optional<Student> student = DB.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        return student;
    }

    @Override
    public int deleteStudentById(UUID id) {
        Optional<Student> studentMaybe = selectStudentById(id);
        if (!studentMaybe.isPresent()) {
            return 0;
        }
        DB.remove(studentMaybe.get());
        return 1;
    }
    @Override
    public int updateStudentById(UUID id, Student update) {
        return selectStudentById(id).map(student -> {
            int indexOfStudentToUpdate = DB.indexOf(student);
            if (indexOfStudentToUpdate >= 0) {
                DB.set(indexOfStudentToUpdate, new Student(id, update.getName()));
                return 1;
            }
            return 0;
        })
          .orElse(0);
    }
}
