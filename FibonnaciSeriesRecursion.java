import java.util.Scanner;

public class FibonnaciSeriesRecursion {
    private static long[] fibonnaciCashe;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        fibonnaciCashe = new long[n+1];

        long num = fibonnaci(n);

        for(int i = 0; i <=n; i++)
        {
            System.out.print(" " + fibonnaci(i) + " ");
        }

    }
    public static long fibonnaci(int n)
    {
        if(n<=1)
        {
            return n;
        }
        //this is to use the already calculated data of each fibonnaci location
        if(fibonnaciCashe[n] !=0)
        {
            return fibonnaciCashe[n];
        }
        long nthFibonnaciNum = (fibonnaci(n-1) + fibonnaci(n-2));
        fibonnaciCashe[n] = nthFibonnaciNum;
        return nthFibonnaciNum;

    }
}
