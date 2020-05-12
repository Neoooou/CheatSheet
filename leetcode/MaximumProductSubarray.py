class Solution:
    def maxProduct(self, nums) -> int:
        if not nums:
            return 0
        imax, imin, global_max = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            candidates = [imax*nums[i], imin*nums[i], nums[i]]
            imax = max(candidates)
            imin = min(candidates)
            global_max = max(imax, global_max)
        return global_max

input = [2,3,-2,4]
s = Solution()
print(s.maxProduct(input))
            