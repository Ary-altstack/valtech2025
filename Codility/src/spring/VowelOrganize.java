package spring;
import java.util.*;

public class VowelOrganize {
    
    private static int countVowels(String sentence) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char ch : sentence.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
            "John Lennon",
            "Beatles",
            "Singer Writer",
            "Leader"
        );
        sentences.sort((s1, s2) -> Integer.compare(countVowels(s1), countVowels(s2)));
        for (String sentence : sentences) {
            System.out.println(sentence + " (Vowels: " + countVowels(sentence) + ")");
        }
    }
}