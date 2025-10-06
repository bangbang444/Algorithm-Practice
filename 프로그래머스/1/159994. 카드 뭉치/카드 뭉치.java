class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        int total = 0;
        
        int totalSize = cards1.length + cards2.length;
        
        while(total < goal.length){
            if(idx1 < cards1.length && cards1[idx1].equals(goal[total])){
                idx1++;
            }else if(idx2 < cards2.length && cards2[idx2].equals(goal[total])){
                idx2++;
            }else{
                return "No";
            }
            
            total++;
        }
        
        return "Yes";
        
    }
}