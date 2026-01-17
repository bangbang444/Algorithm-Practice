import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        placeQueen(0);

        System.out.println(count);
    }

    private static void placeQueen(int row){

        if(row >= N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(isPlaceQueen(row, i)){
                board[row][i] = 1;
                placeQueen(row+1);
                board[row][i] = 0;
            }
        }
    }

    private static boolean isPlaceQueen(int x, int y){

        // 세로
        for(int i = x-1; i >= 0; i--){
            if(board[i][y] == 1) return false;
        }
        // 위왼대각
        for(int i = x-1, j = y-1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 1) return false;
        }
        // 위오대각
        for(int i = x-1, j = y+1; i >= 0 && j < N; i--,j++){
            if(board[i][j] == 1) return false;
        }

        return true;
    }
}
