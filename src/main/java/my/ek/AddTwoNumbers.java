package my.ek;

/**
 * Created by ekiselev on 25.09.2016.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode prev = res;
        int add = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int r = val1 + val2 + add;
            add = r / 10;
            r %= 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            prev.next = new ListNode(r);
            prev = prev.next;
        }
        if (add != 0) {
            prev.next = new ListNode(add);
        }
        return res.next;
    }
}
