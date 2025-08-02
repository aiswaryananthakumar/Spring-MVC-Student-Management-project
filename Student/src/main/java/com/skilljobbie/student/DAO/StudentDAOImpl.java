package com.skilljobbie.student.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.skilljobbie.student.StudentBO.StudentBO;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public void create(StudentBO student) {
    	 KeyHolder keyHolder = new GeneratedKeyHolder();
         
        String sql = "INSERT INTO students (name, email, dept, gender, phone, address, dob, blood_group, nationality) "
                   + "VALUES (:name, :email, :dept, :gender, :phone, :address, :dob, :bloodGroup, :nationality)";
        template.update(sql, getSqlParamterSource(student), keyHolder);
    }
    
    @Override
    public List<StudentBO> getAllStudents() {
        String sql = "SELECT * FROM students";
        return template.query(sql, new StudentRowMapper());
    }
    
    @Override
    public StudentBO getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return template.queryForObject(sql, params, new StudentRowMapper());
    }
    
    @Override
    public void updateStudent(StudentBO student) {
        String sql = "UPDATE students SET name = :name, email = :email, dept = :dept, gender = :gender, "
                   + "phone = :phone, address = :address, dob = :dob, blood_group = :bloodGroup, nationality = :nationality "
                   + "WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", student.getId());
        params.addValue("name", student.getName());
        params.addValue("email", student.getEmail());
        params.addValue("dept", student.getDept());
        params.addValue("gender", student.getGender());
        params.addValue("phone", student.getPhone());
        params.addValue("address", student.getAddress());
        params.addValue("dob", student.getDob());
        params.addValue("bloodGroup", student.getBloodGroup());
        params.addValue("nationality", student.getNationality());

        template.update(sql, params);
    }
    
    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        template.update(sql, params);
    }

        public SqlParameterSource getSqlParamterSource(StudentBO student) {
        	MapSqlParameterSource param = new MapSqlParameterSource();
        	param.addValue("name", student.getName());
            param.addValue("email", student.getEmail());
            param.addValue("dept", student.getDept());
            param.addValue("gender", student.getGender());
            param.addValue("phone", student.getPhone());
            param.addValue("address", student.getAddress());
            param.addValue("dob", student.getDob());
            param.addValue("bloodGroup", student.getBloodGroup());
            param.addValue("nationality", student.getNationality()); 
            return param;
        }   
        
        public static final class StudentRowMapper implements RowMapper<StudentBO> {
            @Override
            public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
                StudentBO student = new StudentBO();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDept(rs.getString("dept"));
                student.setGender(rs.getString("gender"));
                student.setPhone(rs.getString("phone"));
                student.setAddress(rs.getString("address"));
                student.setDob(rs.getString("dob"));
                student.setBloodGroup(rs.getString("blood_group"));
                student.setNationality(rs.getString("nationality"));
                return student;
          }
     }
}

	