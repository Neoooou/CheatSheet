class Solution:
    def restoreIpAddresses(self, s: str):
        res = list()
        def bt(b, va):
            if len(va) > 4 or b > len(s):
                return
            if b == len(s) and len(va) == 4:
                res.append('.'.join(va))
                return
            e = len(s) if b+3 > len(s) else b+3
            for i in range(b, e):
                if 0 < int(s[b:i+1]) < 256:
                    va.append(s[b:i+1])
                    bt(i+1, va)
                    va.pop(-1)
        bt(0, [])
        return res

inp = "1111"
print(Solution().restoreIpAddresses(inp))