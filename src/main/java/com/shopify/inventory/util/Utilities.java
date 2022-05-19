package com.shopify.inventory.util;

public class Utilities {

	public static boolean validateString(String str) {
	      str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if(ch == ' ') {
	        	 continue;
	         }
	         if (!(ch >= 'a' && ch <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	}
}
