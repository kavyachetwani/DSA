package BitonicSubsequence;

public class BitonicSubSequence {
    public static void main(String[] args) {
        int[] list = {4, 2, 5, 9, 7, 6, 10, 3, 1};
        System.out.println("The longest bitonic subarray is " + calculateLBS(list));
    }
    public static int calculateLBS(int[] list)
    {
        int n = list.length;
        if(n == 0)
        {
            return -1;
        }
        int[] incr = new int[n];
        int[] decre = new int[n];

        incr[0] = 1;
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j< i; j++)
            {
                if(list[j] < list[i]  &&  incr[j] > incr[i])
                //the incr[j] is to check the previous consecutive count which if is greater than incr[i] then the value of index j is put into index i
                {
                    incr[i] = incr[j];
                }
            }
            incr[i] ++;
        }

        decre[n-1] = 1;
        for(int i = n-2; i >=0; i--)
        {
            for(int j = n-1; j >i; j--)
            {
                if(list[i] > list[j]  && decre[j] > decre[i])
                //the decre[j] is to check the previous count to see if we have a continuous subsequence and if we do that value at index j is put into index i
                {
                    decre[i] = decre[j];
                }
            }
            decre[i]++;
        }


        int lbs = 1;
        for(int i = 0; i < n; i++)
        {
            lbs = Integer.max(lbs, incr[i] +decre[i] - 1);
        }
        return lbs;
    }
}
