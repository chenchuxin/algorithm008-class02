class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            Boolean value = map.get(c);
            // 遇到存的是 true 的就不要多 put 一次了
            if (value == null) {
                map.put(c, false);
            } else if (!value) {
                map.put(c, true);
            }
            
            // 这种在遇到 true 的时候会 put，消耗一点性能
            // map.put(c, map.containsKey(c));
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}


class Solution2 {
    public char firstUniqChar(String s) {
        // 题目最好这里用 128，ASCII 是 128，刚好呢看评论，测试用例是小写字母而已，就用 26 了
        int[] arr = new int[26];
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (arr[c - 'a'] <= 1) {
                arr[c - 'a']++;
            }
        }
        for (char c : charArr) {
            if (arr[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}