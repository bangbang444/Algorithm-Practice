import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] alphaUse = new boolean[27];
    static int cnt = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 단어 개수, 1<= N <= 50
        K = Integer.parseInt(st.nextToken()); // 배울 수 있는 알파벳 수, K >= 0
        if(K < 5){
            System.out.println(0);
            return;
        }
        // antic 고정 단어
        alphaUse['a'-'a'] = true; // 0
        alphaUse['n'-'a'] = true; // 14
        alphaUse['t'-'a'] = true; // 20
        alphaUse['i'-'a'] = true; // 9
        alphaUse['c'-'a'] = true; // 2

        // 단어 입력
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }

        // 새 문자열 확인은 인덱스 4부터 N-5까지
        checkIsRead(words, 5, 0);
        System.out.println(max);
    }

    private static void checkIsRead(String[] words, int use, int start){
        if(use >= K){
            int localCnt = 0;
            for(String word : words){
                boolean pass = true;
                for(char ch  : word.substring(4, word.length()-4).toCharArray()){
                    if(!alphaUse[ch-'a']){
                        pass=false;
                        break;
                    }
                }
                if(pass) localCnt++;
            }
            max = Math.max(localCnt, max);
            return;
        }

        for(int i = start; i < 26; i++){
            if(!alphaUse[i]){
                alphaUse[i] = true;
                checkIsRead(words, use+1, i+1);
                alphaUse[i] = false;
            }
        }
    }
}
