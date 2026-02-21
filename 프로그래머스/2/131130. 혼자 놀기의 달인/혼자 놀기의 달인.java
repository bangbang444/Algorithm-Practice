import java.util.*;
class Solution {
    int[] seq;
    int[] colors;
    int color = 0;
    int num = 1;
    List<Integer> eList = new ArrayList<>();
    public int solution(int[] cards) {
        // 사이클 그룹들 중 원소 개수 곱의 최대치 구하기
        seq = new int[cards.length+1];
        colors = new int[cards.length+1];
        findCycle(cards);
        Collections.sort(eList);
        
        return eList.size() == 1 ? 0 : eList.get(eList.size()-1) * eList.get(eList.size()-2) ;
    }
    
    private void findCycle(int[] cards){
        
        for(int i = 1; i <= cards.length; i++){
            int cur = i;
            if(colors[cur] != 0){
                continue;
            }
            color+=1;
            
            while(colors[cur] == 0){
                colors[cur] = color;
                seq[cur] = num++; 
                int next = cards[cur-1]; // 인덱스 맞춤
                if(colors[next] != 0 && colors[next] == colors[cur]){
                    eList.add(seq[cur]-seq[next]+1);
                    break;
                }
                
                cur = next;
            }
        }
    }
}