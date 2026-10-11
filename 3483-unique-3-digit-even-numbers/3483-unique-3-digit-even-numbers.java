class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> s = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length; j++){
                for(int k = 0; k < digits.length; k++){
                    if(i == j || i == k || j == k) continue;
                    if(digits[i] == 0) continue;
                    int num = (digits[i]*100) + (digits[j]*10) + (digits[k]*1);
                    if(num % 2 == 0){
                        s.add(num);
                    }
                }
            }
        }

        return s.size();
    }
}