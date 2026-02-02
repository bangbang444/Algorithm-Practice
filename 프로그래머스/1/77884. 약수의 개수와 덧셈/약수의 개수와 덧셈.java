class Solution {
    public int solution(int left, int right) {
        
        int count = 0;
        for(int i = left; i <= right; i++){
            int absValueCnt = howAbsoluteValue(i);
            
            if(isEven(absValueCnt)) count-=i;
            else count+=i;
        }
        
        return count;
    }
    
    public int howAbsoluteValue(int num){
        int count = 0;
        for(int i = 1; i <= num/2; i++){
            if(num%i==0) count++;
        }
        return count;
    }
    
    public boolean isEven(int num){
        return num%2 == 0;
    }
}