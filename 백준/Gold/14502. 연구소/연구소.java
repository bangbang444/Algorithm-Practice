import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* 주제: 백트래킹
* 연구소
* */
public class Main {

    static int N;
    static int M;

    static int maxSafe = 0;
    static int basicSafe;
    static int basicVirus;
    static ArrayList<Point> virusPos;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1~n 중 m개 고른 수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 연구소
        int value;
        int[][] board = new int[N][M];
        virusPos = new ArrayList<>();
        basicVirus = 0;
        basicSafe = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                value = Integer.parseInt(st.nextToken());
                board[i][j] = value;
                if(value == 0)
                    basicSafe++;
                if(value == 2) {
                    virusPos.add(new Point(i,j));
                    basicVirus++;
                }
            }
        }

        basicSafe -= 3;
        // 벽 설치 - 난 재귀로 함
        installWall(1, board);
        System.out.println(maxSafe);
    }

    private static void spreadingVirus(int[][] boards) {
        Stack<Point> stack = new Stack<>();
        int[][] board = new int[boards.length][];
        for (int i = 0; i < boards.length; i++) {
            board[i] = boards[i].clone(); // 각 행 배열을 복사
        }

        int localVirus = 0;
        for(Point virus : virusPos)
            stack.push(virus);
        // 위 코드 아래 코드 합치면 답이 이상하게 나올까
        while(!stack.isEmpty()){
            Point pos = stack.pop();
            if(pos.x-1 >= 0 && board[pos.x-1][pos.y] == 0){
                stack.push(new Point(pos.x-1, pos.y));
                board[pos.x-1][pos.y] = 2;
                localVirus++;
            }
            if(pos.x+1 < N && board[pos.x+1][pos.y] == 0){
                stack.push(new Point(pos.x+1, pos.y));
                board[pos.x+1][pos.y] = 2;
                localVirus++;
            }
            if(pos.y-1 >= 0 && board[pos.x][pos.y-1] == 0){
                stack.push(new Point(pos.x, pos.y-1));
                board[pos.x][pos.y-1] = 2;
                localVirus++;
            }
            if(pos.y+1 < M && board[pos.x][pos.y+1] == 0){
                stack.push(new Point(pos.x, pos.y+1));
                board[pos.x][pos.y+1] = 2;
                localVirus++;
            }
        }
        if(maxSafe < basicSafe - localVirus) {
            maxSafe = basicSafe - localVirus;
        }
    }

    private static void installWall(int stage, int[][] board) {
        if(stage > 3){
            spreadingVirus(board);
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    installWall(stage+1, board);
                    board[i][j] = 0;
                }
            }
        }
    }

}
