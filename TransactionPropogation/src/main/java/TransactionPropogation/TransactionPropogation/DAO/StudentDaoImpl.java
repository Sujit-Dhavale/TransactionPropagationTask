package TransactionPropogation.TransactionPropogation.DAO;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import TransactionPropogation.TransactionPropogation.Entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void saveStudent(Student stu) {
		String query = "insert into student(id,name,address) values(?,?,?)";
		int insert = jdbcTemplate.update(query, stu.getId(), stu.getName(), stu.getAddress());
		System.out.println(insert);
	}

	@Override
	public String updateStudent(Student stu, int id) {
		String query = "update student set name=? , address=? where id=?";
		int update = jdbcTemplate.update(query, id, stu.getName(), stu.getAddress());
		System.out.println(+update);
		return "Update Record successfully";
	}

	@Override
	public String deleteStudent(int id) {
		String query = "delete  from student where id=?";
		int delete = jdbcTemplate.update(query, id);
		System.out.println(delete);
		return " Delete Record Successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> list = jdbcTemplate.query(query, new BeanPropertyRowMapper(Student.class));
		return list;
	}
}
