package com.learn.algo.DP;

// Problem Statement : Given a matrix of m * n size, it is to found out as to the number of ways in which
// one can go from top-left corner of the grid to the bottom-right corner.

// Conditions: You can only go right and down. No left and up movement is allowed.

import java.util.HashMap;
import java.util.Map;

final class GridTravellerWithoutDP
{
    /* brute force solution */

    static final long gridTraveller(int m, int n) {

        if(m == 0 || n == 0)
            return 0;

        if(m <= 1 || n <= 1) {
            return 1;
        }

        return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
    }

}

final class GridTravellerWithDPMemoization {

    // Use 'long' since recursion may result in large integer values out of int range.

    static final long gridTraveller(int m, int n, Map<String, Long> memo) {

        String key = m + "," + n;
        if(memo.containsKey(key))
            return memo.get(key);

        // base case #1 of the form (0, 2) or (1,0)
        if(m == 0 || n == 0)
            return 0;

        // base case #1 of the form (1, 2) or (1,1),et al
        if(m <= 1 || n <= 1)
            return 1;

        memo.put(key, gridTraveller(m - 1, n, memo) + gridTraveller(m, n - 1, memo));
        return memo.get(key);
    }

}

public class GridTraveller {

    public static void main(String[] args)
    {
        /* Without DP */
        System.out.println(" ****************** Brute Force ********************* ");
        System.out.println(GridTravellerWithoutDP.gridTraveller(2,3));  // 3 -> Verified
        System.out.println(GridTravellerWithoutDP.gridTraveller(3,3));  // 6 -> Verified
        System.out.println(GridTravellerWithoutDP.gridTraveller(2,4));  // 4 -> Verified
        // System.out.println(GridTravellerWithoutDP.gridTraveller(18,18));  // 2333606220 - Takes forever to return.

        /* With DP Memoization */

        System.out.println(" ****************** With DP Memoization ********************* ");
        System.out.println(GridTravellerWithDPMemoization.gridTraveller(2,3, new HashMap<>()));  // 3 -> Verified
        System.out.println(GridTravellerWithDPMemoization.gridTraveller(3,3, new HashMap<>()));  // 6 -> Verified
        System.out.println(GridTravellerWithDPMemoization.gridTraveller(2,4, new HashMap<>()));  // 4 -> Verified
        System.out.println(GridTravellerWithDPMemoization.gridTraveller(18,18, new HashMap<>())); // 2333606220 -> Verified
    }
}


