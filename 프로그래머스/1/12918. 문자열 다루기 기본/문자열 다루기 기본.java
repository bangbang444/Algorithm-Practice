class Solution {
    public boolean solution(String s) {
        
        int size = s.length();
        
        for(int i = 0; i < size; i++){
            char ch = s.charAt(i);
            if(ch < 48 || ch > 57){
                return false;
            }
        }
        
        if(size == 4 || size == 6)
            return true;
        else 
            return false;
    }
}