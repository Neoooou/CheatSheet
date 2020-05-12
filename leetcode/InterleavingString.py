class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        dp = [[False for _ in range(len(s2)+1)] for _ in range(len(s1)+1)]
        return False


print(Solution().isInterleave("aabcc",
                              "dbbca",
                              "aadbbcbcac"))