class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int seq = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == ' ') {
                answer.append(' ');
                seq = 0;
                continue;
            }

            if(seq%2==0) answer.append(Character.toUpperCase(ch));
            else answer.append(Character.toLowerCase(ch));
            seq++;
        }
        
        return answer.toString();
    }
}