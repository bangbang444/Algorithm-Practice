class Solution {
    boolean solution(String s) {
        
        int p = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(a == 'p' || a == 'P') p++;
            if(a == 'y' || a == 'Y') y++;
        }

        return p == y ? true : false;
    }
}