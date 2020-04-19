class Solution:
    def firstUniqChar(self, s: str) -> str:
        dic = {}
        for c in s:
            if not c in dic:
                dic[c] = True
            elif dic[c]:
                dic[c] = False
        
        for k, v in dic.items():
            if v: return k
        
        return ' '


class Solution:
    def firstUniqChar(self, s: str) -> str:
        arr = [0] * 26
        for c in s:
            if arr[ord(c) - ord('a')] <= 1:
                arr[ord(c) - ord('a')] += 1
        for c in s:
            if arr[ord(c) - ord('a')] == 1: 
                return c;
        return ' ';