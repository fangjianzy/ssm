package com.fangjian.framework.controller;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**   
 * 类名称：ControllerLogAspect   </br>
 * 类描述： springmvc拦截操作方法名的Aspect  </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 上午10:46:20   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 上午10:46:20   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
@Aspect
@Component
public class ControllerLogAspect {

	/***
	 * 日志操作类
	 */
	private static Logger logger=Logger.getLogger(ControllerLogAspect.class);
	
	/***
	 * @description 	AOP拦截器在方法执行前触发
	 * @param point	横切信息		
	 */
//	@Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void beforeMethod(JoinPoint point) {
		String clazzName = point.getTarget().getClass().getName();  
		String methodName = point.getSignature().getName();
		//logger.info("开始执行：类名: " + clazzName+ "  方法名:" + methodName + "()");
		System.out.println("开始执行：类名: " + clazzName+ "  方法名:" + methodName + "()");
	}
	
	/***
	 * @description 					执行方法嵌入AOP拦截器中，在方法执行前触发
	 * @param thisJoinPoint		横切信息
	 * @throws Throwable
	 */
//	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//	public void around(ProceedingJoinPoint thisJoinPoint) throws Throwable {
//		String clazzName = thisJoinPoint.getTarget().getClass().getName();  
//		String methodName = thisJoinPoint.getSignature().getName();  
//
////		// 计时并调用目标函数
//		long start = System.currentTimeMillis();
//		thisJoinPoint.proceed();
//		long time = System.currentTimeMillis() - start;
//		// 输出计时信息
//		System.out.println("操作计时：" + time + "ms  类名: " + clazzName+ "  方法名:" + methodName + "()");
//    }
 	
	/***
	 * @description		AOP拦截器在方法执行后触发
	 * @param point		横切信息
	 */
//	@After("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void afterMethod(JoinPoint point) {
		String clazzName = point.getTarget().getClass().getName();  
		String methodName = point.getSignature().getName();
		//logger.info("完成执行：类名: " + clazzName+ "  方法名:" + methodName + "()");
		System.out.println("完成执行：类名: " + clazzName+ "  方法名:" + methodName + "()");
    }

}

