import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            queue1.offer(A[i]);
        }
        for(int i = 0; i < B.length; i++){
            queue2.offer(B[i]);
        }
        
        // 1 3 5 7
        // 2 2 6 8
        int count = 0;
        while(!queue2.isEmpty()){
            int curA = queue1.peek();
            int curB = queue2.poll();
            if(curA < curB){
                count++;
                queue1.poll();
            }
        }
        
        return count;
    }
}