class Solution:
    def evalRPN(self, tokens) -> int:

        rpn = ('+', '-', '*', '/')
        i = 0
        while i < len(tokens):
            token = tokens[i]
            if token in rpn:
                n1 = tokens.pop(i-1)
                n2 = tokens.pop(i-2)
                i -= 2
                tokens[i] = str(int(eval(n2+token+n1)))
            i += 1
        return int(tokens[-1])

t = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
s = Solution()
print(s.evalRPN(t))
e