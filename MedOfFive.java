public class MedOfFive <T extends Comparable<? super T>> implements Partitionable<T>{


    public int partition(T[] a, int first, int last) {

        // Pointers for first, mid, last, and middle number between first to mid, and mid to last...
        //used to help in finding the Median of Five
        int mid = (first + last) / 2;
        int fmid = (first + mid) / 2;
        int lmid = (mid + last) / 2;

        //Retrieves the median value of five values from the list
        //a[first], a[mid], a[last], middle number between a[first]-a[mid],
        //middle number between a[mid]-a[last]
        sortFive(a, first, fmid, mid, lmid, last);

        //Puts the median number in the second last position. Picks that as the pivot
        swap(a, mid, last - 1);
        int pivotIndex = last - 1;
        T pivot = a[pivotIndex];

        //Pointers on both ends of the list to sort
        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;

        boolean done = false;
        while (!done)
        {
            // starting at beginning of array, leave elements that are < pivot;
            // locate first element that is >= pivot
            while (a[indexFromLeft].compareTo(pivot) < 0)
                indexFromLeft++;

            // starting at end of array, leave elements that are > pivot;
            // locate first element that is <= pivot

            while (a[indexFromRight].compareTo(pivot) > 0 && indexFromRight > first)
                indexFromRight--;

            // Assertion: a[indexFromLeft] >= pivot and
            //            a[indexFromRight] <= pivot.

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
        // Smaller = a[first..pivotIndex-1]
        // Pivot = a[pivotIndex]
        // Larger  = a[pivotIndex + 1..last]

        return pivotIndex;
    }

    private void sortFive(T[] a, int first, int fmid, int mid, int lmid, int last)
    {
        order(a, first, fmid);
        order(a, first, mid);
        order(a, first, lmid);
        order(a, first, last); //a[first] is first
        order(a, fmid, mid);
        order(a, fmid, lmid);
        order(a, fmid, last); //a[fmid] is second
        order(a, mid, lmid);
        order(a, mid, last); //a[mid] is third
        order(a, lmid, last); //a[lmid] is fourth and a[last] is fifth
    } // end sortFirstMiddleLast

    /** Task: Orders two given array elements into ascending order
     *        so that a[i] <= a[j].
     *  @param a  an array of Comparable objects
     *  @param i  an integer >= 0 and < array.length
     *  @param j  an integer >= 0 and < array.length */
    private void order(T[] a, int i, int j)
    {
        if (a[i].compareTo(a[j]) > 0)
            swap(a, i, j);
    } // end order

    private void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // end swap


}
