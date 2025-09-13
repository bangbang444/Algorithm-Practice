class Solution {
    public long solution(int price, int money, int count) {
        
        long total = ((long)price*count*(1+count))/2;

        return total > money ? total-money : 0;
    }
}