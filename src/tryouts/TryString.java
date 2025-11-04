package tryouts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TryString {

    /* Find the first non-repeated character in a string
     * @param input The input string to be processed
     * @return void
     *
     * Approach: Using LinkedHashMap to maintain the order of characters
     *
     * */

    public static void findFirstNonRepeatedCharacterA1(String input) {

        if (input == null || input.isBlank()) {
            IO.println("No input");
        }

        assert input != null;

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char ch : input.toCharArray())
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated character: " + entry.getKey());
                break;
            }
        }
    }

    /* Find the first non-repeated character in a string
     * @param input The input string to be processed
     * @return void
     *
     * Approach: Using Java Streams and LinkedHashMap to maintain order
     * */

    public static void findFirstNonRepeatedCharacterA2(String input) {

        Character result = input.chars()                             // IntStream of char codes
                .mapToObj(c -> (char) c)                         // Convert int → Character
                .collect(Collectors.groupingBy(
                        Function.identity(),                         // Group by character
                        LinkedHashMap::new,                          // Maintain insertion order
                        Collectors.counting()                        // Count occurrences
                ))
                .entrySet().stream()                                 // Stream over entries
                .filter(e -> e.getValue() == 1) // Keep only count == 1
                .map(Map.Entry::getKey)                              // Extract the key (char)
                .findFirst()                                         // Get first unique
                .orElse(null);                                 // Return null if none found

        System.out.println("First non-repeated character: " + result);
    }

    /* Reverse a string
     * @param input The input string to be reversed
     * @return void
     *
     * Approach: Using StringBuilder's reverse() method
     * Example: input "hello" -> output "olleh"
     *
     * */

    public static void reverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(reversed);
    }

    /* Check if a string is a palindrome
     * @param input The input string to be checked
     * @return void
     * Approach: Comparing the string with its reverse
     * Example: input "madam" -> output true
     * */

    public static void checkPalindrome(String input) {
        boolean isPalindrome = input.equalsIgnoreCase(new StringBuilder(input).reverse().toString());
        System.out.println(isPalindrome);
    }

    /* Count vowels and consonants in a string
     * @param input The input string to be processed
     * @return void
     * Approach: Using Java Streams to filter and count vowels and consonants
     * Example: input "Java" -> output Vowels: 2, Consonants: 2
     * */

    public static void checkVowelsConsonants(String input) {
        long vowels = input.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count();
        long consonants = input.replaceAll("[^a-zA-Z]", "").length() - vowels;
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    /* Remove whitespaces from a string
     * @param input The input string to be processed
     * @return void
     * Approach: Using String's replaceAll() method with regex
     * Example: input "  Java Developer  " -> output "JavaDeveloper"
     * */

    public static void removeWhitespaces(String input) {
        System.out.println(input.replaceAll("\\s+", ""));
    }

    /* Check if two strings are anagrams
     * @param input1 The first input string
     * @param input2 The second input string
     * @return void
     * Approach: Sorting the characters of both strings and comparing
     * Example: input1 "listen", input2 "silent" -> output true
     * */

    public static void checkAnagrams(String s1, String s2) {
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.equals(a, b)); // true
    }

    /* Find the first repeated character in a string
     * @param input The input string to be processed
     * @return void
     * Approach: Using a HashSet to track seen characters
     * Example: input "programming" -> output 'r'
     * */

    public static void findFirstRepeatedCharacter (String input) {
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.add(c)) {
                System.out.println("First repeated: " + c);
                break;
            }
        }
    }

    /* Count frequency of each character in a string
     * @param input The input string to be processed
     * @return void
     * Approach: Using Java Streams and Collectors to count occurrences
     * Example: input "success" -> output {s=3, u=1, c=2, e=1}
     * */

    public static void countCharacterFrequency(String input) {
        System.out.println(
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }

    /* Reverse each word in a sentence
     * @param sentence The input sentence to be processed
     * @return void
     * Approach: Using Java Streams to split, reverse, and join words
     * Example: input "Java Developer" -> output "avaJ repoleveD"
     * */

    public static void reverseEachWord(String sentence) {
        String result = Arrays.stream(sentence.split(" "))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    /* Find the longest word in a sentence
     * @param sentence The input sentence to be processed
     * @return void
     * Approach: Using Java Streams to split and find the max length word
     * Example: input "I am learning Spring Boot" -> output "learning"
     * */

    public static void findLongestWordInSentence(String sentence) {
        String longest = Arrays.stream(sentence.split(" "))
                .max((a, b) -> a.length() - b.length())
                .orElse("");
        System.out.println(longest);
    }

    /* Check if one string is a rotation of another
     * @param s1 The first input string
     * @param s2 The second input string
     * @return void
     * Approach: Concatenate s1 with itself and check if s2 is a substring
     * Example: input1 "ABCD", input2 "CDAB" -> output true
     * */

    public static void checkStringRotation(String s1, String s2) {
        boolean isRotation = s1.length() == s2.length() && (s1 + s1).contains(s2);
        System.out.println(isRotation); // true
    }

    /* Find duplicate words in a sentence
     * @param sentence The input sentence to be processed
     * @return void
     * Approach: Using Java Streams to split, group, and filter duplicates
     * Example: input "Java is great and Java is powerful" -> output "Java", "is"
     * */

    public static void findDuplicateWords(String sentence) {
        Arrays.stream(sentence.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey())); // java, is
    }

    /* Check if a string contains only digits
     * @param input The input string to be checked
     * @return void
     * Approach: Using regex to match digits
     * Example: input "12345" -> output true
     * */

    public static void hasStringOnlyDigits(String input) {
        System.out.println(input.matches("\\d+"));
    }

    /* Remove duplicate characters from a string
     * @param input The input string to be processed
     * @return void
     * Approach: Using LinkedHashSet to maintain order and remove duplicates
     * Example: input "programming" -> output "progamin"
     * */

    public static void removeDuplicateCharacters(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars().mapToObj(c -> (char) c).collect(LinkedHashSet::new, Set::add, Set::addAll)
                .forEach(sb::append);
        System.out.println(sb); // progamin
    }

    /* Generate all permutations of a string recursively
     * @param input The input string to be permuted
     * @param prefix The prefix for the current permutation
     * @return void
     * Approach: Using recursion to generate permutations
     * Example: input "ABC" -> output "ABC", "ACB", "BAC", "BCA", "CAB", "CBA"
     * */

    public static void recursiveStringPermutations(String input, String prefix) {
        permute(prefix, input);
    }

    /* Helper method for generating permutations */
    private static void permute(String prefix, String remaining) {
        if (remaining.isEmpty()) System.out.println(prefix);
        else for (int i = 0; i < remaining.length(); i++)
            permute(prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1));
    }

    /* Find the most repeated character in a string
     * @param input The input string to be processed
     * @return void
     * Approach: Using Java Streams to count occurrences and find max
     * Example: input "banana" -> output 'a' (3)
     * */

    public static void findMostRepeatedCharacter(String input) {
        var map = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Most repeated: " + max.getKey() + " (" + max.getValue() + ")");
    }

    /* Check if a string has all unique characters
     * @param input The input string to be checked
     * @return void
     * Approach: Using a HashSet to track seen characters
     * Example: input "hello" -> output false
     * */

    public static void checkUniqueCharacters(String input) {
        boolean unique = input.chars().mapToObj(c -> (char) c)
                .allMatch(new HashSet<>()::add);
        System.out.println(unique);
    }

    /* Reverse the order of words in a sentence
     * @param sentence Command line arguments (not used)
     * @return void
     * Approach: Splitting the sentence into words, reversing the list, and joining back
     * Example: input "I love Java" -> output "Java love I"
     * */

    public static void reverseWordsOrder(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        Collections.reverse(words);
        System.out.println(String.join(" ", words)); // Java love I
    }

    /* Compress a string by replacing consecutive characters with the character followed by the count (run-length encoding)
     * @param input The input string to be compressed
     * @return void
     * Approach: Iterating through the string and counting consecutive characters
     * Example: input "aaabbcc" -> output "a3b2c2"
     * */

    public static void StringCompression(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) != input.charAt(i - 1)) {
                sb.append(input.charAt(i - 1)).append(count);
                count = 1;
            } else count++;
        }
        System.out.println(sb); // a3b2c2
    }

    /* Find the longest palindromic substring in a string
     * @param input The input string to be processed
     * @return void
     * Approach: Expanding around center to find palindromes
     * Example: input "babad" -> output "bab" or "aba"
     * */

    public static void LongestPalindromicSubstring(String input) {
        System.out.println(longestPalindrome(input));
    }

    /* Helper method to find longest palindromic substring */
    private static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /* Helper method to expand around center */
    private static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
        return r - l - 1;
    }

}
