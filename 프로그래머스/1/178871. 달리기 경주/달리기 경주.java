import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rankList = new HashMap<>();
        int rank = 0;
        for(String player : players){
            rankList.put(player, rank++);
        }
        
        for(String calling: callings){
            int curRank = rankList.get(calling); // 호출받은 사람 등수(인덱스)
            int frontRank = curRank-1; // 앞사람
            rankList.computeIfPresent(calling, (k,v) -> v-1);
            rankList.computeIfPresent(players[frontRank], (k,v) -> v+1);
            
            String temp = players[frontRank];
            players[frontRank] = calling;
            players[curRank] = temp;
        }
        
        return players;
    }
}