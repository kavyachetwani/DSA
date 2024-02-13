package DutchFlagProblem;

import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args)
        {
            int[] nums = {2, 4, 6, 7, 2, 4, 3, 8, 8, 8};
            quickSort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
        }
        public static Pair sort(int[] nums, int start, int end)
        {
            int mid = start;
            int pivot = nums[end];
            while(mid<=end)
            {
                if(nums[mid] < pivot)
                {
                    swap(nums, start, mid);
                    ++start;
                    ++mid;
                }
                else if(nums[mid]>pivot)
                {
                    swap(nums, mid, end);
                    --end;
                }
                else
                {
                    ++mid;
                }
            }
            return new Pair(start - 1, mid);
        }
        public static void quickSort(int[] nums, int start, int end)
        {
            if(start>=end)
            {
                return;
            }
            else {
                Pair pivot = sort(nums, start, end);
                quickSort(nums, start, pivot.getX());
                quickSort(nums, pivot.getY(), end);
            }
        }
        public static void swap(int[] nums, int a, int b)
        {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

}
