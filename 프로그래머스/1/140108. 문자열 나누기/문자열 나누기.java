class Solution {
    public int solution(String s) {
        char init = '0';
        int x = 0;
        int y = 0;
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(init == '0'){
                init = s.charAt(i);
                x++;
                continue;
            }
            
            if(init == s.charAt(i)) x++;
            else y++;
            
            if(x == y){
                answer++;
                init = '0';
                x = 0;
                y = 0;
            }
        }
        return x == 0 && y == 0 ? answer : answer+1;
    }
}