package DutchFlagProblem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[] list = {2, 4, 5, 8, 5, 5, 5, 5, 6, 2, 2, 9};
       quickSort(list, 0, list.length-1);
       System.out.println(Arrays.toString(list));
    }
    public static void swap(int[] list, int a, int b)
    {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    public static Pair partition(int[] list, int start, int end)
            //gives the first and last index
    {
        int mid = start;
        int pivot = list[end];
        while(mid<=end)
        {
            if(list[mid] < pivot)
            {
                swap(list, start, mid);
                ++start;
                ++mid;
            }
            else if(list[mid] > pivot)
            {
                swap(list, mid, end);
                --end;
            }
            else
            {
                ++mid;
            }
        }
        return new Pair(start - 1, mid);
    }

    public static void quickSort(int[] list, int start, int end)
    {
        if(start>=end)
        //this is base condition incase number of elements is zero or one
        {
            return;
        }
        Pair pivot = partition(list, start, end);
        //rearranging the elements across the pivot using the dutch national flag algorithm
        quickSort(list, start, pivot.getX());
        //in pair class the X value is the ending value
        //rerun the methods on the subarray containing elements that are less than the pivot
        quickSort(list, pivot.getY(), end);
        //in pair class the Y value is the starting value
        //rerun the methods on the subarray containing elements that are more than the pivot
    }
}
