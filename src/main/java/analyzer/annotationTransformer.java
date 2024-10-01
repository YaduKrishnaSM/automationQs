package analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class annotationTransformer implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation annotation, Class testClass,Constructor tetConstructor,Method testMethod) 
	{
		
		annotation.setRetryAnalyzer(retryAnalyzer.class);
		
	}

}
