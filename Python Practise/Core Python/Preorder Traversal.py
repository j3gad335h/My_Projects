root = [1,'',3,2,4,'',5,6]
x=[]
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node', ans: list = None) :
        if not root: return ans
        if ans == None: ans = []
        ans.append(root.val)
        for child in root.children:
            self.preorder(child, ans)
        return ans