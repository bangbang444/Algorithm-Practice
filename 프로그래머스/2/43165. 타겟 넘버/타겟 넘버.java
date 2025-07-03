class Solution {    
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        findTarget(numbers, target, 0, 0);
        return answer;
    }
    
    public void findTarget(int[] numbers, int target, int sum, int stage){
        if(stage == numbers.length){
            if(sum == target)
                answer++;
            return;
        }
        
        findTarget(numbers, target, sum+numbers[stage], stage+1);
        findTarget(numbers, target, sum-numbers[stage], stage+1);
    }
    
    
}