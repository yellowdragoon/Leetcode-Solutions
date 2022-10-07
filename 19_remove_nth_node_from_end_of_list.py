'''
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Solution:
We keep a lookahead pointer n ahead of currentNode, as well as a prev node pointer.
When the lookahead pointer goes out of bounds, we know that we are in right position.
Then rearrange nodes.
'''

from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:

        prev = None
        currentPointer = head
        lookAhead = head

        for i in range(n):
            lookAhead = lookAhead.next

        while True:
            if not lookAhead:
                if not prev:
                    second = head.next
                    head.next = None
                    return second

                prev.next = currentPointer.next
                currentPointer.next = None
                break

            prev = currentPointer
            currentPointer = currentPointer.next
            lookAhead = lookAhead.next

        return head

        
