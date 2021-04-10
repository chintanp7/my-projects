package com.chintan.ds;

public class PairSum1 {

    public static void main(String[] args) {

        int[] array = {-40, 20, 7, -5, 3, 6, -29};
        int[] array2 = {-40, -29, -5, 3, 6, 7, 20};
        int sum = 5;

        findPair(array2, sum);
        findPairWithClosestToX(array2, sum);
    }

    private static void findPair(int[] array, int sum) {
        int firstElement = 0;
        int secondElement = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentDiff = Math.abs(Math.abs(array[i] + array[j]) - sum);
                if (currentDiff < diff) {
                    firstElement = array[i];
                    secondElement = array[j];
                    diff = currentDiff;
                }
            }
        }

        System.out.println("Closest pair to given sum " + sum + " is " + firstElement + " and " + secondElement + " with difference: " + diff);
    }

    public static void findPairWithClosestToX(int arr[],int X) {

        int minimumDiff = Integer.MAX_VALUE;
        int n=arr.length;
        if(n<0)
            return;
        // left and right index variables
        int l = 0, r = n-1;

        // variable to keep track of the left and right pair for minimumSum
        int minLeft = l, minRight = n-1;

        while(l < r)
        {

            int currentDiff= Math.abs(arr[l] + arr[r]-X);
            /*If abs(diff) is less than min dif, we need to update sum and pair */
            if(currentDiff < minimumDiff)
            {
                minimumDiff = currentDiff;
                minLeft = l;
                minRight = r;
            }
            if(arr[l] + arr[r] < X)
                l++;
            else
                r--;
        }

        System.out.println(" The pair whose sum is closest to X : "+arr[minLeft]+" "+ arr[minRight] + " with difference: " + minimumDiff);
    }
}
