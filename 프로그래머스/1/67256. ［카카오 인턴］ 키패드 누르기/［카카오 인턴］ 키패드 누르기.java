class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 1, 4, 7
        int left=10;
        // 3, 6, 9
        int right=12;
        
        StringBuilder result = new StringBuilder();
        
        for(int number : numbers) {
            if(number == 0) number = 11;
            
            if(number == 1 || number == 4 || number == 7){
                result.append("L");
                left = number;
                continue;
            }
            if(number == 3 || number == 6 || number == 9){
                result.append("R");
                right = number;
                continue;
            }
            
            // 중앙인 경우
            // 거리 따져서 가까운 곳으로 누르기
            int row = (number-1)/3;
            int col = (number-1)%3;
            
            int lRow = (left-1)/3;
            int lCol = (left-1)%3;
            
            int rRow = (right-1)/3;
            int rCol = (right-1)%3;
            
            int lDis = Math.abs(row-lRow) + Math.abs(col-lCol);
            int rDis = Math.abs(row-rRow) + Math.abs(col-rCol);
            
            if(lDis < rDis) {
                result.append("L");
                left = number;
            }else if(lDis > rDis) {
                result.append("R");
                right = number;
            }else {
                if(hand.equals("left")){
                    result.append("L");
                    left = number;
                    
                }else{
                    result.append("R");
                    right = number;
                }
            }
            
            
        }
        
        
        return result.toString();
    }
}