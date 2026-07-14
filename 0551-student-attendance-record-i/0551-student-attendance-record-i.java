class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;

        for(int j = 0; j< s.length(); j++){
            
            if(s.charAt(j) == 'A'){
                absent++;
            }
             if(absent >= 2){
                return false;   
            } 
        }

        for(int i = 0; i < s.length()-2; i++){
          
            if(s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L'){
                return false;
            }
        }
        return true;
    }
}