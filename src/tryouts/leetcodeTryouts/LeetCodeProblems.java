package tryouts.leetcodeTryouts;

public class LeetCodeProblems {

    /*
    * LeetCode Problem: Container With Most Water
    * LeetCod URL: https://leetcode.com/problems/container-with-most-water/
    * Difficulty: Medium
    * */

    public void waterContainer() {

        System.out.println("Max volume is " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

    // Function to calculate the maximum area of water container
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
