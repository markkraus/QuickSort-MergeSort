import java.util.Random;
public class RandomPivot <T extends Comparable<? super T>> implements Partitionable<T>{



    public int partition(T[] a, int first, int last) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(last-first+1)+first;
        swap(a, pivotIndex, last);
        pivotIndex = last;
        T pivot = a[pivotIndex];

        //Random pivot is assigned


        // determine subarrays Smaller = a[first..endSmaller]
        // and                 Larger  = a[endSmaller+1..last-1]
        // such that elements in Smaller are <= pivot and
        // elements in Larger are >= pivot; initially, these subarrays are empty

        int indexFromLeft = first;
        int indexFromRight = last - 1;
        boolean done = false;
        while (!done)
        {
            // starting at beginning of array, leave elements that are < pivot;
            // locate first element that is >= pivot; you will find one,
            // since last element is >= pivot
            while (a[indexFromLeft].compareTo(pivot) < 0)
                indexFromLeft++;

            // starting at end of array, leave elements that are > pivot;
            // locate first element that is <= pivot; you will find one,
            // since first element is <= pivot
            while (a[indexFromRight].compareTo(pivot) > 0 && indexFromRight > first)
                indexFromRight--;

            assert a[indexFromLeft].compareTo(pivot) >= 0 &&
                    a[indexFromRight].compareTo(pivot) <= 0;

            if (indexFromLeft < indexFromRight)
            {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            }
            else
                done = true;
        } // end while

        // place pivot between Smaller and Larger subarrays
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;

        // Assertion:
        //   Smaller = a[first..pivotIndex-1]
        //   Pivot = a[pivotIndex]
        //   Larger = a[pivotIndex+1..last]

        return pivotIndex;
    }// end partition

//    private void sortFirstMiddleLast(T[] a, int first, int mid, int last)
//    {
//        order(a, first, mid); // make a[first] <= a[mid]
//        order(a, mid, last);  // make a[mid] <= a[last]
//        order(a, first, mid); // make a[first] <= a[mid]
//    } // end sortFirstMiddleLast
//
//    /** Task: Orders two given array elements into ascending order
//     *        so that a[i] <= a[j].
//     *  @param a  an array of Comparable objects
//     *  @param i  an integer >= 0 and < array.length
//     *  @param j  an integer >= 0 and < array.length */
//    private void order(T[] a, int i, int j)
//    {
//        if (a[i].compareTo(a[j]) > 0)
//            swap(a, i, j);
//    } // end order



    private void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // end swap

    public void quickSort(T[] a, int left, int right) {
        int index = partition(a, left, right);
        if (left < index - 1)
            quickSort(a, left, index - 1);
        if (index < right)
            quickSort(a, index, right);
    }
}
