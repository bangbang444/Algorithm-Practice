class Solution {
    public int solution(int[] nums) {
        int numsLength = nums.length;
        int count = 0;
        for(int i = 0; i < numsLength; i++){
            for(int j = i+1; j < numsLength; j++){
                for(int k = j+1; k < numsLength; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)){
                        count++;
                    }
                }
            }
        }

        return count++;
    }
    
    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
        
    }
}