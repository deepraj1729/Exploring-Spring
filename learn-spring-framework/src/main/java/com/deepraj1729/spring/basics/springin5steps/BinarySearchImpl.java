package com.deepraj1729.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearchImpl(SortAlgorithm sortAlgorithm){
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
	
	public int search(int[] arr,int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            if (arr[mid] == x)
                return mid;
 

            if (arr[mid] > x)
                return search(arr, l, mid - 1, x);
 

            return search(arr, mid + 1, r, x);
        }
        return -1;
	}
	
	public int binarySearch(int[] numbers,int numberToSearchFor) {
		
		//Implement sorting logic
		/* 
			- Bubble Sort
			- Quick Sort
			- Merge Sort
			- Heap Sort
		*/
		int arrayLength = numbers.length;
		int [] sortedList = sortAlgorithm.sort(numbers,0,arrayLength-1);
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Sorted List: ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		for(int i:sortedList)
			System.out.print(i+" ");
		System.out.println("");
		
		

		//Searching the array
		int result = search(numbers,0,arrayLength - 1,numberToSearchFor);
		
		
		//Returning the result
		return result;
	}
}
