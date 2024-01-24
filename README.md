# sorting-algorithms

## Merge Sort

### Basic information

- Divide-and-conquer algorithm
- Stable algorithm
- Requires extra space

### Idea

1. Divide the input array into two halves (pivot being midpoint of array). Carried out recursively until there are no more half arrays.
2. Sort and merge the divided arrays from bottom to top to get sorted array.

### Time Complexity

- Average, worst and best: O(n log n) - expressed also as T(n) = 2T(n/2) + O(n)

2T(n/2) - time required to sort sub-arrays
O(n) - time to merge entire array

Space complexity: O(n) - we are creating temporary arrays in every call.

## Quick Sort

### Basic information

- Divide-and-conquer principle
- Not a stable algorithm (A stable sorting algorithm is an algorithm where the elements with the same values appear in the same order in the sorted output as they appear in the input list.)
- "in-place" algorithm (no additional storage space needed to perform sorting)
- Java's Arrays.sort() uses quicksort

### Idea

1.  Choose element (pivot) from the list
2.  Divide it into two sub-lists: elements with smaller value than pivot are placed before it, the ones greater after it. This is pivot's final position.
3.  Apply above steps recursively to both sub-lists on the left and right of the pivot.

Crucial for Quicksort is choosing the best pivot. It would be the middle element as it would divide the list into two equal sub-lists. But finding it from unordered list would be difficult and time-consuming so we take the first/last/median/random element as pivot.

### Time complexity

- Average: O(n log n) - suitable for big data volumes
- Best: O(n log n) - Two equal sub-lists
- Worst: O(n^2)

Best case:
First full sized iteration O(n), two remaining equal sub-lists: 2*O(n/2). Result: O(n log n).

Worst case:
The algorithm selects only one element each iteration, so O(n) + O(n - 1) + ... + O(1) = O(n^2).


## Quick Sort vs Merge Sort

- Both have time complexity of O(n log n).
- Quicksort has O(log(n)) space complexity, while Merge Sort requires O(n) - expensive for Arrays.
- Quicksort requires to access different indices for its operations, but this access is not directly possible in linked lists, as there are no continuous blocks; therefore to access an element we have to iterate through each node from the beginning of the linked list. Also, Mergesort is implemented without extra space for LinkedLists. In such case, overhead increases for Quicksort and Mergesort is generally preferred.
- Quicksort cannot work well with large datasets, while Merge sort can (Merge sort is more efficient for large datasets, while Quicksort for small)
- Merge sort is better for large data structures as it is stable and can easily be adapted to work on linked lists and very large lists stored on slow-to-access media (Merge sort is preferred for linked lists, while Quicksort for arrays)