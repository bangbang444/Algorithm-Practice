class Solution {
    public String solution(String new_id) {
        
        // 1단계
        String s = new_id.toLowerCase();
        // 2단계
        StringBuilder refined1 = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(('A' <= ch && ch <= 'Z') ||
              ('a' <= ch && ch <= 'z') ||
              Character.isDigit(ch) ||
              ch == '-' || ch == '_' || ch == '.'){
                refined1.append(ch);
            }
        }
        // 3단계
        StringBuilder refined2 = new StringBuilder();
        int idx = 0;
        while(idx < refined1.length()){
            if(refined1.charAt(idx) == '.'){
                while( idx < refined1.length() && refined1.charAt(idx) == '.') idx++;
                refined2.append('.');
            }else{
                refined2.append(refined1.charAt(idx));
                idx++;
            }
        }
        System.out.println(refined2);     
        // 4단계
        if(refined2.length() != 0 &&
           refined2.charAt(refined2.length()-1) == '.'){
            refined2.deleteCharAt(refined2.length()-1);
        }
        if(refined2.length() != 0 &&
             refined2.charAt(0) == '.'){
            refined2.deleteCharAt(0);
        }
        
        // 5단계
        if(refined2.length() == 0){
            refined2.append('a');
        }
        // 6단계
        if(refined2.length() >= 16){
            refined2.setLength(15);
        }
        if(refined2.charAt(refined2.length()-1) == '.'){
            refined2.deleteCharAt(refined2.length()-1);
        }
        if(refined2.charAt(0) == '.'){
            refined2.deleteCharAt(0);
        }
        // 7단계
        if(refined2.length() <= 2){
            char ch = refined2.charAt(refined2.length()-1);
            for(int i = refined2.length(); refined2.length() < 3; i++){
                refined2.append(ch);
            }
        
        }
        //System.out.println(refined2);
        return refined2.toString();
    }
}
