import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 테이블 입력
        char[][] table = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                table[i][j] = s.charAt(j);
            }
        }

        // 같은 색으로 얼마나 많이 행 or 열로 있는가 확인
        int maxCount = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 좌우 교체
                if(j+1 < N){
                    // 교체
                    char temp = table[i][j];
                    table[i][j] = table[i][j+1];
                    table[i][j+1] = temp;

                    // 탐색
                    for(int k = 0; k < N; k++){
                        int count  = 1;
                        for(int l = 0; l < N-1; l++){
                            if(table[k][l] == table[k][l+1]){
                                count++;
                            }else{
                                count = 1;
                            }
                            maxCount = Math.max(maxCount, count);
                        }
                    }

                    for(int k = 0; k < N; k++){
                        int count  = 1;
                        for(int l = 0; l < N-1; l++){
                            if(table[l][k] == table[l+1][k]){
                                count++;
                            }else{
                                count = 1;
                            }
                            maxCount = Math.max(maxCount, count);
                        }
                    }
                    // 복구
                    temp = table[i][j];
                    table[i][j] = table[i][j+1];
                    table[i][j+1] = temp;
                }

                // 상하 교체
                if(i + 1 < N){
                    // 교체
                   char temp = table[i][j];
                   table[i][j] = table[i+1][j];
                   table[i+1][j] = temp;

                    // 탐색
                    for(int k = 0; k < N; k++){
                        int count  = 1;
                        for(int l = 0; l < N-1; l++){
                            if(table[k][l] == table[k][l+1]){
                                count++;
                            }else{
                                count = 1;
                            }
                            maxCount = Math.max(maxCount, count);
                        }
                    }

                    for(int k = 0; k < N; k++){
                        int count  = 1;
                        for(int l = 0; l < N-1; l++){
                            if(table[l][k] == table[l+1][k]){
                                count++;
                            }else{
                                count = 1;
                            }
                            maxCount = Math.max(maxCount, count);
                        }
                    }
                    // 복구
                    temp = table[i][j];
                    table[i][j] = table[i+1][j];
                    table[i+1][j] = temp;
                }
            }
        }
        System.out.println(maxCount);
    }
}
