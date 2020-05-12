class Solution:
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums = [str(i+1) for i in range(n)]
        res = []
        while len(nums) > 0:
            import math
            n = n - 1

            temp = n
            prod = 1
            while temp > 0:
                prod *= temp
                temp -= 1
            idx = math.ceil(float(k)/prod)

            idx = idx - 1 if idx > 0 else 0
            idx = len(nums) - 1 if idx >len(nums)-1 else idx
            k -= prod * idx
            res.append(nums.pop(idx))
        return ''.join(res)

s = Solution()
print(s.getPermutation(3, 5))
import math
print(type(math.ceil(1.9)))