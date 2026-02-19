class Solution {
    public String solution(int[] food) {
        
        for(int i = 0; i < food.length; i++){
            if(food[i]%2 != 0) food[i]-=1;
        }
        
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int amount = food[i];
            while(amount > 0){
                if(amount%2==0){
                    front.append(i);
                }else{
                    back.append(i);
                }
                amount--;
            }
        }
        
        StringBuilder answer = new StringBuilder(front);
        answer.append(0);
        for(int i = back.length()-1; i >= 0; i--){
            answer.append(back.charAt(i));
        }
        
        return answer.toString();
    }
}