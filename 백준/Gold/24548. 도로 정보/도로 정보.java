import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 도로 주변의 나무: T
* 잔디: G
* 울타리: F
* 사람들을 촬영한 내용: P
*
* 도로 구간: 도로의 연속된 일부분 - 도로의 연속 부분 문자열로 표현
* 흥미로운 구간: 길이가 1 이상인 도로 구간 중 그에 속한 모든 물체의 수가 3의 배수인 것
* 흥미로운 구간이 될 수 있는 도로 구간의 개수 구하기
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 100,000
        String S = br.readLine();


        int[][] accObjects = new int[4][S.length()+1];
        for(int i = 0; i < S.length(); i++){
            char curChar = S.charAt(i);
            if(curChar == 'T'){
                accObjects[0][i+1] = 1;
            }else if(curChar == 'G'){
                accObjects[1][i+1] = 1;
            }else if(curChar == 'F'){
                accObjects[2][i+1] = 1;
            }else if(curChar == 'P'){
                accObjects[3][i+1] = 1;
            }
        }

        // 누적
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= S.length(); j++){
                accObjects[i][j] += accObjects[i][j-1];
            }
        }

        int[] stateCount = new int[81];
        stateCount[0] = 1;

        long answer = 0;

        for(int i = 1; i <= S.length(); i++){
            int t = accObjects[0][i] % 3;
            int g = accObjects[1][i] % 3;
            int f = accObjects[2][i] % 3;
            int p = accObjects[3][i] % 3;

            int curState = (t*27) + (g*9) + (f*3) + (p);
            answer += stateCount[curState];
            stateCount[curState]++;
        }

        System.out.println(answer);
    }
}
