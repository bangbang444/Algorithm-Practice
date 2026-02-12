import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 오목판 입력
        for(int i = 0; i < 19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean find = false;
        int count;
        int[] result = new int[3];
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(board[i][j] == 0) continue;

                // 아래 확인
                count = check1(i, j);
                if(isCount5(i, j, count) != null
                        && !(i-1 >= 0 && board[i][j] == board[i-1][j])) {
                    find = true;
                    result[0] = board[i][j]; result[1] = i; result[2] = j;
                    break;
                }

                // 아래 오른쪽 확인
                count = check2(i, j);
                if(isCount5(i, j, count) != null
                && !(i-1 >= 0 && j-1 >= 0 && board[i][j] == board[i-1][j-1])) {
                    find = true;
                    result[0] = board[i][j]; result[1] = i; result[2] = j;
                    break;
                }
                // 오른쪽 확인
                count = check3(i, j);
                if(isCount5(i, j, count) != null
                        && !(j-1 >= 0 && board[i][j] == board[i][j-1])) {
                    find = true;
                    result[0] = board[i][j]; result[1] = i; result[2] = j;
                    break;
                }
                // 오른쪽 위 확인
                count = check4(i, j);
                if(isCount5(i, j, count) != null
                && !(i+1 < 19 && j-1 >= 0 && board[i][j] == board[i+1][j-1])) {

                    find = true;
                    result[0] = board[i][j]; result[1] = i; result[2] = j;
                    break;
                }
            }
            if(find) break;
        }

        System.out.println(result[0]);
        if(result[0] != 0){
            System.out.println((result[1]+1) + " " + (result[2]+1));
        }
    }

    private static int check1(int i, int j) {
        int dx = 1;
        int count = 1;
        int std = board[i][j];
        while(i +dx < 19 && board[i +dx][j] == std){
            count++;
            dx++;
        }
        return count;
    }

    private static int check2(int i, int j) {
        int dx = 1;
        int dy = 1;
        int count = 1;
        int std = board[i][j];
         while(i + dx < 19 && j + dy < 19
                && board[i + dx][j + dy] == std){
            count++;
            dx++;
            dy++;
        }
        return count;
    }

    private static int check3(int i, int j) {
        int dy = 1;
        int count = 1;
        int std = board[i][j];
        while(j + dy < 19
                && board[i][j + dy] == std){
            count++;
            dy++;
        }
        return count;
    }

    private static int check4(int i, int j) {
        int dx = 1;
        int dy = 1;
        int count = 1;
        int std = board[i][j];
        while(i - dx >= 0 && j + dy < 19
                && board[i - dx][j + dy] == std){
            count++;
            dx++;
            dy++;
        }

        return count;
    }

    private static int[] isCount5(int x, int y, int count){
        if(count == 5){
            return new int[]{board[x][y], x, y};
        }
        return null;
    }
}
