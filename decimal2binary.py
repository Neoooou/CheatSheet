# complemental code within the range of int(32bits)
def decimal2binary(n):
    str_bin = ''
    abs_n = abs(n)
    while abs_n > 1:
        str_bin += str(abs_n % 2)
        abs_n = abs_n // 2
    str_bin += str(abs_n)
    str_bin = str_bin[::-1]
    # pad zeros on the left
    str_bin = "0" * (32 - len(str_bin)) + str_bin
    if n > -1:
        return str_bin
    else:
        # rotate zero to one and one to zero
        str1 = ''.join(['1' if w == '0' else '0' for w in str_bin])
        # mimic binary addition operation
        idx = str1.rfind('0')
        str1 = str1[:idx] + '1'
        str1 = str1 + (32 - len(str1)) * '0'
        return str1


print(decimal2binary(-3))