class Solution {
    public long solution(int a, int b) {
        
        long big = Math.max(a,b);
        long small = Math.min(a,b);
        long answer = 0;

        if(big > 0 && small > 0){
            return ((big-small+1) * (big+small)) / 2;
        }
        
        if(big < 0){
            return ((big-small+1) * (big+small)) / 2;
        }
        
        long sum = big+small;
        long first = big - sum + 1;
        return ((big-first+1) * (big+first)) / 2;
        
    }
}