package sortingAlgo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class algoSort {
	static void insertionSort(Object[] A) {
		int n = A.length;
		for(int i = 1; i < n; ++i) {
			int k = (int) A[i];
			int j = i - 1;
				while (j >= 0 && (int) A[j] > k) {
					A[j + 1] = A[j];
					j = j - 1;
				}
				A[j + 1] = k;
		}
	}

	static void quickSort(Object[] A, int first, int last)
    {
        if (first < last)
        {
            int pi = partition(A, first, last);
            quickSort(A, first, pi-1);
            quickSort(A, pi+1, last);
        }
    }
	static int partition(Object[] A, int first, int last)
    {
        int pivot = (int) A[last];
        int i = first - 1;
        Integer[] integerArray = new Integer[A.length];
        for(int w = 0; w < A.length; w++)
        	integerArray[w] = (Integer)A[w];
        for (int j=first; j<last; j++)
        {
            if ( integerArray[j] < pivot)
            {
                i++;
                int temp = (int) A[i];
                A[i] = (int) A[j];
                A[j] = temp;
            }
        }
        int temp = (int) A[i+1];
        A[i+1] = (int) A[last];
        A[last] = temp;
        return i+1;
    }

	static void mergeSort(Object[] A, int first, int last)
    {
        if (first < last)
        {
            int middle = (first+last)/2;
            mergeSort(A, first, middle);
            mergeSort(A , middle + 1, last);
            merge(A, first, middle, last);
        }
    }

	static void merge(Object[] A, int first, int mid, int last)
    {
		int subA = mid - first + 1;
        int subB = last - mid;
        int arrA[] = new int [subA];
        int arrB[] = new int [subB];

        for (int i=0; i < subA; ++i) {
            arrA[i] = (int) A[first + i]; }
        for (int j=0; j < subB; ++j) {
            arrB[j] = (int) A[mid + 1 + j]; }

        int x = 0;
        int y = 0;
        int z = first;
        while (x < subA && y < subB) {
            if (arrA[x] <= arrB[y]) {
                A[z] = arrA[x];
                x++;
            }
            else {
                A[z] = arrB[y];
                y++;
            } z++;
        }
        while (x < subA) {
            A[z] = arrA[x];
            x++;
            z++;
        }
        while (y < subB) {
            A[z] = arrB[y];
            y++;
            z++;
        }
    }

	static void printArray(Object[] array) {
		int n = array.length;
		for(int i = 0; i < n; ++i) {
			System.out.print(array[i] + " ");
			if(i != 0 && i % 10 == 0)
				System.out.println("\n");}
		System.out.println();
	}

	public static void main(String args[]) throws IOException {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Each of the lists below is random, reversed, or sorted.\n"
				+ "This program will use insertion sort, quick sort, and merge sort on test .txt files.");
		System.out.println("\n10_Random.txt, 10_Reverse.txt, 10_Sorted.txt"
				+ "\n100_Random.txt, 100_Reverse.txt, 100_Sorted.txt"
				+ "\n1000_Random.txt, 1000_Reverse.txt, 1000_Sorted.txt");
		System.out.println("\nPlease enter one of the list above. Ex: 10_Reverse.txt");
		String file1 = myObj.nextLine();

		BufferedReader br1 = new BufferedReader(new FileReader(file1));
		ArrayList<Integer> listOfLines = new ArrayList<Integer>();
		int count = 0;
		String line = null;
		while((line = br1.readLine()) != null) {
			String []strNumbers = line.split(" ");
				for(String strNumber : strNumbers) {
					listOfLines.add(Integer.parseInt(strNumber));
			 		count++;
			 	}
		}
		br1.close();
		myObj.close();
		Object[] iSort = listOfLines.toArray();
		Object[] qSort = listOfLines.toArray();
		Object[] mSort = listOfLines.toArray();
		Object[] lOfl = listOfLines.toArray();

		System.out.println("\n"+file1+"\n");
		printArray(lOfl);
		System.out.println("\nInsertion sort:\n");
		insertionSort(iSort);
		printArray(iSort);
		System.out.println("\nQuick sort:\n");
		quickSort(qSort, 0,qSort.length - 1);
	    printArray(qSort);
		System.out.println("\nMerge sort:\n");
		mergeSort(mSort, 0, mSort.length-1);
		printArray(mSort);
	    System.out.println("\nCount = "+count);
	}
}
