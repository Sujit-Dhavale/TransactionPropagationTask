package TransactionPropogation.TransactionPropogation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import TransactionPropogation.TransactionPropogation.DAO.StudentDao;
import TransactionPropogation.TransactionPropogation.Entity.Student;

@Component
public class StudentService {

	@Autowired
	StudentDao studentDao;

	 @Transactional
	public void saveStudent() {
		for (int i = 35; i < 40; i++) {
			studentDao.saveStudent(new Student(i, "visahl", "Pune"));
			System.out.println("student saved");
		}
	}
}
