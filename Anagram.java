import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagram {
    public static void main(String args[]) {
        System.out.println(isAnagram("silent", "listen"));  
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); 
        System.out.println(isAnagram("Madam Curie", "Radium came")); 
        System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); 
        System.out.println(preProcess("What? No way!!!"));
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

        String str = "1234567";
        Boolean pass = true;
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }  

    public static boolean isAnagram(String str1, String str2) {
        // Preprocess and clean spaces
        str1 = preProcess(str1).replace(" ", "");
        str2 = preProcess(str2).replace(" ", "");

        // Length check after cleaning
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare characters
        StringBuilder str2Builder = new StringBuilder(str2);
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int indexInStr2 = str2Builder.indexOf(String.valueOf(ch));
            if (indexInStr2 == -1) {
                return false;
            }
            str2Builder.deleteCharAt(indexInStr2);
        }
        return true;
    }

    public static String preProcess(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                result.append(Character.toLowerCase(ch)); 
            } else if (ch == ' ') {
                result.append(' '); 
            }
        }
        return result.toString();
    }

    public static String randomAnagram(String str) {
        List<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }
        Collections.shuffle(charList);
        StringBuilder shuffledString = new StringBuilder();
        for (char c : charList) {
            shuffledString.append(c);
        }

        return shuffledString.toString();
    }
}