package com.learn.algo.DP;

import java.util.HashMap;
import java.util.Map;

final class CanSumBruteForce {

    static final boolean canSum(int target, int[] arr)
    {
        if(target == 0)
            return Boolean.TRUE;

        if(target < 0)
            return Boolean.FALSE;

        for (int element: arr)
        {
            if(canSum(target - element, arr)) {
                return Boolean.TRUE;
            }
        }
        return false;
    }
}

final class CanSumWithDPMemoization {

    static final boolean canSum(int target, int[] arr, Map<Integer, Boolean> memo)
    {
        if(memo.containsKey(target))
            return memo.get(target);

        if(target == 0)
            return Boolean.TRUE;

        if(target < 0)
            return Boolean.FALSE;

        for (int element: arr)
        {
            if(canSum(target - element, arr, memo)) {
                memo.put(target, Boolean.TRUE);
                return Boolean.TRUE;
            }
        }
        memo.put(target, Boolean.FALSE);

        return Boolean.FALSE;
    }

}


public class CanSum
{
    public static void main(String[] args)
    {
        /* Without DP */
        System.out.println(" ****************** Brute Force ********************* ");
        System.out.println(CanSumBruteForce.canSum(7, new int[] { 2, 3, 4 }));  //true -> Verified
        System.out.println(CanSumBruteForce.canSum(7, new int[] { 5, 3, 4, 7 })); //true -> Verified
        System.out.println(CanSumBruteForce.canSum(7, new int[] { 2, 4 }));  // false -> Verified
        System.out.println(CanSumBruteForce.canSum(8, new int[] { 2, 3, 5 }));  //true -> Verified
        //System.out.println(CanSumBruteForce.canSum(300, new int[] { 7, 14 }));  //false -> Not Verified. Takes forever to return.

        /* With DP Memoization */
        System.out.println(" ****************** With DP Memoization ********************* ");
        System.out.println(CanSumWithDPMemoization.canSum(7, new int[] { 2, 3, 4 }, new HashMap<>())); //true -> Pass
        System.out.println(CanSumWithDPMemoization.canSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<>())); //true -> Pass
        System.out.println(CanSumWithDPMemoization.canSum(7, new int[] { 2, 4 }, new HashMap<>()));  //false -> Pass
        System.out.println(CanSumWithDPMemoization.canSum(8, new int[] { 2, 3, 5 }, new HashMap<>())); //true -> Pass
        System.out.println(CanSumWithDPMemoization.canSum(300, new int[] { 7, 14 }, new HashMap<>())); //false -> Pass


    }
}
