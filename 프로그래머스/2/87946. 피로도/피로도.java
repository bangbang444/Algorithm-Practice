class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        explore(k, dungeons, visited, 0);
        
        return max;
    }
    
    public void explore(int k, int[][] dungeons, boolean[] visited, int clearCount){
        max = Math.max(clearCount, max);
        if(k <= 0){
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            int[] info = dungeons[i];
            int require = info[0];
            int use = info[1];
            
            if(!visited[i] && k >= require){
                visited[i] = true;
                explore(k - use, dungeons, visited, clearCount+1);
                visited[i] = false;
            }
        }
        
    }
}