package main.java.misc;

import java.util.Arrays;

class PythagoreanTriplet
{
    // Returns true if there is a triplet with following property
    // A[i]*A[i] = A[j]*A[j] + A[k]*[k]
    // Note that this function modifies given array
    static boolean isTriplet(int arr[], int n) {
       for(int i = 0; i < n; i++) {
           arr[i] = arr[i] * arr[i];
       }

       Arrays.sort(arr);

       for(int i = n-1; i >= 2; i--) {
           int left = 0;
           int right = i-1;
           while(left < right) {
               if(arr[i] == arr[left] + arr[right])
                   return true;
               if(arr[left] + arr[right] < arr[i])
                   left++;
               else
                   right--;
           }
       }

       return false;
    }


    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };
        int arr_size = arr.length;

        if (isTriplet(arr,arr_size) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
