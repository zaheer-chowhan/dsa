package com.java.dsa.linkedlist;

/**
 *Remove Duplicates from Sorted Linked List
 * Given the head of a sorted singly linked list,
 * delete all duplicate values so that each value appears only once.
 * Example
 * Input:
 * 1 → 1 → 2 → 3 → 3 → null
 * Output:
 * 1 → 2 → 3 → null
 */
public class RemoveDuplicatesFromLinkedList {

    static class ListNode {
        ListNode next;

        int val;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode secondNode = new ListNode(1);
        listNode.next = secondNode;
        ListNode thirdNode = new ListNode(2);
        secondNode.next = thirdNode;
        ListNode fourthNode = new ListNode(2);
        thirdNode.next = fourthNode;
        ListNode fifthNode = new ListNode(4);
        fourthNode.next = fifthNode;

        printList(listNode);
        deleteDuplicates(listNode);
        printList(listNode);


    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
