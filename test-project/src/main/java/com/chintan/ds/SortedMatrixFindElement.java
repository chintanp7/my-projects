package com.chintan.ds;

public class SortedMatrixFindElement {

    static int count = 1;

    public static void main(String[] args) {
        int[][] sortedMatrix = {
            {1, 6, 10, 12, 20},
            {4, 8, 15, 22, 25},
            {5, 19, 35, 37, 40},
            {10, 28, 38, 45, 55}
        };

        findElement(sortedMatrix, 19);
    }

    private static void findElement(int[][] sortedMatrix, int element) {
        int row = sortedMatrix.length;
        int column = sortedMatrix[0].length;
        int r = 0, c = column - 1;

        while (r <= row - 1 && c >= 0) {
            if (sortedMatrix[r][c] == element) {
                System.out.println("Found the element in " + count + " iteration");
                return;
            }
            if (element > sortedMatrix[r][c]) {
                r++;
            } else {
                c--;
            }
            count++;
        }
        System.out.println("Could not find the element");
    }
}
