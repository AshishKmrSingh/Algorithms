package com.test.backtracking;

public class NBitStrings
{
    private static int[] A = new int[3];

    public static void main(String[] args)
    {
        printNBitStrings(3);
    }

    private static void printNBitStrings(int n)
    {
        if(n < 1)
        {
            System.out.println(A);
        }
        else
        {
            A[n - 1] = 0;
            printNBitStrings(n - 1);

            A[n - 1] = 1;
            printNBitStrings(n - 1);
        }
    }
}
