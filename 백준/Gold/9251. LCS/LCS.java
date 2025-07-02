import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string1 = br.readLine();
        String string2 = br.readLine();

        int length1 = string1.length() + 1;
        int length2 = string2.length() + 1;

        // 첫째 행과 열은 0으로 초기화
        int[][] lcsTable = new int[length2][length1];
        for(int i = 0; i < length1; i++){
            lcsTable[0][i] = 0;
        }
        for(int i = 0; i < length2; i++){
            lcsTable[i][0] = 0;
        }

        for(int i = 1; i < string2.length()+1; i++){
            for(int j = 1; j < string1.length()+1; j++){
                //System.out.println(string1.charAt(j-1) + " " + string2.charAt(i-1));
                if(string1.charAt(j-1) == string2.charAt(i-1)){
                    lcsTable[i][j] = lcsTable[i-1][j-1] + 1;
                    continue;
                }
                lcsTable[i][j] = Math.max(lcsTable[i][j-1], lcsTable[i-1][j]);
            }
        }

        System.out.println(lcsTable[string2.length()][string1.length()]);



    }
}
