class Solution {
    public int solution(String[] board) {
        int o = 0; // 선공
        int x = 0; // 후공
        
        for(String line : board){
            for(int i = 0; i < line.length(); i++){
                char info = line.charAt(i);
                if(info == 'O') o++;
                if(info == 'X') x++;
            }
        }
        
        if(o < x){ // x의 범위 o >= x
            return 0;
        }
        
        int winO = 0;
        int winX = 0;
        // 맞음: 이길 때 개수 x=o, o > x
        int[] result1 = checkRow(board);
        int[] result2 = checkCol(board);
        int[] result3 = checkDiag(board);
        
        
        winO += result1[0];
        winO += result2[0];
        winO += result3[0];
        winX += result1[1];
        winX += result2[1];
        winX += result3[1];
        
        //System.out.println(winO + " " + winX + " " + o + " " + x);
        if(winO >= 1 && winX == 0 && o == x+1){
            return 1;
        }else if(winO == 0 && winX >= 1 && x == o){
            return 1;
        }else if((o == x+1 || o == x) && winO == 0 && winX == 0){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int[] checkRow(String[] board){
        int tripleO = 0;
        int tripleX = 0;
        
        for(String line : board){
            char std = line.charAt(0);
            int cnt = 0;
            for(char ch : line.toCharArray()){
                if(ch == std) cnt++;
            }
            
            if(cnt == 3 && std == 'O') tripleO++;
            if(cnt == 3 && std == 'X') tripleX++;
        }
        
        return new int[]{tripleO, tripleX};
    }
    public int[] checkCol(String[] board){
        int tripleO = 0;
        int tripleX = 0;
        
        for(int i = 0; i < board[0].length(); i++){
            char std = board[0].charAt(i);
            int cnt = 0;
            for(int j = 0; j < board.length; j++){
                if(board[j].charAt(i) == std) cnt++;
            }
            
            if(cnt == 3 && std == 'O') tripleO++;
            else if(cnt == 3 && std == 'X') tripleX++;
        }
        
        return new int[]{tripleO, tripleX};
    }
    
    public int[] checkDiag(String[] board){
        int tripleO = 0;
        int tripleX = 0;
        
        char std1 = board[0].charAt(0);
        int cnt1 = 0;
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(i) == std1) cnt1++;
        }
        if(cnt1 == 3 && std1 == 'O') tripleO++;
        if(cnt1 == 3 && std1 == 'X') tripleX++;
        
        char std2 = board[0].charAt(2);
        int cnt2 = 0;
        if(board[0].charAt(2) == std2) cnt2++;
        if(board[1].charAt(1) == std2) cnt2++;
        if(board[2].charAt(0) == std2) cnt2++;
        if(cnt2 == 3 && std2 == 'O') tripleO++;
        if(cnt2 == 3 && std2 == 'X') tripleX++;
        
        return new int[]{tripleO, tripleX};
    }
}