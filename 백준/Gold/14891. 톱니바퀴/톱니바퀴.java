import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] wheels = new char[4][8];
        for(int i = 0; i < 4; i++){
            wheels[i] = br.readLine().toCharArray();
        }

        int K = Integer.parseInt(br.readLine()); // K
        List<int[]> turn = new ArrayList<>();
        for(int i = 0; i < K; i++){
            String[] split = br.readLine().split(" ");
            int target = Integer.parseInt(split[0]);
            int dir = Integer.parseInt(split[1]);
            turn.add(new int[]{target, dir});
        }

        int[] pos = new int[4];
        Arrays.fill(pos, 0);

        int wheelSize = 8;
        for(int[] info : turn){
            int target = info[0]-1; // 톱니번호
            int dir = info[1]; // 1 or -1

            // 왼쪽
            char std = wheels[target][(pos[target]+wheelSize-2)%wheelSize]; // N or S
            int stdDir = dir; // 1 or -1
            int left = target-1; // 비교할 톱니 번호
            while(left >= 0){
                if(wheels[left][(pos[left]+2)%wheelSize] == std){
                    break;
                }
                std = wheels[left][(pos[left]+wheelSize-2)%wheelSize];
                pos[left] = stdDir == 1 ? (pos[left]+1)%wheelSize : (pos[left]+wheelSize -1)%wheelSize;
                stdDir = stdDir == 1 ? -1 : 1;
                left--;
            }

            // 오른쪽
            std = wheels[target][(pos[target]+2)%wheelSize];
            stdDir = dir;
            int right = target+1;
            while(right < 4){
                if(wheels[right][(pos[right]+wheelSize-2)%wheelSize] == std){
                    break;
                }

                std = wheels[right][(pos[right]+2)%wheelSize];
                pos[right] = stdDir == 1 ? (pos[right]+1)%wheelSize : (pos[right]+wheelSize -1)%wheelSize;
                stdDir = stdDir == 1 ? -1 : 1;
                right++;
            }

            // 기준점 회전
            if(dir == 1){
                pos[target] = (pos[target] + wheelSize - 1) % wheelSize;
            }else{
                pos[target] = (pos[target] + 1) % wheelSize;
            }
        }

        int score = 0;
        for(int i = 0; i < 4; i++){
            if(wheels[i][pos[i]] != '0'){
                score += (int)Math.pow(2, i);
            }
        }

        System.out.println(score);
    }
}
