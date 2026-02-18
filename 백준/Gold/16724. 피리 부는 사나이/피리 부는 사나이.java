import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[][] colors;
    static int color = 0;
    static Map<Character, int []> dirs;
    static int N,M;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dirs = new HashMap<>();
        dirs.put('D', new int[]{1, 0});
        dirs.put('U', new int[]{-1, 0});
        dirs.put('L', new int[]{0, -1});
        dirs.put('R', new int[]{0, 1});

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j);
            }
        }

        colors = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(colors[i][j] != 0) continue;
                color++;
                findSafe(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void findSafe(int sx, int sy){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sx, sy});
        colors[sx][sy] = color;

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int curX = cur[0];
            int curY = cur[1];

            int[] dir = dirs.get(map[curX][curY]);
            int nextX = curX + dir[0];
            int nextY = curY + dir[1];
            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M){
                int nextColor = colors[nextX][nextY];
                if(nextColor == 0){
                    colors[nextX][nextY] = color;
                    stack.push(new int[]{nextX, nextY});
                }else if(nextColor == color){  // 사이클
                    answer++;
                    break;
                }
            }
        }
        return;
    }
}
