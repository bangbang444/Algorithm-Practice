class Solution {
    static boolean[] visited;
    static int count;
    static int[] numbersRef;
    static int trg;
        
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        count = 0;
        trg = target;
        numbersRef = numbers;
        
        findTarget(0, 0, numbers.length);
        
        return count;
    }
    
    static public void findTarget(int stage, int sum ,int n){
        if(stage == n){
            if(sum == trg){
                count++;
            }
            return;
        }
        
        if(!visited[stage]){
            visited[stage] = true;
            findTarget(stage+1, sum+numbersRef[stage],n);
            findTarget(stage+1, sum-numbersRef[stage],n);
            visited[stage] = false;
        }
        
    }
}