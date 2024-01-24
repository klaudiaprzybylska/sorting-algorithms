package org.example;

public class Quicksort {

    public static void main(String[] args) {
        int[] arrayToBeSorted = {13, 3, 2, 1, 10};
        quickSort(arrayToBeSorted, 0, 4);

        for (int i : arrayToBeSorted) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        // if the array has more than 1 element
        if (begin < end) {
            // find pivot and move smaller elements left of it and greater right of it
            int partitionIndex = partition(arr, begin, end);

            // do it again for both left and right array
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        // pivot is last element in array
        int pivot = arr[end];
        // i is the index of first element, it is the position where we insert swapped elements
        int i = (begin-1);

        // from first to second to last element we iterate
        for (int j = begin; j < end; j++) {
            // if element is smaller or equal to pivot we swap it with i
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        // we swap the next i with pivot
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        // we return pivot's position
        return i+1;
    }
}
