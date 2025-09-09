class Solution {
    public int[] solution(long n) {
        
        String str = "" + n;
        int[] answer = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            answer[str.length()-1-i] = str.charAt(i)-48;
        }
        
            
        return answer;
    }
}