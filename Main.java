package radixsort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[10] ;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdu numerele Array-ului:");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		//create a boject type Radix
		Radix rx = new Radix();
		
		System.out.println("Array-ul nesortat este:");
		rx.displayArray(array);
		array = rx.radixSort(array);
		System.out.println("Array-ul sortat este:");
		rx.displayArray(array);
		
		sc.close();
		
	}
}
