package com.siemens.eadvantage.util;

public class ArgumentValidationUtils {
	
	private ArgumentValidationUtils() { }
	
	public static void validateStringArgument(String argument, int minLength, int maxLength) {
		
		if(argument == null) throw new IllegalArgumentException("argument must not be null");
		
		if(argument.length()<minLength||argument.length()>maxLength) {
			String argumentName = argument.getClass().getName();
			throw new IllegalArgumentException(argumentName +  " length must be " + minLength + "-" + maxLength + " characters");
		}
		
	}
	
	public static void validateNotNull(Object argument) {
		if(argument == null) throw new IllegalArgumentException("One or more arguments is null");
	}
	
	public static boolean isValidStringArgument(String argument, int minLength, int maxLength) {
		if(argument == null) return false;
		if(argument.length()<minLength||argument.length()>maxLength) return false;
		return true;
	}
	
}
