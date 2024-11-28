import java.util.Random;


public class Anagram {
	public static void main(String args[]) {

		System.out.println(isAnagram("silent", "listen"));  // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true


		System.out.println(preProcess("What? No way!!!"));
		
	
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
	
		String originalStr = "1234567";
		Boolean testPassed = true;

		for (int i = 0; i < 10; i++) {
			String randomAnagramStr = randomAnagram(originalStr);
			System.out.println(randomAnagramStr);
			testPassed = testPassed && isAnagram(originalStr, randomAnagramStr);
			if (!testPassed) break;
		}
		System.out.println(testPassed ? "test passed" : "test failed");
	}  


	public static boolean isAnagram(String firstStr, String secondStr) {
		String processedFirstStr = preProcess(firstStr);
        String processedSecondStr = preProcess(secondStr);
		if (processedFirstStr.length() != processedSecondStr.length()) {
            return false;
        }

		for (int i = 0; i < processedFirstStr.length(); i++) {
            char currentChar = processedFirstStr.charAt(i);
            boolean isMatchFound = false;

			for (int j = 0; j < processedSecondStr.length(); j++) {
                if (processedSecondStr.charAt(j) == currentChar) {
					processedSecondStr = processedSecondStr.substring(0, j) + processedSecondStr.substring(j + 1); // Remove matched character
                    isMatchFound = true;
                    break;
                }
            }

            if (!isMatchFound) {
                return false;
            }
        }

        return true;
	}
	   

	public static String preProcess(String inputStr) {
		StringBuilder processedStr = new StringBuilder();
        
        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);

            if (Character.isLetter(currentChar)) {
                processedStr.append(Character.toLowerCase(currentChar));
            } else if (currentChar == ' ') {
                processedStr.append(currentChar);
            }
        }
        
        return processedStr.toString();
	}
	   

	public static String randomAnagram(String inputStr) {
		String processedStr = preProcess(inputStr);
        

        char[] charArray = processedStr.toCharArray();
        
      
        Random random = new Random();
        
 
        for (int i = 0; i < charArray.length; i++) {
            int randomIndex = random.nextInt(charArray.length); 
            char tempChar = charArray[i];
            charArray[i] = charArray[randomIndex];
            charArray[randomIndex] = tempChar;
        }
        

        return new String(charArray);
	}
}
