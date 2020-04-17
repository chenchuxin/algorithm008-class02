'''
双指针，因为原来的数组有序，那么平方的在负数部分是降序，非负数部分是升序，用双指针遍历合并即可。
优点：时间复杂度 O(n)
缺点：空间复杂度 O(n)
'''
class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        n, p = 0, len(A) - 1
        arr = [0] * len(A)
        i = len(A) - 1
        while i >= 0:
            if abs(A[n]) >= abs(A[p]):
                arr[i] = A[n] * A[n]
                n += 1
            else:
                arr[i] = A[p] * A[p]
                p -= 1
            i -= 1
        return arr;

'''
直接遍历平方，再排序
优点：空间复杂度 O(1)，代码可读性高
缺点：时间复杂度 O(nlogn)
'''
class Solution2:
    def sortedSquares(self, A: List[int]) -> List[int]:
        for i in range(len(A)):
            A[i] *= A[i]
        return sorted(A)



'''
总体来说，两个方案各有优率，算法界应该喜欢第一种，但是在工程代码中我更偏向于第二种
'''