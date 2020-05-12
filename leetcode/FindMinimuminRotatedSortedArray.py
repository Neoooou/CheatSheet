class Solution:
    def findMin(self, nums) -> int:
        '''
        nums: sorted array, no duplicate, rotated at some pivot unknown to you beforehand
        '''
        l, r = 0, len(nums)-1
        while l <= r:
            m = (r+l) // 2
            if nums[m] < nums[r]:
                r = m  # sorted right part, search left part
            else:
                l = m + 1  # sorted left part, search right part
        return nums[m]

    def findMin2(self, nums) -> int:
        '''
        nums: sorted array, no duplicate, rotated at some pivot unknown to you beforehand
        '''
        l, r = 0, len(nums)-1
        while l <= r:
            m = (r+l) // 2
            if nums[m] < nums[r]:
                r = m - 1 if m == r else m  # sorted right part, search left part
            elif nums[m] == nums[r]:
                for i in range(m, r):
                    if nums[i] != nums[i+1]:
                        l = m + 1  # sorted left part, search right part
                        break
                else:
                    r = m - 1 if m == r else m
            else:
                l = m + 1
        return nums[m]

s = Solution()
s.findMin2([2,2,2,0,1])