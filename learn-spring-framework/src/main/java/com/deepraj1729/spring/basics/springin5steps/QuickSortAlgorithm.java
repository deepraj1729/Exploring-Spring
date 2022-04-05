package com.deepraj1729.spring.basics.springin5steps;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	         
	        int pi = partition(arr, low, high);
	        sort(arr, low, pi - 1);
	        sort(arr, pi + 1, high);
	    }
	    System.out.println("Implementing Quick Sort");
	    return arr;
	}
	
	
	// A utility function to swap two elements
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

	
	static int partition(int[] arr, int low, int high)
	{
	     
	    int pivot = arr[high];
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         
	        if (arr[j] < pivot)
	        {
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	 

	
	 
}
