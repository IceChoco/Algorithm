package programmers.Hash.BestAlbum;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> playTimes = new HashMap<>();
        HashMap<String, ArrayList<Album>> playList = new HashMap<String, ArrayList<Album>>();

        for(int i=0;i<plays.length;i++){
            Album nowPlay = new Album(i,plays[i]);
            playTimes.put(genres[i],playTimes.getOrDefault(genres[i],0)+plays[i]);

            if(playList.containsKey(genres[i]))
                playList.get(genres[i]).add(nowPlay);
            else {
                playList.put(genres[i],new ArrayList<>(){{add(nowPlay);}});
            }
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(playTimes.entrySet());
        Collections.sort(list_entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        ArrayList<Integer> answerList = new ArrayList<>();
        for(Map.Entry<String, Integer> e:list_entries){
            for(int i=0;i<2;i++) {
                Collections.sort(playList.get(e.getKey()));
                if (playList.get(e.getKey()).size() > i)
                    answerList.add(playList.get(e.getKey()).get(i).getIdx());
            }
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }

    class Album implements Comparable<Album>{
        int idx;
        int playtime;

        public Album(int idx, int playtime) {
            this.idx = idx;
            this.playtime = playtime;
        }

        public int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(Album o) {
            return o.playtime - this.playtime;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = new Solution().solution(genres,plays);
        for(int r:result)
            System.out.print(r+" ");
    }
}
