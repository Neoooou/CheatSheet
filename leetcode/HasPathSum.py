# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return 0
        node_sum = {root: root.val}
        while True:
            temp = {}
            for n, v in node_sum.items():
                if n.right:
                    temp[n.right] = v + n.right
                if n.left:
                    temp[n.left] = v + n.left
                if not n.right and not n.left and v == sum:
                    return True
            if not temp:
                break
            else:
                node_sum = temp
        return False