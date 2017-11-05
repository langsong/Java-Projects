package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class SortsTest {

	@Test
	public void selectionTest1() {
		// test for random integer
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		Sorts.<Integer>selectionSort(case1);
		assertArrayEquals(case1, sortedcase1);
	}

	@Test
	public void selectionTest2() {
		//test for random character
		Character[] case2 = new Character[]{'b','i','q','e','f','c','h','r','d'};
		Character[] sortedcase2 = new Character[]{'b','c','d','e','f','h','i','q','r'};
		Sorts.<Character>selectionSort(case2);
		assertArrayEquals(case2, sortedcase2);	
	}
	@Test
	public void selectionTest3() {
		//test for sorted integer array
		Integer[] case3 = new Integer[]{0,1,2,3,4,5,6,8};
		Integer[] sortedcase3 = new Integer[]{0,1,2,3,4,5,6,8};
		Sorts.<Integer>selectionSort(case3);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public void insertionTest1() {
		// test for random integer
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		Sorts.<Integer>insertionSort(case1);
		assertArrayEquals(case1, sortedcase1);
	}
	@Test
	public void insertionTest2() {
		//test for random character
		Character[] case2 = new Character[]{'b','i','q','e','f','c','h','r','d'};
		Character[] sortedcase2 = new Character[]{'b','c','d','e','f','h','i','q','r'};
		Sorts.<Character>insertionSort(case2);
		assertArrayEquals(case2, sortedcase2);	
	}
	@Test
	public void insertionTest3() {
		//test for sorted integer array
		Integer[] case3 = new Integer[]{0,1,2,3,4,5,6,8};
		Integer[] sortedcase3 = new Integer[]{0,1,2,3,4,5,6,8};
		Sorts.<Integer>insertionSort(case3);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public void mergeTest1() {
		// test for random integer
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		int end = case1.length-1;
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		Sorts.<Integer>mergeSort(case1,0,end);
		assertArrayEquals(case1, sortedcase1);
	}
	@Test
	public void mergeTest2() {
		//test for random character
		Character[] case2 = new Character[]{'b','i','q','e','f','c','h','r','d'};
		int end = case2.length-1;
		Character[] sortedcase2 = new Character[]{'b','c','d','e','f','h','i','q','r'};
		Sorts.<Character>mergeSort(case2,0,end);
		assertArrayEquals(case2, sortedcase2);	
	}
	@Test
	public void mergeTest3() {
		//test for sorted integer array
		Integer[] case3 = new Integer[]{0,1,2,3,4,5,6,8};
		int end = case3.length-1;
		Integer[] sortedcase3 = new Integer[]{0,1,2,3,4,5,6,8};
		Sorts.<Integer>mergeSort(case3,0,end);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public void mergeTest4() {
		//test for half sorted array
		Integer[] case3 = new Integer[]{0,1,3,5,8,-2,13,6,1,9};
		int end = case3.length-1;
		Integer[] sortedcase3 = new Integer[]{-2,0,1,1,3,5,6,8,9,13};
		Sorts.<Integer>mergeSort(case3,0,end);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public void quickTest1() {
		// test for random integer
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		int end = case1.length-1;
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		Sorts.<Integer>quickSort(case1,0,end);
		assertArrayEquals(case1, sortedcase1);
	}
	@Test
	public void quickTest2() {
		//test for random character
		Character[] case2 = new Character[]{'b','i','q','e','f','c','h','r','d'};
		int end = case2.length-1;
		Character[] sortedcase2 = new Character[]{'b','c','d','e','f','h','i','q','r'};
		Sorts.<Character>quickSort(case2,0,end);
		assertArrayEquals(case2, sortedcase2);	
	}
	@Test
	public void quickTest3() {
		//test for sorted integer array
		Integer[] case3 = new Integer[]{0,1,2,3,4,5,6,8};
		int end = case3.length-1;
		Integer[] sortedcase3 = new Integer[]{0,1,2,3,4,5,6,8};
		Sorts.<Integer>quickSort(case3,0,end);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public void quickTest4() {
		//test for an array that chosen pivot is the minimum 
		Integer[] case3 = new Integer[]{1,8,2,-4,1,9,5,7,1};
		int end = case3.length-1;
		Integer[] sortedcase3 = new Integer[]{-4,1,1,1,2,5,7,8,9};
		Sorts.<Integer>quickSort(case3,0,end);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public void costumtest1() {
		// test for random integer
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		Sorts.<Integer>customSort(case1);
		assertArrayEquals(case1, sortedcase1);
	}
	@Test
	public void costumtest2() {
		//test for random character
		Character[] case2 = new Character[]{'b','i','q','e','f','c','h','r','d'};
		Character[] sortedcase2 = new Character[]{'b','c','d','e','f','h','i','q','r'};
		Sorts.<Character>customSort(case2);
		assertArrayEquals(case2, sortedcase2);	
	}
	@Test
	public void costumtest3() {
		//test for sorted integer array
		Integer[] case3 = new Integer[]{0,1,2,3,4,5,6,8};
		Integer[] sortedcase3 = new Integer[]{0,1,2,3,4,5,6,8};
		Sorts.<Integer>customSort(case3);
		assertArrayEquals(case3, sortedcase3);
	}
	@Test
	public <T> void eventcostume() {
		//test for bubblesort's event list
		List<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		int len = case1.length;
		Integer[] copy = Arrays.copyOf(case1, len);
		events = Sorts.customSort(case1);
		Sorts.eventSort(copy, events);
		assertArrayEquals(copy, sortedcase1);
	}
	@Test
	public <T> void eventinsertion() {
		//test for insertionsort's event list
		List<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		int len = case1.length;
		Integer[] copy = Arrays.copyOf(case1, len);
		events = Sorts.insertionSort(case1);
		Sorts.eventSort(copy, events);
		assertArrayEquals(copy, sortedcase1);
	}
	@Test
	public <T> void eventselection() {
		//test for selectionsort's event list
		List<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		int len = case1.length;
		Integer[] copy = Arrays.copyOf(case1, len);
		events = Sorts.selectionSort(case1);
		Sorts.eventSort(copy, events);
		assertArrayEquals(copy, sortedcase1);
	}
	@Test
	public <T> void eventmerge() {
		//test for mergesort's event list
		List<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		int len = case1.length;
		Integer[] copy = case1.clone();
		events = Sorts.mergeSort(case1,0,len-1);
		Sorts.eventSort(copy, events);
		assertArrayEquals(copy, sortedcase1);
	}
	@Test
	public <T> void eventquick() {
		//test for quicksort's event list
		List<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
		Integer[] case1 = new Integer[]{5,8,3,4,15,-2,5,1,0,8};
		Integer[] sortedcase1 = new Integer[]{-2,0,1,3,4,5,5,8,8,15};
		int len = case1.length;
		Integer[] copy = Arrays.copyOf(case1, len);
		events = Sorts.quickSort(case1,0,len-1);
		Sorts.eventSort(copy, events);
		assertArrayEquals(copy, sortedcase1);
	}

}
