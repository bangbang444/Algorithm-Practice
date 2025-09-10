class Solution {
    public boolean solution(int x) {
        
        int copyX = x;
        int sum = 0;
        while(copyX > 0){
            sum += copyX%10;
            copyX/=10;
        }
        
        return x%sum==0 ?  true : false;
    }
}