package com.leetcode.examples;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

 */

public class AddTwoNumbers
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int carry = 0;

        ListNode curr = null;
        ListNode head = null;

        int first = 0, second = 0;

        while(true)
        {
            if(l1 == null && l2 == null)
            {
                if(carry != 0)
                {
                    ListNode tmp = new ListNode();
                    tmp.val = carry;
                    tmp.next = null;
                    curr.next = tmp;
                }
                return head;
            }

            if(l1 == null)
            {
                first = 0;
            }
            else
            {
                first = l1.val;
                l1 = l1.next;
            }
            if(l2 == null)
            {
                second = 0;
            }
            else
            {
                second = l2.val;
                l2 = l2.next;
            }
            int sum = first + second + carry;

            if(sum >= 10)
            {
                carry = 1;
                sum = sum - 10;
            }
            else
            {
                carry = 0;
            }


            if(curr == null)
            {
                curr = new ListNode();
                curr.val = sum;
                curr.next = null;
                head = curr;
            }
            else
            {
                ListNode tmp = new ListNode();
                tmp.val = sum;
                tmp.next = null;
                curr.next = tmp;
                curr = tmp;
            }
        }
    }

    /*
     * Definition for singly-linked list.
     */
    private static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

