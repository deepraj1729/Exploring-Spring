package com.deepraj1729.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
		
		ApplicationContext appContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		
		int numToSearchFor = 40;
		int[] givenArray = new int[] {12,34,45,675,8,56,4,34,32,40};
		
		/*Hard coded way of instantiating objects by the developer*/
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
		/*Spring way of instantiating objects*/
		BinarySearchImpl bs = appContext.getBean(BinarySearchImpl.class);
		
		int result = bs.binarySearch(givenArray,numToSearchFor);
		System.out.println("Output: "+result);
		
	}

}
