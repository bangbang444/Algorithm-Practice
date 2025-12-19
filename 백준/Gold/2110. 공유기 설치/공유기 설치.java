import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int C;
    static ArrayList<Integer> coordinates;

    static boolean[] isSelected;

    static ArrayList<Integer> small;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  5 3
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N];
        coordinates = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int coordinate = Integer.parseInt(st.nextToken());
            coordinates.add(coordinate);
        }
        // 1 2 4 8 9
        Collections.sort(coordinates);

        // 거리
        int first = 1; // 1
        int last = coordinates.get(coordinates.size()-1) - coordinates.get(0); // 9

        int answer = 1;
        while(first <= last){
            int mid = (first + last) / 2; // 찾는 거리
            if(check(mid)){
                answer = mid;
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int distance) {

        int count = 1; // 공유기
        int start = coordinates.get(0);

        for(int i = 1; i < N; i++){
            if(coordinates.get(i) - start >= distance){
                count++;
                start = coordinates.get(i);
            }
        }

        return count >= C;
    }

}