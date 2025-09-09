class Solution {
    public int[] solution(long n) {
        
        int length = 0;
        long l = 1;
        while(n/l!=0){
            length += 1;
            l*=10;
        }
        
        l/=10;
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[length-i-1] = (int)(n/l%10);
            l/=10;
        }
        
            
        return answer;
    }
}