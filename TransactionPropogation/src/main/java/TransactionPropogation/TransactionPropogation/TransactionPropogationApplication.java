package TransactionPropogation.TransactionPropogation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import TransactionPropogation.TransactionPropogation.Service.StudentService;

public class TransactionPropogationApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfiguration.class);
		StudentService studentService = (StudentService) context.getBean("studentService", StudentService.class);
		studentService.saveStudent();
		((AbstractApplicationContext) context).close();
	}
}
