class Solution {
    public double solution(int[] arr) {
        
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        
        return sum*1.0/arr.length;
    }
}