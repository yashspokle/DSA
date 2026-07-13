class Solution {
    public int digitFrequencyScore(int n) {
            int[] freq = new int[10];

        while (n > 0) {
            int digit = n % 10;
            freq[digit]++;
            n /= 10;
        }

        int score = 0;

        for (int i = 0; i <= 9; i++) {
            score += i * freq[i];
        }

        return score;
           }
    }
