import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 <= N <= 100
        N = Integer.parseInt(br.readLine());
        
        // Map 생성
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String line =  br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j);
            }
        }
        
        // 적록색약이 아닌 경우 - 빨-초 파
        int green = 0;
        int red = 0;
        int blue = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    findArea(i, j);
                    if(map[i][j] == 'R') red++;
                    else if(map[i][j] == 'B') blue++;
                    else if(map[i][j] == 'G') green++;
                }
            }
        }
        System.out.print(red+blue+green);
        System.out.print(" ");
        // 적록색약인 경우 - 빨 초 파
        int redGreen = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'R' || map[i][j] == 'G') {
                    findArea2(i, j);
                    redGreen++;
                }
            }
        }
        System.out.println(blue + redGreen);
        
        
    }

    private static void findArea2(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(map[nx][ny] == 'R' || map[nx][ny] == 'G'){
                        map[nx][ny] = '-';
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }

    private static void findArea(int startX, int startY) {

        char stdColor =  map[startX][startY];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!visited[nx][ny] && map[nx][ny] == stdColor){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
