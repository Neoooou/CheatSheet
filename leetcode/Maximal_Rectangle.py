class Solution:
    def maximalRectangle(self, matrix: list[list[str]]) -> int:
        max_area = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                max_area = max(max_area, self.calc_area(i, j, matrix))
        return max_area




    def calc_area(self, i, j, matrix):
        if matrix[i][j] == '0':
            return -1
        w, h, ci, cj = 0, 0, i, j
        while i < len(matrix) and matrix[i][j] == '1':
            i += 1
            h += 1
        while j < len(matrix[0]) and matrix[ci][j] == '1':
            j += 1
            w += 1
        dp = list()
        for _ in range(h):
            dp.append([0 for _ in range(w)])
        max_area = 1
        for l in range(h):
            dp[l][0] = l + 1
            max_area = max(dp[l][0], max_area)
        for l in range(w):
            dp[0][l] = l + 1
            max_area = max(dp[0][l], max_area)
        for l in range(1, h):
            for m in range(1, w):
                if dp[l-1][m] != 0 and dp[l][m-1] != 0 and matrix[ci+l][cj+m] == '1':
                    dp[l][m] = (l + 1) * (m + 1)
                    max_area = max(dp[l][m], max_area)
        return max_area
