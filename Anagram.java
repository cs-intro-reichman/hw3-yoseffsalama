import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(areAnagrams("silent", "listen"));
        System.out.println(areAnagrams("William Shakespeare", "I am a weakish speller"));
        System.out.println(areAnagrams("Madam Curie", "Radium came"));
        System.out.println(areAnagrams("Tom Marvolo Riddle", "I am Lord Voldemort"));
        System.out.println(preProcessString("What? No way!!!"));
        System.out.println("silent and " + generateRandomAnagram("silent") + " are anagrams.");

        String inputString = "1234567";
        Boolean allTestsPassed = true;
        for (int i = 0; i < 10; i++) {
            String randomAnagram = generateRandomAnagram(inputString);
            System.out.println(randomAnagram);
            allTestsPassed = allTestsPassed && areAnagrams(inputString, randomAnagram);
            if (!allTestsPassed) break;
        }
        System.out.println(allTestsPassed ? "test passed" : "test Failed");
    }

    public static boolean areAnagrams(String firstString, String secondString) {
        firstString = preProcessString(firstString).replace(" ", "");
        secondString = preProcessString(secondString).replace(" ", "");

        if (firstString.length() != secondString.length()) {
            return false;
        }

        StringBuilder secondStringBuilder = new StringBuilder(secondString);
        for (int i = 0; i < firstString.length(); i++) {
            char currentChar = firstString.charAt(i);
            int indexInSecondString = secondStringBuilder.indexOf(String.valueOf(currentChar));
            if (indexInSecondString == -1) {
                return false;
            }
            secondStringBuilder.deleteCharAt(indexInSecondString);
        }
        return true;
    }

    public static String preProcessString(String inputString) {
        StringBuilder processedString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (Character.isLetter(currentChar)) {
                processedString.append(Character.toLowerCase(currentChar));
            } else if (currentChar == ' ') {
                processedString.append(' ');
            }
        }
        return processedString.toString();
    }

    public static String generateRandomAnagram(String inputString) {
        List<Character> characterList = new ArrayList<>();
        for (char character : inputString.toCharArray()) {
            characterList.add(character);
        }
        Collections.shuffle(characterList);
        StringBuilder shuffledString = new StringBuilder();
        for (char character : characterList) {
            shuffledString.append(character);
        }

        return shuffledString.toString();
    }
}
