package com.test.recursion;

public class TowersOfHanoi
{
    public static void main(String[] args)
    {
        calTowersOfHanoi(4, 1, 2, 3);
    }

    private static void calTowersOfHanoi(int n, int fromPeg, int toPeg, int auxPeg)
    {
        if(n == 1)
        {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }
        calTowersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);

        System.out.println("Move disk " + n + " from peg " + fromPeg + " to peg " + toPeg);

        calTowersOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
    }
}
