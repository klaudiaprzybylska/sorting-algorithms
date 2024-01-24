package org.example;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrayToBeSorted = {0, 3, 6, 2, 8};
        mergeSort(arrayToBeSorted, 5);

        for (int i : arrayToBeSorted) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] array, int length) {
        // if there is only one element in array, return it
        if (length < 2) {
            return;
        }

        // find pivot position
        int mid = length / 2;
        // divide into two arrays using pivot
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        // move elements into left array
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        // move elements into right array
        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = array[i];
        }
        // sort left and right array
        mergeSort(leftArray, mid);
        mergeSort(rightArray, length - mid);

        // merge both arrays
        merge(array, leftArray, rightArray, mid, length - mid);
    }

    public static void merge(
            int[] array, int[] leftArray, int[] rightArray, int leftLength, int rightLength) {

        int i = 0, j = 0, k = 0;
        // if both arrays have elements in them
        while (i < leftLength && j < rightLength) {
            // if first available element of left is smaller than or equal to right put it in the array, else put the right one in the array
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        // if only left or right array has elements, move these elements to array
        while (i < leftLength) {
            array[k++] = leftArray[i++];
        }
        while (j < rightLength) {
            array[k++] = rightArray[j++];
        }
    }
}
