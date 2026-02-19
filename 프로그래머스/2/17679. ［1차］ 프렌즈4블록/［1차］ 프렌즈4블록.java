/*
    2<= n,m <= 30
    지워지는 블록 개수 찾기
*/
import java.util.*;
class Solution {
    int row, col;
    public int solution(int m, int n, String[] board) {
        row = board.length;
        col = board[0].length();
        // 2차원 배열로 만들기
        char[][] map = new char[row][col];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        // 블럭 지우기 // 내리기 // 지울거 없을 때까지 반복    
        return distroyBlock(map);
    }
    
    private int distroyBlock(char[][] map){
        boolean hasDistroy = true;
        int total = 0;
        while(hasDistroy){
            Set<List<Integer>> distroyList = new HashSet<>();
            // 제거할 블럭들 모으기
            for(int i = 0; i < row-1; i++){
                for(int j = 0; j < col-1; j++){
                    char self = map[i][j];
                    char selfR = map[i][j+1];
                    char selfD = map[i+1][j];
                    char selfC = map[i+1][j+1];
                    if(self != 'x' && self == selfR && selfR == selfD && selfD == selfC){
                        distroyList.add(new ArrayList<>(Arrays.asList(i, j)));
                        distroyList.add(new ArrayList<>(Arrays.asList(i, j+1)));
                        distroyList.add(new ArrayList<>(Arrays.asList(i+1, j)));
                        distroyList.add(new ArrayList<>(Arrays.asList(i+1, j+1)));
                    }
                }
            }
            
            if(distroyList.isEmpty()) {
                hasDistroy = false;
                break;
            }

            // 제거하기
            for(List<Integer> list : distroyList){
                int x = list.get(0);
                int y = list.get(1);
                map[x][y] = 'x';
            }
            
            total += distroyList.size();

            // 내리기
            for(int i = 0; i < col; i++){
                boolean hasMove = false;
                while(!hasMove){
                    int sIdx = row-1;
                    while(sIdx >= 0 && map[sIdx][i] != 'x') sIdx--;
                    int cIdx = sIdx-1;
                    while(cIdx >= 0 && map[cIdx][i] == 'x') cIdx--;
                    if(cIdx >= 0){
                        char temp = map[sIdx][i];
                        map[sIdx][i] = map[cIdx][i];
                        map[cIdx][i] = temp;
                    }else{
                        hasMove = true;
                    }
                }
            }
        }
        return total;
    }
}