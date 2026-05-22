package tryouts;

import java.util.*;

public class TryQueues {

    /* Create and print a Queue
     * @return void
     * Approach: Using LinkedList as a Queue
     * Example: input A, B, C -> output [A, B, C]
     * */
    public static void createQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println(queue);
    }

    /* Add, peek, and remove elements from a Queue
     * @return void
     * Approach: Using offer(), peek(), and poll()
     * Example: input [A, B] -> output Peek: A, Poll: A, Final: [B]
     * */
    public static void basicOperations() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println(queue);
    }

    /* Process items in First-In-First-Out order
     * @return void
     * Approach: Poll until the Queue is empty
     * Example: input [10, 20, 30] -> output 10 20 30
     * */
    public static void processFifo() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        while (!queue.isEmpty()) System.out.print(queue.poll() + " ");
        System.out.println();
    }

    /* Use a PriorityQueue as a min heap
     * @return void
     * Approach: Natural ordering keeps the smallest value at peek()
     * Example: input [30, 10, 20] -> output 10 20 30
     * */
    public static void minHeapPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(30, 10, 20));
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();
    }

    /* Use a PriorityQueue as a max heap
     * @return void
     * Approach: Comparator.reverseOrder()
     * Example: input [30, 10, 20] -> output 30 20 10
     * */
    public static void maxHeapPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(Arrays.asList(30, 10, 20));
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();
    }

    /* Find the kth largest element
     * @return void
     * Approach: Using a min heap of size k
     * Example: input [3, 2, 1, 5, 6, 4], k=2 -> output 5
     * */
    public static void kthLargest() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.offer(n);
            if (heap.size() > k) heap.poll();
        }
        System.out.println(heap.peek());
    }

    /* Generate first binary numbers from 1 to n
     * @return void
     * Approach: Using Queue for breadth-first generation
     * Example: input n=5 -> output 1 10 11 100 101
     * */
    public static void generateBinaryNumbers() {
        int n = 5;
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            System.out.print(current + " ");
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        System.out.println();
    }
}
