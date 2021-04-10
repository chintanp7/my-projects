package com.chintan.ds;

public class MaxDifferenceMain {
    public static int calculateMaxDifferenceBetweenTwoElements(int[] arr)
    {
        int minElementTillNow=arr[0];
        int maxDifference=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int difference=0;
            if(arr[i] >minElementTillNow)
            {
                difference=arr[i]-minElementTillNow;
                if(difference > maxDifference)
                {
                    maxDifference=difference;
                }
            }
            else
            {
                minElementTillNow=arr[i];
            }
        }
        return maxDifference;
    }

    public static void main(String[] args) {
        int arr[]={14, 12, 70, 15, 95, 65, 22, 10, 30};
        System.out.println("Maximum difference between two elements : "+calculateMaxDifferenceBetweenTwoElements(arr));

    }
}
