class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            int number = arr1[i]|arr2[i];
            // 이진수 변환 후 1은 "#" 0은 " "으로 채우기
            answer[i] = makeBinary(n, number);
        }
        return answer;
    }
    
    private String makeBinary(int n, int number){
        StringBuilder binary = new StringBuilder();
        for(int i = 0; i < n; i++){
            int a = number/2;
            int remain = number%2;
            if(remain == 1) binary.insert(0, "#");
            else binary.insert(0, " ");
            number/=2;
        }        
        
        return binary.toString();
    }
}