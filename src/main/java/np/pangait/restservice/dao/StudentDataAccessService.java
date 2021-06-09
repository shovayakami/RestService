package np.pangait.restservice.dao;

import np.pangait.restservice.mapper.StudentRowMapper;
import np.pangait.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("mysql")
public class StudentDataAccessService implements StudentDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertStudent(UUID id, Student student) {
        return 0;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = jdbcTemplate.query("SELECT * from student", new StudentRowMapper());
        return students;
        /* return Stream.of(
                new Student(UUID.randomUUID(), "FROM POSTGRES DB"),
                new Student(UUID.randomUUID(), "FROM POSTGRES DB2")
        ).collect(Collectors.toList()) ; */
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteStudentById(UUID id) {
        return 0;
    }

    @Override
    public int updateStudentById(UUID id, Student student) {
        return 0;
    }
}
