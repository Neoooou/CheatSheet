class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        #import numpy
        l1 = len(word1)
        l2 = len(word2)
        #dp = numpy.zeros((l1+1, l2+1), dtype=numpy.int)
        dp = list()
        for i in range(l1+1):
            dp.append([0 for _ in range(l2+1)])
        for i in range(1, l1+1):
            dp[i][0] = i
        for j in range(1, l2+1):
            dp[0][j] = j
        for i in range(1, l1+1):
            for j in range(1, l2+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j])) + 1
        return dp[l1][l2]

    def setZeroes(self, matrix) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        if not matrix or not matrix[0]:
            return
        l1 = len(matrix)
        l2 = len(matrix[0])
        rows = set()
        cols = set()
        for i in range(l1):
            for j in range(l2):
                if matrix[i][j] == 0:
                    rows.add(i)
                    cols.add(j)
        for r in rows:
            matrix[r] = [0 for _ in range(l2)]
        for c in cols:
            for m in range(l1):
                matrix[m][c] = 0

        print(matrix)

    def searchMatrix(self, matrix, target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        l1 = len(matrix)
        l2 = len(matrix[0])
        i = 0
        while i < l1:
            if matrix[i][0]<=target<=matrix[i][-1]:
                break
            i += 1
        else:
            return False
        l = 0
        r = l2 - 1
        while l < r:
            mid = (l+r) // 2
            if target > matrix[i][mid]:
                l = mid + 1
            elif target < matrix[i][mid]:
                r = mid
            else:
                return True
        return False

    def minWindow(self, s: str, t: str) -> str:
        vocab = dict()
        for c in t:
            vocab.setdefault(c, 0)
            vocab[c] += 1
        start = 0
        end = 0
        count = dict()
        res = ''
        import sys
        min_length = sys.maxsize
        while end < len(s):
            count.setdefault(s[end], 0)
            count[s[end]] += 1
            while self.check(count, vocab):
                if end - start + 1 < min_length:
                    min_length = end - start + 1
                    res = s[start: end+1]
                count[s[start]] -= 1
                if count[s[start]] == 0:
                    del count[s[start]]
                start += 1
            end += 1
        return res

    def check(self, count, vocab):
        for key in vocab.keys():
            if key not in count.keys() or vocab[key] > count[key]:
                return False
        return True

    def combine(self, n: int, k: int):
        # res = [[i+1] for i in range(n)]
        # while k > 1:
        #     l = len(res)
        #     i = 0
        #     while i < l:
        #         temp = res.pop(0)
        #         for j in range(temp[-1]+1, n+1):
        #             res.append(temp + [j])
        #         i += 1
        #     k -= 1
        # print(res)
        res = list()
        def bt(s,ans):
            if len(ans) == k:
                res.append(ans.copy())
                return
            for i in range(s, n+1):
                ans.append(i)
                bt(i+1, ans)
                ans.pop()
        bt(1, [])
        return res








s = Solution()
print(s.minDistance('horse', 'ros'))
l = [0, 2, 1]
print(any([e==0 for e in l]))
matrix = [
    [1]
]
print("word".split())
vocab = {"w":0}
print(vocab.get("c"))
S = "ADOBECODEBANC"
T = "ABC"
print(s.minWindow(S, T))
print(s.combine(20, 16))
