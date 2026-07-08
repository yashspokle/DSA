class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int i = 1;
        int sum = 0;
        
        while(n > 0){
            int r = n % 10;
            if(r != 0){
                x = (r * i) + x;
                sum = sum + r;
                i = i * 10;
            }
            n = n / 10;

        }
        return (long) x * sum;
    }
}