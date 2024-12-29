/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoLists2(l1, l2);
    }



    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //哨兵节点
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return newHead.next;
    }
}
// @lc code=end

