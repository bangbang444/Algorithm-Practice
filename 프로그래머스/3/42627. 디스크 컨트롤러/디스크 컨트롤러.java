import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int count = 0;
        int time = 0;
        int total = 0;
        int index = 0;
        while(count < jobs.length){
            
            while(index < jobs.length && jobs[index][0] <= time){
                pq.add(new int[]{jobs[index][0], jobs[index][1]});
                index++;
            }
            
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                
                time += job[1];
                total += time - job[0];
                count++;
            }else{
                time = jobs[index][0];
            }
        }
        
        return total/jobs.length;
    }
}