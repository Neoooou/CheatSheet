# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        l = 0
        temp = head
        while temp:
            l += 1
            temp = temp.next
        k = k % l
        i = 0
        temp = head
        prev = None
        while temp:
            if k + i == l:
                break
            prev = temp
            temp = temp.next
            i += 1
        prev.next = None
        res = temp
        while temp.next:
            temp = temp.next
        temp.next = head
        return res
i1 = ListNode(1)
i2 = ListNode(2)
i3 = ListNode(3)
i4 = ListNode(4)
i5 = ListNode(5)
i1.next = i2
i2.next = i3
i3.next = i4
i4.next = i5
s = Solution()
s.rotateRight(i1, 2)