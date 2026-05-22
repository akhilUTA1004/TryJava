package tryouts;

import java.util.*;
import java.util.stream.Collectors;

public class TrySets {

    /* Create and print a Set
     * @return void
     * Approach: Using HashSet to remove duplicates
     * Example: input [1, 2, 2, 3] -> output [1, 2, 3]
     * */
    public static void createSet() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 2, 3));
        System.out.println(numbers);
    }

    /* Add, remove, and check elements in a Set
     * @return void
     * Approach: Using add(), remove(), and contains()
     * Example: input Java, Spring -> output Has Java: true, Final: [Spring]
     * */
    public static void basicOperations() {
        Set<String> skills = new LinkedHashSet<>();
        skills.add("Java");
        skills.add("Spring");
        System.out.println("Has Java: " + skills.contains("Java"));
        skills.remove("Java");
        System.out.println(skills);
    }

    /* Find union of two Sets
     * @return void
     * Approach: Using addAll()
     * Example: input [1, 2], [2, 3] -> output [1, 2, 3]
     * */
    public static void union() {
        Set<Integer> result = new LinkedHashSet<>(Arrays.asList(1, 2));
        result.addAll(Arrays.asList(2, 3));
        System.out.println(result);
    }

    /* Find intersection of two Sets
     * @return void
     * Approach: Using retainAll()
     * Example: input [1, 2, 3], [2, 3, 4] -> output [2, 3]
     * */
    public static void intersection() {
        Set<Integer> result = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        result.retainAll(Arrays.asList(2, 3, 4));
        System.out.println(result);
    }

    /* Find difference between two Sets
     * @return void
     * Approach: Using removeAll()
     * Example: input [1, 2, 3], [2, 3, 4] -> output [1]
     * */
    public static void difference() {
        Set<Integer> result = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        result.removeAll(Arrays.asList(2, 3, 4));
        System.out.println(result);
    }

    /* Check if a string has all unique characters
     * @return void
     * Approach: Using HashSet add() return value
     * Example: input "hello" -> output false
     * */
    public static void uniqueCharactersA1() {
        String input = "hello";
        Set<Character> seen = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!seen.add(ch)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    /* Check if a string has all unique characters
     * @return void
     * Approach: Using Streams distinct count
     * Example: input "world" -> output true
     * */
    public static void uniqueCharactersA2() {
        String input = "world";
        boolean unique = input.chars().distinct().count() == input.length();
        System.out.println(unique);
    }

    /* Remove duplicates from a List
     * @return void
     * Approach: Using LinkedHashSet to keep insertion order
     * Example: input [A, B, A, C] -> output [A, B, C]
     * */
    public static void removeDuplicatesFromList() {
        List<String> names = Arrays.asList("A", "B", "A", "C");
        System.out.println(new ArrayList<>(new LinkedHashSet<>(names)));
    }

    /* Sort unique numbers
     * @return void
     * Approach: Using TreeSet for natural ordering
     * Example: input [5, 1, 5, 3] -> output [1, 3, 5]
     * */
    public static void sortedUniqueNumbers() {
        Set<Integer> sorted = new TreeSet<>(Arrays.asList(5, 1, 5, 3));
        System.out.println(sorted);
    }

    /* Find duplicates in a List
     * @return void
     * Approach: Using HashSet for seen values and LinkedHashSet for duplicates
     * Example: input [1, 2, 2, 3, 1] -> output [2, 1]
     * */
    public static void findDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 1);
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(duplicates);
    }
}
