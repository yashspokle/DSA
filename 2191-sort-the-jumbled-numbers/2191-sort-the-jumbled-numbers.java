class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            int mappedA = getMappedValue(nums[a], mapping);
            int mappedB = getMappedValue(nums[b], mapping);
            return Integer.compare(mappedA, mappedB);
        });
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[indices[i]];
        }
        return result;
    }
    private int getMappedValue(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        int place = 1;
        int mappedNum = 0;
        while (num > 0) {
            int digit = num % 10;
            mappedNum += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
        return mappedNum;
    }
}