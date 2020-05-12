class Solution:
    def grayCode(self, n: int):
        exists = [0]
        def bt(exists):
            if len(exists) == pow(2, n):
                return True
            for num in self.next(exists[-1], n, exists):
                exists.append(num)
                bt(exists)
                if len(exists) != pow(2, n):
                    exists.pop()
        bt(exists)
        return exists



    def next(self, x, n, exists):
        bina = bin(x)[2:]
        bina = '0' * (n-len(bina)) + bina
        poss_nums = list()
        i = 0
        while i < n:
            a = '0' if bina[i] == '1' else '1'
            b = bina[:i] + a + bina[i+1:]
            num = int(b, 2)
            if num not in exists:
                poss_nums.append(num)
            i += 1
        return poss_nums

s = Solution()
print(s.grayCode(2))