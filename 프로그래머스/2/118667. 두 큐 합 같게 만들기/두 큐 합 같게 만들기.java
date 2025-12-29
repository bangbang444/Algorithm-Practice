import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long totalSum = sum1+sum2;
        if(totalSum%2 != 0) return -1;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i : queue1) q1.offer(i);
        for(int i : queue2) q2.offer(i);
        int count = 0;
        boolean find = false;
        while(count < (queue1.length + queue2.length)*2){
            if(q1.isEmpty()) {
                q1.offer(q2.poll());
                count++;
                continue;
            }
            if(q2.isEmpty()){
                q2.offer(q1.poll());
                count++;
                continue;
            }
            
            
            if(sum1 < sum2){
                int n = q2.poll();
                q1.offer(n);
                sum1 += n;
                sum2 -= n;
            }else if(sum1 > sum2){
                int n = q1.poll();
                q2.offer(n);
                sum1 -= n;
                sum2 += n;
            }else{
                find = true;
                break;
            }

            count++;
        }
        
        
        return !find ? -1 : count;
    }
}