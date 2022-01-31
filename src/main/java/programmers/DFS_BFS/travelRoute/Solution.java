package programmers.DFS_BFS.travelRoute;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    private HashMap<String, ArrayList<String>> flightSchedule;
    private static ArrayList<String[]> ansList;

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length];
        ansList = new ArrayList<String[]>();

        flightSchedule = makeFlightSchedule(flightSchedule, tickets);
        answer[0] = "ICN";
        dfs(1, answer, tickets.length, "ICN");

        return answer;
    }

    private void dfs(int depth, String[] prefix, int N, String nowKey){
        if(depth == N){
            ansList.add(prefix);
            return;
        }

        ArrayList<String> list = flightSchedule.get(nowKey);
        for(int i=0;i<list.size();i++){
            prefix[depth] = list.get(i);
            nowKey = list.get(i);
//            visited[][]
            dfs(depth+1, prefix, N, nowKey);
        }
    }

    private HashMap<String, ArrayList<String>> makeFlightSchedule(HashMap<String, ArrayList<String>> flightSchedule, String[][] tickets){
        flightSchedule = new HashMap<>();
        ArrayList<String> dest;

        for (String[] t:tickets){
            dest = new ArrayList<>();
            if(flightSchedule.containsKey(t[0])){
                dest = flightSchedule.get(t[0]);
                dest.add(t[0]);
            }else{
                dest.add(t[1]);
            }
            flightSchedule.put(t[0],dest);
        }

        return flightSchedule;
    }

    public static void main(String[] args) {
        String[][] input = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] result = new Solution().solution(input);
        for(String s:result)
            System.out.println(s);
    }
}