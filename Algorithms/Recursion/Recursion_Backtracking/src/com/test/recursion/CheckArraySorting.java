package com.test.recursion;

/* Ascending order sort check */
// Time complexity: O(n)
// Space Complexity: O(n) -> recursive stack space
public class CheckArraySorting
{
    public static void main(String[] args)
    {
        int ar[] = {1, 5, 7, 8, 10, 12, 12, 16, 18, 20};

        System.out.println(checkIfArraySorted(ar, ar.length));
    }

    private static boolean checkIfArraySorted(int[] ar, int n)
    {
        if(n == 0 || n == 1)
        {
            return true;
        }
        return ar[n - 1] >= ar[n - 2] && checkIfArraySorted(ar, n - 1);
    }
}
