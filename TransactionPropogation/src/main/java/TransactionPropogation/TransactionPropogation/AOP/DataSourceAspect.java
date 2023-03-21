package TransactionPropogation.TransactionPropogation.AOP;

import java.lang.reflect.Proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {

	@Around("target(javax.sql.DataSource)")
	public Object datasourceconnectioninfo(ProceedingJoinPoint proceddingJoinPoint) throws Throwable {
		String name = proceddingJoinPoint.getSignature().getName();
		Object proceed = proceddingJoinPoint.proceed();
		System.out.println("DataSource Tracker: " + name);
		System.out.println("procced: " + proceed);
		
		return proceed;

	}

}
