import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList1_3(head);
    }

    //current 从 head 开始
    public ListNode reverseList(ListNode head) {
        //输入：head = [1,2,3,4,5]
        //输出：[5,4,3,2,1]
        if(head == null) {
            return null;
        }

        ListNode temp;
        ListNode cur = head;

        while (head.next != null) {
            temp = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = temp;
        }
        return cur;
    }

    //current 从 head.next 开始
    public ListNode reverseList1_1(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        head.next = null;

        return pre;
    }

}


