package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class Sorts {
    /**
     * swap the positions of two elements of the given array
     * @param arr, the array to swap
     * @param i, the first index of swap
     * @param j the second index of swap
     */
    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * Sort the array by algorithm of selection sort
     * @param arr, the array to sort
     * @return an eventlist recording all the events
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(
            T[] arr) {
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        for (int i = 0; i < arr.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i; j < arr.length; j++) {
                SortEvent<T> com1 = new CompareEvent<T>(j, lowestIndex);
                ret.add(com1);
                if (arr[j].compareTo(arr[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            SortEvent<T> swap1 = new SwapEvent<T>(i, lowestIndex);
            ret.add(swap1);
            swap(arr, i, lowestIndex);
        }
        return ret;
    }
    /**
     * Sort the array by algorithm of insertion sort
     * @param arr, the array to sort
     * @return an eventlist recording all the events
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(
            T[] arr) {
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                SortEvent<T> com1 = new CompareEvent<T>(j - 1, j);
                ret.add(com1);
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    SortEvent<T> swap1 = new SwapEvent<T>(j, j - 1);
                    ret.add(swap1);
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * helper function for mergeSort that merge an array of two sorted subarrays
     * @param arr, an array of two sorted subarrays.
     * @param start, the start index of first subarray
     * @param mid, the end index of first subarray
     * @param end, the end index of second subarray
     * @return an eventlist recording all the events
     */
    @SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> List<SortEvent<T>> merge(T[] arr,
            int start, int mid, int end) {
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        // set up index for each subarray and temporary array
        int i = start;
        int j = mid + 1;
        int k = 0;
        // initialize a temporary array
        Object[] temp = new Object[end - start + 1];
        // compare two subarray and copy it into the temporary array
        while (i <= mid && j <= end) {
            SortEvent<T> com = new CompareEvent<T>(i, j);
            ret.add(com);
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // after one subarray is completed, add the rest of the other array to
        // the temporary array
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }
        // copy the values in temporary array back to original array
        for (int m = 0; m < end - start + 1; m++) {
            SortEvent<T> cop = new CopyEvent<T>(m + start, (T) temp[m]);
            ret.add(cop);
            arr[m + start] = (T) temp[m];
        }

        return ret;
    }
    /**
     * Sort the array by algorithm of merge sort
     * @param arr, an array to sort
     * @param start, the start index for sorting 
     * @param end, the end index for sorting
     * @return an eventlist recording all the events
     */
    // mergeSort
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(
            T[] arr, int start, int end) {
        if ((arr.length <= 1) || (end <= start)) {
            return null;
        } else {
            List<SortEvent<T>> ret1 = new ArrayList<SortEvent<T>>();
            List<SortEvent<T>> ret2 = new ArrayList<SortEvent<T>>();
            List<SortEvent<T>> ret3 = new ArrayList<SortEvent<T>>();
            List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
            int mid = (int) start + (end - start) / 2;
            ret1 = mergeSort(arr, start, mid);
            ret2 = mergeSort(arr, mid + 1, end);
            ret3 = merge(arr, start, mid, end);
            if (ret1 != null)
                ret.addAll(ret1);
            if (ret2 != null)
                ret.addAll(ret2);
            if (ret3 != null)
                ret.addAll(ret3);
            return ret;
        }
    }
    /**
     * Sort the array by algorithm of quick sort
     * @param arr, an array to sort
     * @param start, the start index for sorting 
     * @param end, the end index for sorting
     * @return an eventlist recording all the events
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(
            T[] arr, int start, int end) {
        if (end > start) {
            List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
            List<SortEvent<T>> ret1 = new ArrayList<SortEvent<T>>();
            List<SortEvent<T>> ret2 = new ArrayList<SortEvent<T>>();
            int mid = (end - start) / 2;
            int pivot;
            SortEvent<T> com = new CompareEvent<T>(start, end);
            ret.add(com);
            if (arr[start].compareTo(arr[end]) < 0) {
                com = new CompareEvent<T>(end, mid);
                ret.add(com);
                if (arr[end].compareTo(arr[mid]) < 0) {
                    pivot = end;
                } else {
                    com = new CompareEvent<T>(start, mid);
                    ret.add(com);
                    if (arr[start].compareTo(arr[mid]) > 0) {
                        pivot = start;
                    } else {
                        pivot = mid;
                    }
                }
            } else {
                com = new CompareEvent<T>(end, mid);
                ret.add(com);
                if (arr[end].compareTo(arr[mid]) > 0) {
                    pivot = end;
                } else {
                    com = new CompareEvent<T>(start, mid);
                    ret.add(com);
                    if (arr[start].compareTo(arr[mid]) < 0) {
                        pivot = start;
                    } else {
                        pivot = mid;
                    }
                }
            }
            SortEvent<T> swap1 = new SwapEvent<T>(pivot, end);
            ret.add(swap1);
            swap(arr, pivot, end);
            int i = start;
            int j = end - 1;
            while (i <= j) {
                com = new CompareEvent<T>(i, end);
                ret.add(com);
                if (arr[i].compareTo(arr[end]) > 0) {
                    com = new CompareEvent<T>(j, end);
                    ret.add(com);
                    if (arr[j].compareTo(arr[end]) < 0) {
                        swap1 = new SwapEvent<T>(i, j);
                        ret.add(swap1);
                        swap(arr, i++, j--);
                    } else {
                        j--;
                    }
                } else {
                    i++;
                }
            }
            swap1 = new SwapEvent<T>(i, end);
            ret.add(swap1);
            swap(arr, i, end);
            ret1 = quickSort(arr, start, i - 1);
            ret2 = quickSort(arr, i + 1, end);
            if (ret1 != null)
                ret.addAll(ret1);
            if (ret2 != null)
                ret.addAll(ret2);
            return ret;
        } else {
            return null;
        }
    }
    /**
     * Sort the array by algorithm of bubble sort
     * @param arr, an array to sort
     * @return an eventlist recording all the events
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> customSort(
            T[] arr) {
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        SortEvent<T> com;
        SortEvent<T> swap;
        int len = arr.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < len - 1; i++) {
                com = new CompareEvent<T>(i, i + 1);
                ret.add(com);
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap = new SwapEvent<T>(i, i + 1);
                    ret.add(swap);
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        }
        return ret;
    }
    /**
     * Apply events in the given SortEvent to the given array
     * @param arr, an array to sort
     * @param events, an eventlist recording all the events to apply.
     */
    public static <T> void eventSort(T[] arr, List<SortEvent<T>> events) {
        int len = events.size();
        for (int i = 0; i < len; i++) {
            events.get(i).apply(arr);
        }
    }
}
