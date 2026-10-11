class Solution {
    public int missingMultiple(int[] nums, int k) {
         Arrays.sort(nums);
        for (int i = k; ; i += k) {
            if (Arrays.binarySearch(nums, i) < 0)
                return i;
        }
    }
}