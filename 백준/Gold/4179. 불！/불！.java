import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        int[] initPos = new int[2];
        Queue<int []> fires = new LinkedList<>();

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                char input = line.charAt(j);
                map[i][j] = input;
                if(input == 'J') initPos = new int[]{i, j};
                if(input == 'F') fires.add(new int []{i, j});
            }
        }

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{initPos[0], initPos[1], 0});

        int stage = 0;
        int answer = -1;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            if(cur[2] >= stage){
                // 불 퍼뜨리기
                fires = spreadFire(fires);
                stage++;
            }

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX >= 0 && newX < R && newY >= 0 && newY < C){
                    if(map[newX][newY] == '.') {
                        map[newX][newY] = 'J';
                        queue.offer(new int[]{newX, newY, cur[2]+1});
                    }
                }else{
                    answer = cur[2]+1;
                    break;
                }
            }

            if(answer != -1) break;
        }

        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
    }

    public static Queue<int []> spreadFire(Queue<int []> fires){

        Queue<int []> newFires = new LinkedList<>();
        while(!fires.isEmpty()){
            int[] cur = fires.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX >= 0 && newX < R && newY >=0 && newY < C
                    && (map[newX][newY] == '.' || map[newX][newY] == 'J')){
                    map[newX][newY] = 'F';
                    newFires.offer(new int[]{newX, newY});
                }
            }
        }

        return newFires;
    }
}
