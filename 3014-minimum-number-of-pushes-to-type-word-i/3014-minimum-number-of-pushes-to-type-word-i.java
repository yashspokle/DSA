class Solution {
    public int minimumPushes(String word) {
       int result = 0;
       HashMap<Integer, Integer> hp = new HashMap<>();
       int assign_key = 2;
       for(char ch : word.toCharArray()){
        if(assign_key > 9){
            assign_key = 2; 
        }
       hp.put(assign_key, hp.getOrDefault(assign_key, 0) + 1);
        result += hp.get(assign_key);

        assign_key++;
       }
       return result;
    }
}