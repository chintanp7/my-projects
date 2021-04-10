package com.chintan.ds;

public class SeparateOddEvenMain {

    public static void main(String[] args) {

        int arr[]={12, 17, 70, 15, 22, 65, 21, 90, 11, 20, 24, 30};
        System.out.println("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        arr=separateEvenOddNumbers(arr);
        System.out.println("nArray after separating even and odd numbers : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] separateEvenOddNumbers(int arr[])
    {
        int left=0;
        int right=arr.length-1;
        for (int i = 0; i < arr.length; i++) {

            while(arr[left]%2==0)
            {
                left++;
            }
            while(arr[right]%2==1)
            {
                right--;
            }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            } else {
                break;
            }
        }
        return arr;
    }
}
