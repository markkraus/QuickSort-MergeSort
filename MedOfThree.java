public class MedOfThree <T extends Comparable<? super T>> implements Partitionable<T>, Sorter<T> {

    private <T extends Comparable<? super T>>
    void sortFirstMiddleLast(T[] a, int first, int mid, int last)
    {
        order(a, first, mid); // make a[first] <= a[mid]
        order(a, mid, last);  // make a[mid] <= a[last]
        order(a, first, mid); // make a[first] <= a[mid]
    } // end sortFirstMiddleLast

    private <T extends Comparable<? super T>>
    void order(T[] a, int i, int j)
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

    @Override
    public int partition(T[] a, int first, int last) {
        return 0;
    }

    @Override
    public void sort(T[] a, int size) {

    }

    @Override
    public void setMin(int minSize) {

    }
}
