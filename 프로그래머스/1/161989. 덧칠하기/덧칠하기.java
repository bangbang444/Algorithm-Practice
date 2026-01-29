class Solution {
    public int solution(int n, int m, int[] section) {
        
        int start = -1;
        int end = -1;
        int count = 0;
        for(int s : section){    
            if(s <= end){
                continue;
            }else{
                start = s;
                end = s+m-1;
                count++;
            }
        }
        
        
        return count;
    }
}