package ptm.home.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppAOP {
	
	private static final Logger LOGGER = LogManager.getLogger(AppAOP.class);
	

//	@Pointcut("execution(* com.ptm.web.controller.LoginNRoleController.*(..))")
//	public void k() { }// pointcut name

//	@Before("k()") // applying pointcut on after advice 
//	public void myadvice(JoinPoint jp) {
//		System.out.println("------------additional concern---------" + jp.getSignature().getName()); 
//		System.out.println("Method Signature: " + jp.getSignature());
//	}

//	@Before("within(org.springframework..*)") public void
//	logBeforeAllMethods(JoinPoint joinPoint) {
//		System.out.println("------AOP before within ----" +
//				joinPoint.getSignature().getName()); }

//	@Before("execution(* com.ptm.main..*(..))") 
//	public void inWebLayer(JoinPoint joinPoint) { 
//		System.out.println("------AOP before execution ----" + joinPoint.getSignature().getName()); 
//	}


//	@Around("within(com.ptm.web..*)")
	/*
	 * @Around("execution(* com.ptm.web..*(..)))") public Object
	 * logBeforeAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	 * { MethodSignature methodSignature = (MethodSignature)
	 * proceedingJoinPoint.getSignature();
	 * 
	 * //Get intercepted method details String className =
	 * methodSignature.getDeclaringType().getSimpleName(); String methodName =
	 * methodSignature.getName();
	 * 
	 * final StopWatch stopWatch = new StopWatch();
	 * 
	 * //Measure method execution time stopWatch.start(); Object result =
	 * proceedingJoinPoint.proceed(); stopWatch.stop(); Long exeTime =
	 * stopWatch.getTotalTimeMillis(); //Log method execution time
	 * LOGGER.info("Execution time of " + className + "." + methodName + " :: " +
	 * exeTime + " ms"); return result; }
	 */
}
