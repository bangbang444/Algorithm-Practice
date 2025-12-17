import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int R,C;
    static char[][] map;
    static int max = -1;
    static Set<Character> type = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0 ; j < C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        type.add(map[0][0]);
        back(0 ,0, 1);
        System.out.println(max);
    }

    public static void back(int cx, int cy, int count){

        max = Math.max(count, max);

        for(int i = 0; i < 4; i++){
            int newX = cx+dx[i];
            int newY = cy+dy[i];

            if(newX >= 0 && newX < R && newY >= 0 && newY < C){
                char newChar = map[newX][newY];
                if(!type.contains(newChar)){
                    type.add(newChar);
                    back(newX, newY, count+1);
                    type.remove(newChar);
                }
            }

        }
    }
}
