
import java.util.ArrayList;
import java.util.Random;


public class Assig4  {



    public static void main(String args[]){
    Random R = new Random();  // Make a single Random object


    ArrayList<Sorter<Integer>> sorts;
    ArrayList<Double> totalTimes = new ArrayList<Double>(); // all of the seperate run times of each algo

    // Data to sort will be an array of Integer
    Integer [] A, temp;
    int size;
    int numOfTrials;
    double avg = 0;


        size = Integer.parseInt(args[0]);
        numOfTrials = Integer.parseInt(args[1]);

        // Put the sorting objects into the ArrayList.
        sorts = new ArrayList<Sorter<Integer>>();
        sorts.add(new QuickSort<Integer>(new SimplePivot<Integer>()));
        sorts.add(new QuickSort<Integer>(new MedOfThree<Integer>()));
        sorts.add(new QuickSort<Integer>(new RandomPivot<Integer>()));
        sorts.add(new QuickSort<Integer>(new MedOfFive<Integer>()));
        sorts.add(new MergeSort<Integer>());

        temp = new Integer[size];
        A = new Integer[size];



        sequenceArray(temp, size);  // put sequenced data into temp array
    int testNum = Integer.parseInt(args[0]);
    int runNum = Integer.parseInt(args[1]);
    System.out.println("Initialization information:");
    System.out.println("Array size: " + testNum);
    System.out.println("Number of runs per test: " + runNum);
    System.out.println("");


        // Iterate through all of the sorts and test each one
        for (int i = 0; i < sorts.size(); i++)
        {


            copyArray(temp, A);  // copy random data from temp into array A.

            R.setSeed(1234);  // Seed the random number generator.  T
            sorts.get(i).setMin(5);
           double times = 0;
            for(int j = 0; j < numOfTrials; j++){   //Sorts the data using each sort Object
                shuffle(A,R);
                long start = System.nanoTime();
                sorts.get(i).sort(A, A.length);
                long stop = System.nanoTime();
                long diff = stop - start;
                double sec = (double) diff / 1000000000;
                times = times + sec;
                totalTimes.add(times);
            }
            ArrayList<Double> avgTime = new ArrayList<>();
            avg = times / numOfTrials;
            avgTime.add(avg);
            //System.out.println("Avg: " + avgTime);
//            System.out.println("Initial data for algo " + i);
//            showArray(A);
//            // Get the current Sorter<T> object, set the min and sort the data
//            sorts.get(i).setMin(5);
//            sorts.get(i).sort(A, A.length);
//            System.out.println("Sorted data for algo " + i);
//            showArray(A);
//            System.out.println("--------------------------------");
        }


        //ArrayLists to store the fastest/slowest QuickSort algos
        Double fast = totalTimes.get(0);
        Double slow = totalTimes.get(0);


    for(int i = 1; i < sorts.size(); i++){   //For fastest Run
            if(totalTimes.get(i) < fast){
                fast = totalTimes.get(i);
            }
        }

//        if(quickWinner.get(0) < totalTimes.get(5)) {
//            System.out.println("After the tests, here is the best setup: " + quickWinner.get(0));
//         }else{
//            System.out.println("After the tests, here is the best setup: " + totalTimes.get(5));
//        }

        for(int i = 1; i < sorts.size(); i++){ // For slowest run
            if(totalTimes.get(i) > slow){
                slow = totalTimes.get(i);
            }
        }

        if(fast == totalTimes.get(0)){
            System.out.println("After the tests, here is the best setup:");
            System.out.println("Algorithm: Simple Pivot QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(0));
            System.out.println("Average: " + totalTimes.get(0));
            System.out.println("");
        }else if(fast == totalTimes.get(1)){
            System.out.println("After the tests, here is the best setup:");
            System.out.println("Algorithm: Median of Three QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(1));
            System.out.println("Average: " + totalTimes.get(1));
            System.out.println("");
        }else if(fast == totalTimes.get(2)){
            System.out.println("After the tests, here is the best setup:");
            System.out.println("Algorithm: Random Pivot QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(2));
            System.out.println("Average: " + totalTimes.get(2));
            System.out.println("");
        }else if(fast == totalTimes.get(3)){
            System.out.println("After the tests, here is the best setup:");
            System.out.println("Algorithm: Median of Five QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(3));
            System.out.println("Average: " + totalTimes.get(3));
            System.out.println("");
        }else {
            System.out.println("After the tests, here is the best setup:");
            System.out.println("Algorithm: MergeSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(4));
            System.out.println("Average: " + totalTimes.get(4));
            System.out.println("");
        }

        if(slow == totalTimes.get(0)){
            System.out.println("After the tests, here is the worst setup:");
            System.out.println("Algorithm: Simple Pivot QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(0));
            System.out.println("Average: " + totalTimes.get(0));
            System.out.println("");
        }else if(slow == totalTimes.get(1)){
            System.out.println("After the tests, here is the worst setup:");
            System.out.println("Algorithm: Median of Three QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(1));
            System.out.println("Average: " + totalTimes.get(1));
            System.out.println("");
        }else if(slow == totalTimes.get(2)){
            System.out.println("After the tests, here is the worst setup:");
            System.out.println("Algorithm: Random Pivot QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(2));
            System.out.println("Average: " + totalTimes.get(2));
            System.out.println("");
        }else if(slow == totalTimes.get(3)){
            System.out.println("After the tests, here is the worst setup:");
            System.out.println("Algorithm: Median of Five QuickSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(3));
            System.out.println("Average: " + totalTimes.get(3));
            System.out.println("");
        }else {
            System.out.println("After the tests, here is the worst setup:");
            System.out.println("Algorithm: MergeSort");
            System.out.println("Min Recurse: " + QuickSort.Count.getCount(4));
            System.out.println("Average: " + totalTimes.get(4));
            System.out.println("");
        }

        System.out.println("Here are the per algorithm results:");
        System.out.println("Algorithm: Simple Pivot QuickSort");
        System.out.println("Min Recurse: " + QuickSort.Count.getCount(0));
        System.out.println("Average: " + totalTimes.get(0));
        System.out.println("");
        System.out.println("Algorithm: Median of Three QuickSort");
        System.out.println("Min Recurse: " + QuickSort.Count.getCount(1));
        System.out.println("Average: " + totalTimes.get(1));
        System.out.println("");
        System.out.println("Algorithm: Random Pivot QuickSort");
        System.out.println("Min Recurse: " + QuickSort.Count.getCount(2));
        System.out.println("Average: " + totalTimes.get(2));
        System.out.println("");
        System.out.println("Algorithm: Median of Five QuickSort");
        System.out.println("Min Recurse: " + QuickSort.Count.getCount(3));
        System.out.println("Average: " + totalTimes.get(3));
        System.out.println("");
        System.out.println("Algorithm: MergeSort");
        System.out.println("Min Recurse: " + QuickSort.Count.getCount(4));
        System.out.println("Average: " + totalTimes.get(4));
        System.out.println("");

//        System.out.println("Min Recurse: " +  Count.getCount());
//        System.out.println("Best Setup:" + totalTimes.get(quickWinner.get(0)));
//        System.out.println("Worst Setup: " + totalTimes.get(quickLoser.get(0)));
//        System.out.println("");

    }
    // Fill array with random data
    public static void fillArray(Integer [] arr)
    {
        Random R = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            // Values will be 0 <= X < 2 billion
            arr[i] = Integer.valueOf(R.nextInt(2000000000));
        }
    }

    public static void sequenceArray(Integer [] a, Integer N){
        for (int i = 1; i <= N; i++){
            a[i - 1] = i;
        }
    }

    public static void shuffle(Integer [] a, Random r) {
        for(int i = 0; i< a.length; i++){
            int randIndex = r.nextInt(a.length);
            Integer temp = a[randIndex];
            if(temp != null){
                a[randIndex] = a[0];
                a[0] = temp;
            }
        }
    }


    public static void copyArray(Integer [] orig, Integer [] copy)
    {
        for (int i = 0; i < orig.length; i++)
            copy[i] = orig[i];
    }

    public static void showArray(Integer [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
