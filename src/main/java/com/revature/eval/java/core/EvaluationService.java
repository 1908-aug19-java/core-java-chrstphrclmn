package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		int length = string.length()-1;
		//System.out.println(length);
		String retString = "";
		
		while(length >= 0) {
			retString = retString.concat(Character.toString(string.charAt(length)));
			//String chara = Character.toString(string.charAt(length));
			//System.out.println(chara);
			
			
			length--;
			//System.out.println(length);
			//System.out.println(retString);
		}
		
		return retString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		String acronym = "";
		Character testChar;
		int len = phrase.length();
		boolean previous = true;
		
		for(int i = 0; i<len; i++) {
			
			testChar = phrase.charAt(i);
			
			if(testChar < 65 || (testChar > 132 && testChar < 141) ||( testChar > 122)) {
				
				previous = true;
				
			}
			else if (previous == true) {
				
				
				acronym = acronym.concat(testChar.toString());
				previous = false;
				
			}
			
			
		}
		
		acronym = acronym.toUpperCase();
		//System.out.println(acronym);
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if(this.getSideOne() == this.getSideTwo() || this.getSideOne() == this.getSideThree() || this.getSideTwo() == this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			if(this.getSideOne() != this.getSideTwo() && this.getSideOne() != this.getSideThree() && this.getSideTwo() != this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		String[] scrab1 = {"A","E","I","O","U","L","N",
				"R","S","T"};
		
		String[] scrab2 = {"D","G"};
		String[] scrab3 = {"B","C","M","P"};
		String[] scrab4 = {"F","H","V","W","Y"};
		String[] scrab5 = {"K",};
		String[] scrab8 = {"X"};
		String[] scrab10 = {"Q","Z"};
		
		String scString = string.toUpperCase();
		int count = 0;
		
		for(int i = 0; i<scString.length();i++) {
			
			String testString = Character.toString(scString.charAt(i));
			//System.out.println(testString);
			
			for(int j = 0;j<scrab1.length;j++) {	
				
				//System.out.println("Hey.");
				if(testString.equals(scrab1[j])) {
					count = count + 1;
				}		
			}
			for(int j = 0;j<scrab2.length;j++) {	
				if(testString.equals(scrab2[j])) {
					count = count + 2;
				}		
			}
			for(int j = 0;j<scrab3.length;j++) {	
				if(testString.equals(scrab3[j])) {
					count = count + 3;
				}		
			}
			for(int j = 0;j<scrab4.length;j++) {	
				if(testString.equals(scrab4[j])) {
					count = count + 4;
				}		
			}
			for(int j = 0;j<scrab5.length;j++) {	
				if(testString.equals(scrab5[j])) {
					count = count + 5;
				}		
			}
			for(int j = 0;j<scrab8.length;j++) {	
				if(testString.equals(scrab8[j])) {
					count = count + 8;
				}		
			}
			for(int j = 0;j<scrab10.length;j++) {	
				if(testString.equals(scrab10[j])) {
					count = count + 10;
				}		
			}
		}
		return count;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
	
		
		//System.out.println(string);
		char[] numArray = string.toCharArray();
		String retString = "";
		
		for(char test: numArray) {
			if(test>47 && test<58) {
				retString = retString.concat(Character.toString(test));
				//System.out.println("Concating "+test);
			}
			else if(test != 32 && test!= 45 && test != 46&& test !=40 && test!=41){
				throw new IllegalArgumentException();
				//System.out.println("Throwing Exception.");
			}
		}
		
		if(retString.length()==11) {
			retString = retString.substring(1);
		}
		else if(retString.length()>11) {
			throw new IllegalArgumentException();
		}
		
		//System.out.println(retString);
		return retString;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		Map<String, Integer> retMap = new HashMap();
		String replace = string.replace("\n", " ");
		replace = replace.replace(",", " ");
		String[] splitString = replace.split(" ");
		
		for(int i = 0; i<splitString.length;i++) {
			Integer hold = retMap.get(splitString[i]);
			if(hold == null) {
				hold = 1;
			}
			else {
				hold++;
			}
			if(splitString[i].length()!=0) {
				retMap.put(splitString[i], hold);
			}
		}
		
		
		
		
		return retMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			int max = sortedList.size()-1;
			//System.out.println("max is "+max);
			//int mid = max/2;
			int min = 0;
			
			//return 20;
			return recursiveIndex(t,max,min);
		}
		
		public int recursiveIndex(T t, int max, int min) {
			
				int mid = min + ((max-min)/2);
				T hold = sortedList.get(mid);
				//System.out.println("Checking:" + mid+": "+hold);
				
				
				if(hold.compareTo(t)==0) {
					//System.out.println("Found it");
					return mid;
				}
				else if(hold.compareTo(t)>0) {
					
					return recursiveIndex(t,mid-1,min);
					
				}
				else {
					return recursiveIndex(t,max,mid+1);
				}
			
			
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}



	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {

		String[] words = string.split(" ");
		//String[]newWords = new String[words.length];
		String newString = "";
		boolean test = false;
		
		for(String word:words) {
			
			if(test) {
				newString=newString.concat(" ");
			}
			
			
			if(isVowel(word.charAt(0))) {
				
			
				newString = newString.concat(word+"ay");
			
			}
			else {
				newString = newString.concat(word.substring(firstVowel(word))
						+ word.substring(0,firstVowel(word))+"ay");
			}
			test = true;
		}
		
		return newString;
	}
	
	public int firstVowel(String string) {
		
		for(int i=0;i<string.length();i++) {
			
			if(isVowel(string.charAt(i))) {
				
				if(string.charAt(i)== 117&&string.charAt(i-1)==113) {
					
				}else {
				return i;
				}
			}
		}
		return -1;
		
	}
	
	public boolean isVowel(char ch) {
		
		if(ch ==97||ch ==101||ch ==105||ch ==111||ch ==117) {
			return true;
		}else {
			return false;
		}
	}
	

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
	
			String armstrong = Integer.toString(input);
			int length = armstrong.length();
			//System.out.println("Input: "+input+" Length: "+length);
			int total = 0;
			
			for(int i =0;i<length;i++) {
				int character = Character.getNumericValue(armstrong.charAt(i));
				//System.out.println("Character value is: "+character);
				total = (int) (total + Math.pow(character,length));
				//System.out.println("Total is now "+total);
			}
			
			//System.out.println("Final Total is " + total);
			if(total == input) {
				return true;
			}
			
			
		
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> retList = new LinkedList<Long>();
		
		long div = l;
		//System.out.println("Our number is "+div);
		
		while(div%2L==0) {
			retList.add(2L);
			div = div/2L;
			
			//System.out.println("Found a 2. Div is now "+div);
		}
		
		for (long i = 3L; i <= Math.sqrt(div); i+= 2L) 
        { 
            
            while (div%i == 0) 
            { 
                retList.add(i); 
                div /= i; 
                //System.out.println("Found a "+i+". Now div is: "+div);
            } 
        }
		
		if(div != 1l) {
			retList.add(div);
		}
		
		return retList;
	}
	


	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//System.out.println(key);
			String masterLower = "abcdefghijklmnopqrstuvwxyz";
			String masterUpper = masterLower.toUpperCase();
			String adjustedLower = masterLower.substring(key)+masterLower.substring(0, key);
			String adjustedUpper = adjustedLower.toUpperCase();
			String newString = "";
			
			for(int i = 0; i<string.length();i++) {
				char test = string.charAt(i);
				int hold;
				if(test >=65&&test<=90) {
					//Uppercase
					hold = masterUpper.indexOf(test);
					newString = newString.concat(Character.toString(adjustedUpper.charAt(hold)));
				}
				else if(test >=97&&test<=122) {
					//Lowercase
					hold = masterLower.indexOf(test);
					newString = newString.concat(Character.toString(adjustedLower.charAt(hold)));
				}
				else {
					newString = newString.concat(Character.toString(test));
				}
			}
			
			
			
			
			
			return newString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		if(i==1) {
			return 2;
		}
		
		if(i <=0) {
			throw new IllegalArgumentException();
		}
		
		int test = 1;
		int primeFinder = 1;
		
		while(test <i) {
			primeFinder = primeFinder + 2;
			if(isPrime(primeFinder)) {
				test = test + 1;
			}
		}
		
		
		
		return primeFinder;
	}
	
	public boolean isPrime(int test) {
		
		for(int i = 2;i<test;i++) {
			if(test%i==0) {
				return false;
			}
		}
		
		return true;
		
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String master = "abcdefghijklmnopqrstuvwxyz";
			String cypher = "zyxwvutsrqponmlkjihgfedcba";
			int block = 0;
			String retString = "";
			String test = string.toLowerCase();
			
			for(int i = 0; i<string.length();i++) {
				
				
				
				if(Character.isAlphabetic(test.charAt(i))) {
					if(block==5) {
						retString = retString.concat(" ");
						block = 0;
					}
					int hold = master.indexOf(test.charAt(i));
					retString = retString.concat(Character.toString(cypher.charAt(hold)));
					block++;
				}
				else if(Character.isDigit(test.charAt(i))) {
					if(block==5) {
						retString = retString.concat(" ");
						block = 0;
					}
					retString = retString.concat(Character.toString(test.charAt(i)));
					block++;
				}
				
			}
			return retString;
		}
		
		

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String master = "abcdefghijklmnopqrstuvwxyz";
			String cypher = "zyxwvutsrqponmlkjihgfedcba";
			String retString = "";
			
			for(int i = 0; i<string.length();i++) {
				
				char ch = string.charAt(i);
				
				if(Character.isAlphabetic(ch)){
					
					int hold = cypher.indexOf(ch);
					ch = master.charAt(hold);
					retString = retString.concat(Character.toString(ch));
					
				}
				else if(Character.isDigit(ch)) {
					retString = retString.concat(Character.toString(ch));
				}
				
			}
			return retString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		int valueCount = 10;
		int testValue = 0;
		//System.out.println(string);
		
		
		for(int i = 0; i<string.length();i++) {
			
			char ch = string.charAt(i);
			
			if(string.charAt(i)=="-".charAt(0)) {
				
			}else if(Character.isDigit(ch)){
				
				testValue = testValue + (Character.getNumericValue(ch))*valueCount;
				//System.out.println(ch + " times " +valueCount);
				//System.out.println("New value: "+ testValue);
				valueCount = valueCount - 1;
				
			}
			else if(ch == "X".charAt(0)&&valueCount == 1) {
				testValue = testValue + 10;
				//System.out.println("found an X");
			}
			else if(Character.isAlphabetic(ch)) {
				//System.out.println(false);
				return false;
			}
			
		}
		
		if(testValue%11==0) {
			//System.out.println(true);
			return true;
		}
		
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		if(string.isEmpty()) {
			return false;
		}
		
		for(int i = 0;i<alphabet.length();i++) {
			
			char test = alphabet.charAt(i);
			
			if(string.indexOf(test)==-1) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		Temporal retValue;
		
		if(given instanceof LocalDateTime) {
			LocalDateTime ex = (LocalDateTime) given;
			ex = ex.plusSeconds(1000000000);
			retValue = (Temporal) ex;
		}
		else {
			LocalDate date = (LocalDate) given;
			LocalTime time = LocalTime.of(0, 0, 0);
			LocalDateTime ex = LocalDateTime.of(date, time);
			ex = ex.plusSeconds(1000000000);
			retValue = (Temporal) ex;
		}
		/*
		LocalDateTime ex = LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0);
		ex = ex.plusSeconds(1000000000);
		
		LocalTime ex2 = LocalTime.of(0, 0, 0);
		LocalDate ex3 = given;
		*/

		
		
		return retValue;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		Set<Integer> mySet = new HashSet<Integer>();
		int retValue = 0;
		
		
		for(int a:set) {
			int multiple = a;
			while(multiple <i) {
				mySet.add(multiple);
				multiple = multiple + a;
			}
		}
		
		for(Integer a:mySet) {
			retValue = retValue + a;
		}
		
		return retValue;
	}
	
	

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {

		String trimmed = "";
		boolean isEven = false;
		int total = 0;
		
		for(int i = 0; i<string.length();i++) {
			
			char ch = string.charAt(i);
			if(Character.isDigit(ch)) {
				
				trimmed = trimmed.concat(Character.toString(ch));
				
			}
			else if(Character.isWhitespace(ch)) {
				
			}
			else {
				return false;
			}
			
		}
		
		for(int i = trimmed.length()-1;i>=0;i--) {
			int hold = 0;
			
			if(isEven) {
				hold = 2*(Character.getNumericValue(trimmed.charAt(i)));
				if(hold>9) {
					hold = hold-9;
				}
			}
			else {
				hold = (Character.getNumericValue(trimmed.charAt(i)));
			}
			total = total + hold;
			isEven = !isEven;
		}
		
		if(total%10==0) {
			return true;
		}
		
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		String[] strArray = string.split(" ");
		int first = firstNumber(strArray);
		int second = secNumber(strArray);
		int operator = findOperator(strArray);
		
		switch(operator) {
		
		case 1: return first + second;
		case 2: return first - second;
		case 3: return first * second;
		case 4: return first / second;
		}
		
		return 0;
		
	}
	
	public int findOperator(String[] strings) {
		
		
		
		for(String string:strings) {
			
			switch(string) {
			
			case "plus": return 1;
			case "minus": return 2;
			case "multiplied": return 3;
			case "divided": return 4;
			
			}
			
		}
		
		return 0;
	}
	
	public int firstNumber(String[] strings) {
		int numValue = 0;
		
		for(String string:strings) {
			
			try {
				//System.out.println("Trying "+string);
				numValue = Integer.parseInt(string);
				//System.out.println("Returning "+ numValue);
				return numValue;
			}
			catch(NumberFormatException e){
				
			}
			
		}
		
		//System.out.println("No numbers found");
		return 0;
	}
	
	public int secNumber(String[] strings) {
		int numValue = 0;
		boolean firstFound = false;
		
			for(String string:strings) {
				
				String trimmed = string;
				
				if(trimmed.charAt(trimmed.length()-1)=="?".charAt(0)) {
					
					trimmed = trimmed.substring(0,trimmed.length()-1);
				}
			
				try {
					//System.out.println("Trying 2nd " + trimmed);
					numValue = Integer.parseInt(trimmed);
					//System.out.println("Found number "+numValue);
					
					if(firstFound) {
						
						//System.out.println("Found second number: " + numValue);
						return numValue;
					}
					
					//System.out.println("Looking for second number.");
					firstFound = true;
					
				}
				catch(NumberFormatException e){
				
				}
			
			}
		
			//System.out.println("No numbers found");
			return 0;
		}

}
