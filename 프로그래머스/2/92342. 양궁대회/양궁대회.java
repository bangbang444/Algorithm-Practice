import java.util.*;
class Solution {
    int[] lionInfo = new int[11]; 
    int max = -1;
    int[] answer = null;
    public int[] solution(int n, int[] info) {
        shotArrow(n, info, 0);
        
        if(answer == null) return new int[]{-1};
        int leftCount = n;
        for(int i : answer){
            leftCount-=i;
        }
        answer[10] = leftCount;
        
        return answer;
    }
    
    public void shotArrow(int leftArrow, int[] info, int idx){
        
        if(leftArrow < 0 || idx > 10) return;
        if(idx == 10){
            int aSum = 0;
            int lSum = 0;
            for(int i = 0; i <= 10; i++){
                if(lionInfo[i] > info[i]){
                    lSum += 10-i;
                }else{
                    if(info[i] != 0) aSum += 10-i;
                }
            }

            if(lSum > aSum && max < lSum-aSum){
                max = lSum-aSum;
                answer = Arrays.copyOf(lionInfo, lionInfo.length);
            }
            
            if(lSum > aSum && max == lSum-aSum && answer != null){
                //System.out.println(lSum + " " + aSum);
                for(int i = 10; i >= 0; i--){
                    if(answer[i] < lionInfo[i]){
                        answer = Arrays.copyOf(lionInfo, lionInfo.length);
                        break;
                    }else if(answer[i] > lionInfo[i]){
                        break;
                    }
                }
            }
            
            return;
        }
        
        int aArrow = info[idx];
        shotArrow(leftArrow, info, idx+1);
        
        lionInfo[idx] += aArrow+1;
        shotArrow(leftArrow-(aArrow+1), info, idx+1);
        lionInfo[idx] -= aArrow+1;
        
    }
}