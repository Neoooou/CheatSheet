# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        small, large = ListNode(-1), ListNode(-1)
        sp, lp = small, large
        cur = head.next
        while cur:
            if cur.val < head.val:
                sp.next = cur
                sp = sp.next
            else:
                lp.next = cur
                lp = lp.next
            cur = cur.next
        sp.next = None
        lp.next = None
        sp = self.sortList(small.next)
        lp = self.sortList(large.next)
        cur = sp
        if cur:
            while cur.next:
                cur = cur.next
            cur.next = head
            head.next = lp
            return sp
        else:
            head.next = lp
            return head

    def sortList(self, head: ListNode) -> ListNode:
        n = self.getLen(head)
        dummy = ListNode(-1)
        dummy.next = head
        i = 1
        while i <= n:
            pre = dummy
            cur = dummy.next
            while cur:
                left = cur
                right = self.split(left, i)
                cur = self.split(right, i)
                pre = self.merge(left, right, pre)
            i *= 2
        return dummy.next

    def split(self, node, step):
        if not node:
            return None
        i = 1
        while i < step and node.next:
            i += 1
            node = node.next
        newNode = node.next
        node.next = None
        return newNode

    def merge(self, left, right, pre):
        cur = pre
        while left and right:
            if left.val < right.val:
                cur.next = left
                left = left.next
            else:
                cur.next = right
                right = right.next
            cur = cur.next
        cur.next = left if left else right
        while cur.next:
            cur = cur.next
        return cur

    def getLen(self, node):
        n = 0
        while node:
            node = node.next
            n += 1
        return n


if __name__ == "__main__":
    head = ListNode(4)
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    head.next = n2
    n2.next = n1
    n1.next = n3
    s = Solution()
    s.sortList(head)
