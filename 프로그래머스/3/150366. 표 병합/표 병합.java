/*
1. UPDATE R C VALUE
    선택된 셀 값 바꾸기
2. UPDATE V1 V2
    모든 셀을 V2로 바꿈
3. MERGE R1 C1 R2 C2
    셀 병합
        둘 중 하나라도 값 가지면 그걸로 가짐
        두개 다 가지면 R1 C1으로 가짐
4. UNMERGE R C
    병합 해제
5. PRINT R C
*/
import java.util.*;
class Solution {
    int[] parent = new int[51*51];
    List<String> result = new ArrayList<>();
    public String[] solution(String[] commands) {
        String[] map = new String[51*51];
        Arrays.fill(map, "");
        
        for(int i = 0; i < 51*51; i++){
            parent[i] = i;
        }
        
        for(String command : commands){
            String[] splits = command.split(" ");
            String cmd = splits[0];
            if(cmd.equals("UPDATE")){
                if(splits.length == 3){
                    String v1 = splits[1];
                    String v2 = splits[2];
                    
                    updateAllCell(map, v1, v2);
                } if(splits.length == 4){
                    int r = Integer.parseInt(splits[1]);
                    int c = Integer.parseInt(splits[2]);
                    String v = splits[3];
                    updateOneCell(map, r, c, v);
                }
            }else if(cmd.equals("MERGE")){
                int r1 = Integer.parseInt(splits[1]);
                int c1 = Integer.parseInt(splits[2]);
                int r2 = Integer.parseInt(splits[3]);
                int c2 = Integer.parseInt(splits[4]);
                mergeCell(map, r1, c1, r2, c2);
            }else if(cmd.equals("UNMERGE")){
                int r = Integer.parseInt(splits[1]);
                int c = Integer.parseInt(splits[2]);
                unmergeCell(map, r, c);
            }else if(cmd.equals("PRINT")){
                int r = Integer.parseInt(splits[1]);
                int c = Integer.parseInt(splits[2]);
                printCell(map, r, c);
            }
        }
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public void updateOneCell(String[] map, int r, int c, String v){
        int pos = r*51+c;
        if(parent[pos] == pos){
            map[pos] = v;
        }else{
            int root = find(pos);
            map[root] = v;
        }
    }
    
    public void updateAllCell(String[] map, String v1, String v2){
        for(int i = 0; i < 51*51; i++){
            if(map[i].equals(v1)){
                map[i] = v2;
            }
        }
    }
    
    public void mergeCell(String[] map, int r1, int c1, int r2, int c2){
        int pos1 = r1*51+c1;
        int pos2 = r2*51+c2;
        
        int root1 = find(pos1);
        int root2 = find(pos2);
        
        String v1 = map[root1];
        String v2 = map[root2];
        
        if(root1 == root2) return;
        parent[root2] = root1;
        
        if(!v1.isEmpty()){
            map[root1] = v1;
        }else{
            map[root1] = v2; 
        }
        map[root2] = "";
    }
    
    public void unmergeCell(String[] map, int r, int c){
        int pos = r*51+c;
        String v = map[find(pos)];
        
        int root = find(pos);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 51*51; i++){
            if(find(i) == root){
                list.add(i);
            }
        }
        
        for(Integer i : list){
            parent[i] = i;
            map[i] = "";
        }
        
        map[pos] = v;
    }
    
    public void printCell(String[] map, int r, int c){
        int pos = r*51+c;
        int p = find(pos);
        String v = map[p];
        if(v.equals("")){
            result.add("EMPTY");
        }else{
            result.add(v);
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        return find(parent[x]);
    }
}