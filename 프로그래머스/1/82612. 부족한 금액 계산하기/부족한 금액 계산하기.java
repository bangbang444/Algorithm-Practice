class Solution {
    public long solution(int price, int money, int count) {
        return Math.max(((long)price*count*(1+count))/2-money, 0);
    }
}