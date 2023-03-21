package TransactionPropogation.TransactionPropogation.DAO;

import java.util.List;

import TransactionPropogation.TransactionPropogation.Entity.Student;

public interface StudentDao {

	public void saveStudent(Student stu);

	public String updateStudent(Student stu, int id);

	public String deleteStudent(int id);

	public List<Student> getAllStudent();

}
