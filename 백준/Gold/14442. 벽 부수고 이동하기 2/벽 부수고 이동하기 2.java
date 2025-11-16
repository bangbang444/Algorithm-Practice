import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // Map 생성
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = -1;
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][K+1];

        queue.offer(new State(0,0,1, 0));
        Arrays.fill(visited[0][0], true);
//        for(int i = 0; i < K; i++){
//            visited[0][0][i] = true;
//        }
        while(!queue.isEmpty()){
            State cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            int count = cur.count;
            int crashed = cur.isCrash;
            //System.out.println(curX + " " + curY + " " + count + " " + crashed);

            if(curX == N-1 && curY == M-1){
                answer = count;
                break;
            }

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX >=0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY][crashed]){
                    visited[newX][newY][crashed] = true;
                    if(map[newX][newY] == 0){
                        queue.add(new State(newX, newY, count+1, crashed));
                    }

                    if(map[newX][newY] == 1 && crashed < K){
                        queue.add(new State(newX, newY, count+1, crashed+1));
                    }
                }

            }
        }

        System.out.println(answer);
    }

    static class State{
        int x;
        int y;
        int count;
        int isCrash;
        public State(int x, int y, int count, int isCrash){
            this.x = x;
            this.y = y;
            this.count = count;
            this.isCrash = isCrash;
        }
    }
}
