class Solution:
    def fullJustify(self, words, maxWidth: int):
        res = list()
        ws = list()
        total_ws = 0

        for word in words:
            if (total_ws + len(ws) - 1 + 1 + len(word)) > maxWidth:
                spaces = maxWidth - total_ws
                if len(ws) == 1:
                    line = ws[0] + (maxWidth - len(ws[0])) * ' '
                else:
                    average_spaces = spaces // (len(ws) - 1)
                    line = (average_spaces * ' ').join(ws)
                    extra_spaces = spaces % (len(ws) - 1)
                    if extra_spaces != 0:
                        line = re.sub(' ', '  ', line, count=extra_spaces)
                res.append(line)

                # reset
                ws = list()
                total_ws = 0
            ws.append(word)
            total_ws += len(word)
        last_line = ' '.join(ws)
        last_line += (maxWidth - len(last_line)) * ' '
        res.append(last_line)
        return res

words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
s = Solution()
line0, line1, line2 = s.fullJustify(words, maxWidth)