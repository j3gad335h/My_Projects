# There is a function signFunc(x) that returns:
# 1 if x is positive.
# -1 if x is negative.
# 0 if x is equal to 0.
# You are given an integer array nums. Let product be the product of all values in the array nums.
# Return signFunc(product).
# Example 1:
# Input: nums = [-1,-2,-3,-4,3,2,1]
# Output: 1
# Explanation: The product of all values in the array is 144, and signFunc(144) = 1
nums = [1,5,0,2,-3]
n=1
for num in nums:
    n=n*num
if n==0:
   print (0)
elif n>0:
    print(1)
elif n<0:
    print(-1)
