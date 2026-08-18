package com.java.dsa;


import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement
 * Given the head of a singly linked list, reverse the list and return the new head.
 * Example
 * Input:
 * 1 → 2 → 3 → 4 → 5 → null
 * Output:
 * 5 → 4 → 3 → 2 → 1 → null
 */
public class ReverseLinkedList {

    static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Val ::"+val;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        listNode.next = secondNode;
        ListNode thirdNode = new ListNode(3);
        secondNode.next = thirdNode;

        reverseList(listNode);
//        System.out.println("listNode ::"+ reverseList(listNode));
    }

    public static ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }
}
