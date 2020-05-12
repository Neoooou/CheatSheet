class Solution:
    def isNumber(self, s: str) -> bool:
        if not s:
            return False
        s = s.strip()
        s = s.split('e')
        if len(s) == 1:
            return self.isNumorDecimal(s[0])
        elif len(s) == 2:
            return self.isNumorDecimal(s[0]) and self.isNum(s[1])
        else:
            return False

    def isNumorDecimal(self, num: str):
        if num.rfind('-') not in (0, -1) or num.rfind('+') not in (0, -1):
            return False
        if num.count('.') > 1 or num.rfind('.') == (len(num) - 1):
            return False
        num = re.sub('[-+.]', '', num)
        return num.isdigit()

    def isNum(self, num:str):
        if not num:
            return False
        if num.rfind('-') not in (0, -1) or num.rfind('+') not in (0, -1):
            return False
        num = re.sub('[-+]', '', num)
        return num.isdigit()


s = Solution()
nums = [' ', '-12', '+12', '1.2', '+ ']
for num in nums:
    print(s.isNum(num))