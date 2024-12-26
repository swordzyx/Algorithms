import java.lang.reflect.WildcardType;
import java.util.HashSet;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/*
 * [141] 环形链表
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 使用 HashSet，如果插入的元素在集合中已存在，链表存在环
     * 如果遍历到了链表末尾，则表示没有环
     * 向 HashSet 中插入一个已存在的元素，会返回 false
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean hasCycle3(ListNode head) {
        HashSet<ListNode> nodeList = new HashSet<>();

        while(head != null){
            if(!nodeList.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * - 慢指针每次前进一步，快指针每次前进两步
     * - 快指针为 null 时，表示链表没环
     * - 快指针和慢指针指向同一个节点时，表示链表有环
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode faster = head;
        ListNode slower = head;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;

            if(slower == faster) {
                return true;
            }
        }
        return false;
    }
}

