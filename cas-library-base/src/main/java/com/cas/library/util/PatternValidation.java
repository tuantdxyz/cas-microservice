package com.cas.library.util;

import java.util.regex.Pattern;

public class PatternValidation {

	public static final String NAME_STRING = "([a-zA-Z0-9.\\ _;=/\\-]){2,250}";

	public static boolean validPattern(String pattern, String input) {
		Pattern patt = Pattern.compile(pattern);
		return patt.matcher(input).matches();
	}

}
