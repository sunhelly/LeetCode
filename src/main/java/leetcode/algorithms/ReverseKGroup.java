package leetcode.algorithms;

import java.util.Stack;

public class ReverseKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head;
    }
    ListNode phead = new ListNode(-1);
    phead.next = head;
    Stack<ListNode> nodes = new Stack<ListNode>();
    ListNode q = phead;
    while (head != null && head.next != null) {
      ListNode p = head.next;
      int count = 0;
      while (count < k - 2 && p.next != null) {
        ListNode tmp = p;
        nodes.push(tmp);
        count++;
        p = p.next;
      }
      if (count != k - 2) {
        return phead.next;
      }
      head.next = p.next;
      q.next = p;
      while (!nodes.isEmpty()) {
        p.next = nodes.pop();
        p = p.next;
      }
      p.next = head;
      q = head;
      head = head.next;
    }
    return phead.next;

  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
