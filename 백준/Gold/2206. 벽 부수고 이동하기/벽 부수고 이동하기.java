import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int i =1 ; i <= N; i++){
            String line = br.readLine();
            for(int j =1; j <= M; j++){
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        // 찾기 시작(BFS)
        isVisited = new boolean[N+1][M+1][2];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1,1,1, false));
        isVisited[1][1][0] = true;
        while (!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x == N && point.y == M){
                System.out.println(point.depth);
                return;
            }

            for(int i = 0; i < 4; i++){
                int newX1 = point.x + dx[i];
                int newY1 = point.y + dy[i];

                // 그냥 가는 경우
                if((newX1 > 0 && newX1 <= N) && (newY1 > 0 && newY1 <= M)){

                    if(map[newX1][newY1] == 0){
                        if(!isVisited[newX1][newY1][point.isClashed ? 1 : 0]){
                            isVisited[newX1][newY1][point.isClashed ? 1 : 0] = true;
                            queue.add(new Point(newX1, newY1, point.depth + 1, point.isClashed));
                        }
                        continue;
                    }

                    if(map[newX1][newY1] == 1 && !point.isClashed){
                        if(!isVisited[newX1][newY1][1]) {
                            isVisited[newX1][newY1][1] = true;
                            queue.add(new Point(newX1, newY1, point.depth + 1, true));
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Point{
        int x;
        int y;
        int depth;
        boolean isClashed;
        public Point(int x, int y, int depth, boolean isClashed){
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isClashed = isClashed;
        }
    }
}