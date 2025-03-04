package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"Winter", "Spring", "Summer", "Autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] result = new int[length];
        for (int i=0; i<length; i++)
            result[i]=i+1;
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int result = 0;
        for(int i=0; i<arr.length; i++)
            result+=arr[i];
        return result;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i=0; i<arr.length; i++)
            if(arr[i] == number) return i;
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] result = new String[arr.length];
        for(int i=0; i<arr.length; i++)
            result[i]=arr[arr.length-1-i];
        return result;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int len = 0, index = 0;
        for(int i=0; i<arr.length; i++)
            if(arr[i]>0) len++;
        int[] result = new int[len];
        for(int i=0; i<arr.length; i++)
            if(arr[i]>0) result[index++]=arr[i];
        return result;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[3, 2], [3, 1, 2]]
     * arr = [[5, 4], [7]]       -> [[7], [5, 4]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        print(arr);
        int indexOfMinLength, minLength;
        for(int i=0; i<arr.length-1; i++){
            minLength = arr[i].length;
            indexOfMinLength = i;
            for(int j=i+1; j<arr.length; j++){
                if(minLength > arr[j].length){
                    minLength = arr[j].length;
                    indexOfMinLength = j;
                }
            }
            if(i!=indexOfMinLength) {
                int[] temp = arr[i];
                arr[i] = arr[indexOfMinLength];
                arr[indexOfMinLength] = temp;
            }
        }
        for(int k=0; k<arr.length; k++)
            sort(arr[k]);

        print(arr);
        return arr;
    }

    public void sort(int[] arr) {
        int minElemOfArr, indexOfMinElem;
        for (int i = 0; i < arr.length-1; i++) {
            minElemOfArr = arr[i];
            indexOfMinElem = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (minElemOfArr > arr[j]) {
                    minElemOfArr = arr[j];
                    indexOfMinElem = j;
                }
            }
            if (i != indexOfMinElem) {
                int temp2 = arr[i];
                arr[i] = arr[indexOfMinElem];
                arr[indexOfMinElem] = temp2;
            }
        }
    }

    private void print(int[][] arr){
        System.out.println();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(" "+arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
