class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            boolean isLetterL = Character.isLetter(arr[l]);
            boolean isLetterR = Character.isLetter(arr[r]);
            if (isLetterL && isLetterR) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;                
                continue;
            }
            if (!isLetterL) {
                l++;
            }
            if (!isLetterR) {
                r--;
            }
        }
        return String.valueOf(arr);
    }
}