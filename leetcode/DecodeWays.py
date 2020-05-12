class Solution:
    def numDecodings(self, s: str) -> int:
        # count = 0
        # def bt(b):
        #     if b >= len(s):
        #         nonlocal count
        #         count += 1
        #         return
        #     if 0 < int(s[b: b+1]) < 27:
        #         bt(b+1)
        #     if b+1 < len(s) and 0<int(s[b:b+2]) < 27:
        #         bt(b+2)
        # bt(0)
        # return count
        temp, prev, w = 0, 1, 1
        i = 0
        while i < len(s):
            t0 = 0
            t1 = 0
            if i > 0:
                temp = prev
                prev = w
                if 9 < int(s[i-1: i+1]) < 27:
                    t0 += 1
            if 0 < int(s[i]) < 10:
                t1 += 1
            w = w*t1 + temp*t0
            i += 1
        return w

s = '2262'
print(Solution().numDecodings(s))