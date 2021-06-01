package com.learn.algo.DP;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

// Problem Statement: Find the nth fibonacci number.

final class FibonacciWithDPMemoization
{

    public static final BigInteger fib(int n, Map<Integer, BigInteger> memo)
    {
        if(memo.containsKey(n)) return memo.get(n);
        if(n <= 2) return BigInteger.valueOf(1);

        memo.put(n, fib(n - 2, memo).add(fib(n - 1, memo)));
        return memo.get(n);
    }
}

final class FibonacciWithoutDP {

    public static final BigInteger fib(int n)
    {
        if(n <= 2) return BigInteger.valueOf(1);
        return fib(n - 2).add(fib(n - 1));
    }
}

public class Fibonacci {

    public static void main(String[] args)
    {
        System.out.println(" ****************** Brute Force ********************* ");
        System.out.println(FibonacciWithoutDP.fib(6));
        //System.out.println(FibonacciWithoutDP.fib(50)); // Takes forever to complete if n = 50.

        System.out.println(" ****************** DP With Memoization ********************* ");
        System.out.println(FibonacciWithDPMemoization.fib(6, new HashMap<>()));
        System.out.println(FibonacciWithDPMemoization.fib(50, new HashMap<>()));  // With DP, output is super quick.
    }

}
