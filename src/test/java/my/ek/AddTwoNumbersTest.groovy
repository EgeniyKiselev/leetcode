package my.ek

import spock.lang.Specification

/**
 * Created by ekiselev on 25.09.2016.
 */
class AddTwoNumbersTest extends Specification {
    def "AddTwoNumbers"() {
        given:
        AddTwoNumbers test = new AddTwoNumbers()
        ListNode l1 = new ListNode(9)
        l1.next = new ListNode(9)
        l1.next.next = new ListNode(9)
        ListNode l2 = new ListNode(9)
        l2.next = new ListNode(9)
        l2.next.next = new ListNode(9)
        expect:
        ListNode r = test.addTwoNumbers(l1, l2)
        r.val == 8
        r.next.val == 9
        r.next.next.val == 9
        r.next.next.next.val == 1
    }
}
