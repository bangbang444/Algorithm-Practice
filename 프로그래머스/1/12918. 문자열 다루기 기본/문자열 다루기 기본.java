class Solution {
    public boolean solution(String s) {
        
        int size = s.length();
        if(size != 4 && size != 6)
            return false;
        
        for(int i = 0; i < size; i++){
            char ch = s.charAt(i);
            if(ch < 48 || ch > 57){
                return false;
            }
        }
        
        return true;
    }
}