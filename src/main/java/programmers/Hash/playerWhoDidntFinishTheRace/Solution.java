package programmers.Hash.playerWhoDidntFinishTheRace;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> players = new HashMap<>();

        for(String p:participant)
            players.put(p, players.getOrDefault(p,0)+1);

        for(String c:completion){
            if(players.get(c)==1)
                players.remove(c);
            else
                players.put(c,players.get(c)-1);
        }

        return players.keySet().iterator().next();
    }

    public static void main(String[] args) {
        String[] a = {"leo", "kiki", "eden"}; //"leo"
        String[] b = {"eden", "kiki"};

//        String[] a = {"mislav", "stanko", "mislav", "ana"}; //"mislav"
//        String[] b = {"stanko", "ana", "mislav"};
        System.out.println(new Solution().solution(a,b));
    }
}
