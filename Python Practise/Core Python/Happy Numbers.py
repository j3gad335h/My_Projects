#Happy Numbers

class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 1 :
            return True
        if n < 6:
            return False
       
        sumx = 0
        for i in str(n):
            sumx = sumx + int(i)*int(i)
        
        return self.isHappy(sumx)
    
x=Solution()
print(x.isHappy(55))