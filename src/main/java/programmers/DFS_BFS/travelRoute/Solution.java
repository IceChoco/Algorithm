package programmers.DFS_BFS.travelRoute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    private HashMap<String, ArrayList<String>> flightSchedule;
    private HashMap<String, Integer> remainMap;
    private static ArrayList<String> ansList;

    public String[] solution(String[][] tickets) {
        int N = tickets.length;
        ansList = new ArrayList<String>();

        flightSchedule = makeFlightSchedule(flightSchedule, tickets);
        dfs(0, "ICN", N, "ICN");
        Collections.sort(ansList);
        return ansList.get(0).split(" ");
    }

    private void dfs(int depth, String prefix, int N, String nowKey){
        if(depth == N){
            ansList.add(prefix);
            return;
        }

        if(flightSchedule.get(nowKey)==null) return;
        for(String to: flightSchedule.get(nowKey)){
            if(remainMap.get(nowKey+","+to)==0)
                continue;

            remainMap.put(nowKey+","+to, remainMap.get(nowKey+","+to)-1);
            dfs(depth+1, prefix+" "+to, N, to);
            remainMap.put(nowKey+","+to, remainMap.get(nowKey+","+to)+1);
        }
    }

    private HashMap<String, ArrayList<String>> makeFlightSchedule(HashMap<String, ArrayList<String>> flightSchedule, String[][] tickets){
        flightSchedule = new HashMap<>();
        remainMap = new HashMap<>();

        for (String[] t:tickets){
            if(flightSchedule.containsKey(t[0])){
                flightSchedule.get(t[0]).add(t[1]);
            }else{
                flightSchedule.put(t[0],new ArrayList<>(){{add(t[1]);}});
            }
            remainMap.put(t[0]+","+t[1],remainMap.getOrDefault(t[0]+","+t[1],0)+1);
        }
        return flightSchedule;
    }

    private static int getIdx(String nowKey){
        int idx = 0;
        for(int i=0;i<nowKey.length();i++)
            idx += nowKey.charAt(i)-'A'+1;

        return idx;
    }
}