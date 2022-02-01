package programmers.DFS_BFS.travelRoute;

import java.util.*;

/* [유의해야할 점]
 * 1. visited 배열을 만들 때 공간을 많이 잡아먹으면 타임아웃이 남.
 *  -> 처음에는 한 글자는 영어 대문자만 올 수 있고, 최대 3자리까지 올 수 있다고 되어있다고 해서
 *     26*3 = 78이 올 수 있으므로 78*79의 정수형 이차원 배열을 생성하여 check했음.
 *     그런데 이 방법은 공간을 많이 잡아먹어서 그런지 타임아웃이 남
 *
 * 2. visited int형 이차원 배열 -> 잔여 티켓을 관리하는 remainMap이라는 HashMap을 생성함
 *  -> 이렇게 바꾸면 티켓의 수 만큼만 Hashmap의 원소가 생성되기 떄문에 공간낭비를 줄일 수 있음. 따라서 시간이 더 빠름.
 *
 * => 앞으로 HashMap 자료구조의 방문체크가 필요할 때, Hashmap을 하나 더 만들어서 방문여부를 관리하자!
 */

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

    public static void main(String[] args) {
        String[][] input = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] input1 = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
//        String[][] input2 = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
//        String[][] input3 = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
//        String[][] input4 ={{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
//        String[][] input5 = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}};
//        String[][] input6 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] input7 = {{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}};
//        String[][] input8 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
//        String[][] input9 = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}, {"A" , "C"}};
//        String[][] input10 = {{"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}};

        ArrayList<String[]> num = new ArrayList<>();

        num.add(new Solution().solution(input));
//        num.add(new Solution().solution(input1));
//        num.add(new Solution().solution(input2));
//        num.add(new Solution().solution(input3));
//        num.add(new Solution().solution(input4));
//        num.add(new Solution().solution(input5));
//        num.add(new Solution().solution(input6));
//        num.add(new Solution().solution(input7));
//        num.add(new Solution().solution(input8));
//        num.add(new Solution().solution(input9));
//        num.add(new Solution().solution(input10));

        for(String[] result:num){
            for (String s:result)
                System.out.print(s+" ");
            System.out.println();
        }
    }
}