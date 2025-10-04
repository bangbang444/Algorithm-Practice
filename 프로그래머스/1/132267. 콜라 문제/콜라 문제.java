class Solution {
    /*
        a: 콜라를 받기 위해 마트가 주어야 하는 병 수 2 
        b: 빈 병 a개를 주면 마트가 주는 콜라 병 수 1
        n: 상빈이가 가진 빈 병 개수 20
    */
    public int solution(int a, int b, int n) {
        int curBottle = n;
        int needBottle = a;
        int giveBottle = b;
        
        int total = 0;
        int restCola = 0;
        while(curBottle >= a){
            int newBottle = (curBottle/a)*b;
            restCola = curBottle%a;
            
            curBottle = newBottle + restCola;
            total += newBottle;
        }
        
        return total;
    }
}