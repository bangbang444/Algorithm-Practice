class Solution {
    public int solution(int[] nums) {
        int length = nums.length;
        int count = 0;
        for(int i = 0; i < length; i++){
            for(int j = i+1; j < length; j++){
                for(int k = j+1; k < length; k++){
                    if(isPrime(nums[i] + nums[j] + nums[k])){
                        count++;
                    }
                }
            }
        }

        return count;
    }
    
    private boolean isPrime(int num){
        if(num <=1 ) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}