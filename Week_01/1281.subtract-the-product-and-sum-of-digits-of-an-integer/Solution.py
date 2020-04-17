class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        s = str(n)
        mul, add = 1, 0
        for b in s:
            mul *= int(b)
            add += int(b)

        return mul - add