import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C,T;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행 ~50
        C = Integer.parseInt(st.nextToken()); // 열 ~50
        T = Integer.parseInt(st.nextToken()); // 초
        // T초가 지난 뒤 미세먼지 양 구하기
        // 위는 바람이 반시계, 아래는 시계 방향 => 미세먼지는 바람 방향대로 한칸씩 이동 / 공기청정기로 들어가면 정화된다.
        // 확산은 동시에, 양은 A/5 (소수점 버림), 공기청정기or벽에는 확산 안 됨
        // map 입력
        List<int[]> carPos = new ArrayList<>();

        map = new int[R][C];
        Queue<Dust> queue = new LinkedList<>();
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C ; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if(num == -1){
                    carPos.add(new int[]{i, j});
                }
                if(num != -1 && num != 0){
                    queue.offer(new Dust(i, j, 0));
                }
            }
        }

        int sec = 0;
        while(sec < T){
            // 1. 미세먼지 확산
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Dust cur = queue.poll();
                int curX = cur.x;
                int curY = cur.y;

                int spread = map[curX][curY]/5;
                if(spread == 0) continue;
                int range = 0;
                if(curX-1 >= 0 && map[curX-1][curY] != -1) {
                    queue.offer(new Dust(curX - 1, curY, spread));
                    range++;
                }
                if(curX+1 < R && map[curX+1][curY] != -1) {
                    queue.offer(new Dust(curX + 1, curY, spread));
                    range++;
                }
                if(curY-1 >=0 && map[curX][curY-1] != -1) {
                    queue.offer(new Dust(curX, curY - 1, spread));
                    range++;
                }
                if(curY+1 < C && map[curX][curY+1] != -1) {
                    queue.offer(new Dust(curX, curY + 1, spread));
                    range++;
                }

                if(map[curX][curY] != -1)
                    queue.offer(new Dust(curX, curY, -spread*range));
            }
            // 반영
            int size2 = queue.size();
            for(int i = 0; i < size2; i++){
                Dust cur = queue.poll();
                map[cur.x][cur.y] += cur.change;
            }

            // 2. 공기 청정기 작동
            // 2-1 윗 순환
            int[] up = carPos.get(0);
            for(int i = up[0], j = up[1]; i > 0; i--){ // 위
                int next = map[i-1][j];
                if(map[i][j] != -1){ // 공기청정기에 들어가는 경우
                    map[i][j] = next;
                }
            }
            for(int i = 0, j = 0; j < C-1; j++){ // 오른쪽
                map[i][j] = map[i][j+1];
            }
            for(int i = 0, j = C-1; i < up[0]; i++){ // 아래
                map[i][j] = map[i+1][j];
            }
            for(int i = up[0], j = C-1; j > 0; j--){ // 왼쪽
                if(map[i][j-1] != -1) {
                    map[i][j] = map[i][j - 1];
                }
            }
            map[up[0]][up[1]+1] = 0;
            // 2-2 아랫 순환
            int[] down = carPos.get(1);
            for(int i = down[0], j = down[1]; i < R-1; i++){ // 아래
                int next = map[i+1][j];
                if(map[i][j] != -1){ // 공기청정기에 들어가지 않는 경우
                    map[i][j] = next;
                }
            }
            for(int i = R-1, j = 0; j < C-1; j++){
                map[i][j] = map[i][j+1];
            }
            for(int i = R-1, j = C-1; i > down[0]; i--){
                map[i][j] = map[i-1][j];
            }
            for(int i = down[0], j = C-1; j > 0; j--){
                map[i][j] = map[i][j-1];
            }
            map[down[0]][down[1]+1] = 0;

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] > 0) queue.offer(new Dust(i, j, 0));
                }
            }

            sec++;
        }

        int leftDust = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int v = map[i][j];
                if(v > 0)
                    leftDust += v;
            }
        }

        System.out.println(leftDust);
    }

    static class Dust{
        int x;
        int y;
        int change;
        public Dust(int x, int y, int change){
            this.x = x;
            this.y = y;
            this.change = change;
        }
    }
}