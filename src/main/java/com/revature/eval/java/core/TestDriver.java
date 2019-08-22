package com.revature.eval.java.core;

public class TestDriver {

	public static void main(String[] args) {
		
		EvaluationService eval = new EvaluationService();
		String testString = "Apple Bottom Jeans";
		
		
		System.out.println(eval.acronym(testString));
	}

}
