package np.pangait.restservice.mapper;

import np.pangait.restservice.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student(
                UUID.fromString(rs.getString("id")),
                rs.getString("name")
        );
        return student;
    }
}
