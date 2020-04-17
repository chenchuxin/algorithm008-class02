class Solution {
    public int[] sortedSquares(int[] A) {
        int n = 0, p = A.length - 1, i = p;
        int[] arr = new int[A.length];
        while (i >= 0) {
            if (Math.abs(A[n]) >= Math.abs(A[p])) {
                arr[i--] = A[n] * A[n];
                n ++;
            } else {
                arr[i--] = A[p] * A[p];
                p --;
            }
        }
        return arr;
    }
}


class Solution2 {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}