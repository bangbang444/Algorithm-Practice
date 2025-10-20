// 가로 >= 세로
// 노랑은 직사각형이라고 가정
class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        int minDiff = Integer.MAX_VALUE;
        int[] answer = new int[2];
    
        for(int row = 1; row <= yellow; row++){
            int col = yellow/row;
            if(yellow%col != 0) continue;
            
            if((row+2)*(col+2)-yellow == brown && minDiff > Math.abs(row-col)){
                minDiff = Math.abs(row-col);
                answer[0] = col+2;
                answer[1] = row+2;
            }
            
        }
        
        return answer;
    }
}