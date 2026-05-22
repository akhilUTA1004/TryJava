package tryouts;

import java.util.*;
import java.util.stream.Collectors;

public class TryLists {

    /* Create and print a List
     * @return void
     * Approach: Using Arrays.asList and ArrayList
     * Example: input [10, 20, 30] -> output [10, 20, 30]
     * */
    public static void createList() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println(numbers);
    }

    /* Add, update, remove, and access elements in a List
     * @return void
     * Approach: Using add(), set(), remove(), and get()
     * Example: input [Java, Python] -> output First: Java, Final: [Java, Go]
     * */
    public static void basicOperations() {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        System.out.println("First: " + languages.get(0));
        languages.set(1, "Go");
        languages.remove("Python");
        System.out.println("Final: " + languages);
    }

    /* Iterate through a List
     * @return void
     * Approach: Using for loop, enhanced for loop, and forEach
     * Example: input [A, B, C] -> output A B C
     * */
    public static void iterateList() {
        List<String> letters = Arrays.asList("A", "B", "C");
        for (int i = 0; i < letters.size(); i++) System.out.print(letters.get(i) + " ");
        System.out.println();
        for (String letter : letters) System.out.print(letter + " ");
        System.out.println();
        letters.forEach(letter -> System.out.print(letter + " "));
        System.out.println();
    }

    /* Sort a List
     * @return void
     * Approach: Using Collections.sort and Stream sorted
     * Example: input [5, 1, 3] -> output [1, 3, 5]
     * */
    public static void sortList() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 1, 3));
        Collections.sort(numbers);
        System.out.println("Collections sort: " + numbers);
        List<Integer> sorted = Arrays.asList(5, 1, 3).stream().sorted().collect(Collectors.toList());
        System.out.println("Stream sort: " + sorted);
    }

    /* Reverse a List
     * @return void
     * Approach: Using Collections.reverse
     * Example: input [1, 2, 3] -> output [3, 2, 1]
     * */
    public static void reverseList() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.reverse(numbers);
        System.out.println(numbers);
    }

    /* Remove duplicate values from a List while preserving order
     * @return void
     * Approach: Using LinkedHashSet
     * Example: input [1, 2, 2, 3, 1] -> output [1, 2, 3]
     * */
    public static void removeDuplicatesA1() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 1);
        List<Integer> unique = new ArrayList<>(new LinkedHashSet<>(numbers));
        System.out.println(unique);
    }

    /* Remove duplicate values from a List while preserving order
     * @return void
     * Approach: Using Streams distinct()
     * Example: input [1, 2, 2, 3, 1] -> output [1, 2, 3]
     * */
    public static void removeDuplicatesA2() {
        List<Integer> unique = Arrays.asList(1, 2, 2, 3, 1).stream().distinct().collect(Collectors.toList());
        System.out.println(unique);
    }

    /* Find the second largest number in a List
     * @return void
     * Approach: Using loop with largest and secondLargest variables
     * Example: input [10, 5, 30, 20] -> output 20
     * */
    public static void secondLargestA1() {
        List<Integer> numbers = Arrays.asList(10, 5, 30, 20);
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n > largest) {
                secondLargest = largest;
                largest = n;
            } else if (n > secondLargest && n != largest) {
                secondLargest = n;
            }
        }
        System.out.println(secondLargest);
    }

    /* Find the second largest number in a List
     * @return void
     * Approach: Using Streams with distinct, sorted, skip, and findFirst
     * Example: input [10, 5, 30, 20] -> output 20
     * */
    public static void secondLargestA2() {
        Integer secondLargest = Arrays.asList(10, 5, 30, 20).stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondLargest);
    }

    /* Find common elements between two Lists
     * @return void
     * Approach: Using HashSet lookup for O(1) contains checks
     * Example: input [1, 2, 3], [2, 3, 4] -> output [2, 3]
     * */
    public static void commonElements() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(2, 3, 4);
        Set<Integer> lookup = new HashSet<>(b);
        List<Integer> common = a.stream().filter(lookup::contains).collect(Collectors.toList());
        System.out.println(common);
    }

    /* Rotate a List to the right by k positions
     * @return void
     * Approach: Using Collections.rotate
     * Example: input [1, 2, 3, 4, 5], k=2 -> output [4, 5, 1, 2, 3]
     * */
    public static void rotateList() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.rotate(numbers, 2);
        System.out.println(numbers);
    }
}
