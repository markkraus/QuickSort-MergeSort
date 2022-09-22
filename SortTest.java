

import java.util.*;
public class SortTest
{
	public static Random R = new Random();  // Make a single Random object


	private ArrayList<Sorter<Integer>> sorts;
	// Data to sort will be an array of Integer
	private Integer [] A, temp;
	private int size;

	// Fill array with random data
	public void fillArray(Integer [] arr)
	{
		for (int i = 0; i < A.length; i++)
		{
			// Values will be 0 <= X < 2 billion
			arr[i] = Integer.valueOf(R.nextInt(2000000000));
		}
	}

	public void copyArray(Integer [] orig, Integer [] copy)
	{
		for (int i = 0; i < orig.length; i++)
			copy[i] = orig[i];
	}

	public void showArray(Integer [] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	public SortTest(String sz, String a)
	{
		// Set the array size from the sz parameter, which is passed in from a
		// command line arbumetn -- see main() method below.
		size = Integer.parseInt(sz);


		sorts = new ArrayList<Sorter<Integer>>();
		sorts.add(new QuickSort<Integer>(new SimplePivot<Integer>()));
//		sorts.add(new QuickSort<Integer>(new MedOfThree<Integer>()));
//		sorts.add(new QuickSort<Integer>(new RandomPivot<Integer>()));
//		sorts.add(new QuickSort<Integer>(new MedOfFive<Integer>()));
//		sorts.add(new MergeSort<Integer>());

		temp = new Integer[size];
		A = new Integer[size];

		R.setSeed(1234);  // Seed the random number generator.
		fillArray(temp);  // put random data into temp array

		// Iterate through all of the sorts and test each one
		for (int i = 0; i < sorts.size(); i++)
		{
			copyArray(temp, A);  // copy random data from temp into array A.  

			System.out.println("Initial data for algo " + i);
			showArray(A);
			// Get the current Sorter<T> object, set the min and sort the data
			sorts.get(i).setMin(5);
			sorts.get(i).sort(A, A.length);
			System.out.println("Sorted data for algo " + i);
			showArray(A);
			System.out.println("--------------------------------");
		}
	}

	public static void main(String [] args)
	{
		new SortTest(args[0], args[1]);
	}
}
