package tryouts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TryMaps {

    /* Create and print a Map
     * @return void
     * Approach: Using HashMap put()
     * Example: input Java=17, Spring=6 -> output {Java=17, Spring=6}
     * */
    public static void createMap() {
        Map<String, Integer> versions = new HashMap<>();
        versions.put("Java", 17);
        versions.put("Spring", 6);
        System.out.println(versions);
    }

    /* Add, update, get, and remove entries from a Map
     * @return void
     * Approach: Using put(), get(), containsKey(), and remove()
     * Example: input apple=2 -> output apple count 3, final {banana=5}
     * */
    public static void basicOperations() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 2);
        fruits.put("banana", 5);
        fruits.put("apple", 3);
        System.out.println("Apple count: " + fruits.get("apple"));
        System.out.println("Has banana: " + fruits.containsKey("banana"));
        fruits.remove("apple");
        System.out.println(fruits);
    }

    /* Iterate through a Map
     * @return void
     * Approach: Using entrySet(), keySet(), and forEach
     * Example: input {A=1, B=2} -> output A -> 1, B -> 2
     * */
    public static void iterateMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        for (Map.Entry<String, Integer> entry : map.entrySet()) System.out.println(entry.getKey() + " -> " + entry.getValue());
        for (String key : map.keySet()) System.out.println(key + " -> " + map.get(key));
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    /* Count word frequency in a sentence
     * @return void
     * Approach: Using HashMap and getOrDefault
     * Example: input "java is java" -> output {java=2, is=1}
     * */
    public static void wordFrequencyA1() {
        String sentence = "java is java";
        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (String word : sentence.split("\\s+")) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        System.out.println(frequency);
    }

    /* Count word frequency in a sentence
     * @return void
     * Approach: Using Streams groupingBy and counting
     * Example: input "java is java" -> output {java=2, is=1}
     * */
    public static void wordFrequencyA2() {
        Map<String, Long> frequency = Arrays.stream("java is java".split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(frequency);
    }

    /* Sort a Map by keys
     * @return void
     * Approach: Using TreeMap
     * Example: input {banana=2, apple=3} -> output {apple=3, banana=2}
     * */
    public static void sortByKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 2);
        map.put("apple", 3);
        System.out.println(new TreeMap<>(map));
    }

    /* Sort a Map by values
     * @return void
     * Approach: Using Streams and LinkedHashMap to keep sorted order
     * Example: input {A=3, B=1, C=2} -> output {B=1, C=2, A=3}
     * */
    public static void sortByValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);
        Map<String, Integer> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        System.out.println(sorted);
    }

    /* Find the first non-repeated character
     * @return void
     * Approach: Using LinkedHashMap to maintain insertion order
     * Example: input "swiss" -> output w
     * */
    public static void firstNonRepeatedCharacter() {
        String input = "swiss";
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("No unique character");
    }

    /* Group names by their first letter
     * @return void
     * Approach: Using Streams groupingBy
     * Example: input [Akhil, Amit, Bob] -> output {A=[Akhil, Amit], B=[Bob]}
     * */
    public static void groupByFirstLetter() {
        List<String> names = Arrays.asList("Akhil", "Amit", "Bob");
        Map<Character, List<String>> grouped = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(grouped);
    }
}
