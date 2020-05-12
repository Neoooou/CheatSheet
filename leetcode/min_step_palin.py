from pprint import pprint
class Solution:
    def minCut(self, s: str) -> int:
        queue = [s]
        num = 0
        while queue:
            c = queue.pop(0)
            i, j = self.max_palin_idxs(c)
            if i > 0:
                queue.append(c[:i])
            if j+1 < len(c):
                queue.append(c[j+1:])
            num += 1
        return num

    def max_palin_idxs(self, s):
        dp = list()
        for _ in range(len(s)):
            dp.append([False for _ in range(len(s))])
        res = (-1, -1)
        max_len = float('-inf')
        for j in range(len(s)):
            for i in range(j+1):
                if j == i:
                    dp[i][j] = True
                elif j == i+1:
                    dp[i][j] = s[i] == s[j]
                else:
                    dp[i][j] = s[i] == s[j] and dp[i+1][j-1]
                if dp[i][j] and abs(i-j) > max_len:
                    max_len = abs(i-j)
                    res = (i, j)
        return res


r = Solution().minCut('abcdc')
print(r)
