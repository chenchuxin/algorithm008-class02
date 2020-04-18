class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        arr = list(S)
        l, r = 0, len(S) - 1
        while l < r:
            lIsAlphabet = arr[l].isalpha()
            rIsAlphabet = arr[r].isalpha()

            if lIsAlphabet and rIsAlphabet:
                arr[l], arr[r] = arr[r], arr[l]
                l +=1
                r -=1
                continue;

            if not lIsAlphabet:
                l += 1
            if not rIsAlphabet:
                r -= 1

        return "".join(arr)
    