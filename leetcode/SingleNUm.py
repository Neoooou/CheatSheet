class Solution:
    def singleNumber(self, nums):
        seenOnce = 0
        seenTwice = 0
        for num in nums:
            # Exor of seenOnce and num provided seenTwice is 0*
            seenOnce = (seenOnce ^ num) & ~seenTwice
            # Exor of seenTwice and num provided seenOnce is 0*
            seenTwice = (seenTwice ^ num) & ~seenOnce
            print(seenOnce, seenTwice)
        return seenOnce

    def swap(self, a, b):
        print(a, b)
        a = a - b
        b = a + b
        a = b - a
        print(a, b)


nums = [2, 1, 3, 1, 2, 1, 3, 3, 2, 8]
s = Solution()
print(s.singleNumber(nums))
print("{0:b}".format(-1))
print(bin(-2))