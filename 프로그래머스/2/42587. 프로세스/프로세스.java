import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        List<Integer> priorList = new ArrayList<>();
        Queue<Process> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            int priority = priorities[i];
            queue.add(new Process(priority, i));
            priorList.add(priority);
        }
        priorList.sort(Comparator.reverseOrder());
        
        int answer = -1;
        int seq = 0;
        while(true){
            Process curProcess = queue.poll();
            int priority = curProcess.getPriority();
            int idx = curProcess.getIdx();
            
            if(priorList.get(0) == priority){
                priorList.remove(0);
                seq++;
                if(idx == location){
                    answer = seq;
                    break;
                }
                continue;
            }
            queue.add(curProcess);
        }
        
        return answer;
    }
    
    class Process{
        int priority;
        int idx;
        public Process(int priority, int idx){
            this.priority = priority;
            this.idx = idx;
        }
        public int getIdx(){
            return idx;
        }
        
        public int getPriority(){
            return priority;
        }
    }
}