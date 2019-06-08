package main.java.amazon;

import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // Driver code
    public static void main(String args[])
    {
        int A[] = {1, 4, 45, 6, 10, -8};
        int n = 16;
        int arr_size = A.length;

        // Function calling
        int[] result = twoSum(A, n);
        System.out.println("Result: index 1 = " + result[0] + ", index 2 = " + result[1]);
    }

}