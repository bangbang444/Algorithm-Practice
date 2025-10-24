class Solution {
    public int solution(int n) {
        
        int count = 1;
        
        int start = 1;
        int end = n/2+1;
        
        while(start < end){
            int sum = (start+end)*(end-start+1)/2;
                
            if(sum > n) {
                end--;
            }else if(sum == n){
                count++;
                start++;
                end++;
            }else{
                start++;
                end+=2;
            }
        }
        
        return count;
    }
}