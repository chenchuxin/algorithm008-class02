class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0;
        while (l != r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}