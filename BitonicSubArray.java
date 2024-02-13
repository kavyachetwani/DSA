public class BitonicSubArray {
    public static void main(String[] args) {
        int[] list = {2, 4, 8, 16, 12, 4, 3, 8, 7, 9};
        findBitonicSubarray(list);
        int[] newlist = {3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4};
        findBitonicSubarray(newlist);
    }
    public static void findBitonicSubarray(int[] list)
    {
        if(list.length == 0)
        {
            return;
        }
        int[] incr = new int[list.length];
        incr[0] = 1;
        for (int i = 1; i < incr.length; i++)
        {
            incr[i] = 1;
            if(list[i - 1] < list[i])
            {
                incr[i] = incr[i - 1] + 1;
            }
        }

        int[] decr = new int[list.length];
        decr[list.length - 1] = 1;
        for(int i = list.length - 2; i >=0; i--)
        {
            decr[i] = 1;
            if(list[i]>list[i + 1])
            {
                decr[i] = decr[i + 1] + 1;
            }
        }



        int lbsLength = 1;
        int beg = 0;
        int end = 0;
        for(int i = 0; i < list.length; i++)
        {
            int len = incr[i] + decr[i] - 1;
            if(lbsLength < len)
            {
                lbsLength = len;
                beg = i - incr[i] + 1;
                end = i + decr[i] - 1;
            }
        }


        System.out.println("The length of the longest bitonic subarray is " + lbsLength);
        System.out.printf(" the logest bitonic subarray indices are (%d, %d) \n", beg, end);
    }
}
