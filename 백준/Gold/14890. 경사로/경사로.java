import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지도 크기
        int L = Integer.parseInt(st.nextToken()); // 경사로 길이

        // 지도
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // start
        int count = 0;
        // 가로 길 찾기
        for(int i = 0; i < N; i++){
            int std = map[i][0];
            boolean success = true;
            boolean[] visited = new boolean[N];
            for(int j = 1; j < N; j++){
                int diff = std - map[i][j];
                if(diff == 0) continue;

                if(diff == 1){ // 낮아짐
                    int compStd = map[i][j];
                    int compCnt = 0;

                    for(int k = j; k < N; k++){
                        if(compStd == map[i][k]) compCnt++;
                        if(compCnt >= L){
                            for(int l = k; l >= k-L+1; l--) visited[l] = true;

                            std = compStd;
                            break;
                        }
                    }
                    if(compCnt < L) {
                        success = false;
                        break;
                    }
                } else if(diff == -1){ // 높아짐
                    int compStd = map[i][j-1];
                    int compCnt = 0;
                    for(int k = j-1; k >= 0; k--){
                        if(visited[k]) break;
                        if(compStd == map[i][k]) compCnt++;
                        else break;

                        if(compCnt >= L){
                            std = map[i][j];
                            break;
                        }
                    }
                    if(compCnt < L) {
                        success = false;
                        break;
                    }
                }else{
                    success = false;
                    break;
                }
            }
            if(success) {
                count++;
            }
        }

        //System.out.println(count);
        // 세로 길 찾기

        for(int i = 0; i < N; i++){
            int std = map[0][i];
            boolean success = true;
            boolean[] visited = new boolean[N];
            for(int j = 1; j < N; j++){
                int diff = std - map[j][i];
                if(diff == 0) continue;

                if(diff == 1){ // 낮아짐
                    int compStd = map[j][i];
                    int compCnt = 0;

                    for(int k = j; k < N; k++){
                        if(compStd == map[k][i]) compCnt++;
                        if(compCnt >= L){
                            for(int l = k; l >= k-L+1; l--) visited[l] = true;

                            std = compStd;
                            break;
                        }
                    }
                    if(compCnt < L) {
                        success = false;
                        break;
                    }
                } else if(diff == -1){ // 높아짐
                    int compStd = map[j-1][i];
                    int compCnt = 0;
                    for(int k = j-1; k >= 0; k--){
                        if(visited[k]) break;
                        if(compStd == map[k][i]) compCnt++;
                        else break;

                        if(compCnt >= L){
                            std = map[j][i];
                            break;
                        }
                    }

                    if(compCnt < L) {
                        success = false;
                        break;
                    }
                }else{
                    success = false;
                    break;
                }
            }
            if(success) {
                count++;
            }
        }

        System.out.println(count);
    }
}