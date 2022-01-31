package programmers.FullSearch.Carpet;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int idx = 0;

        ArrayList<Carpet> carpets = getDivisors(brown+yellow);

        if (carpets.size()>1){
            for(int i=0;i<carpets.size();i++){
                Carpet a = carpets.get(i);
                if(a.w*2 + (a.h-2)*2 == brown){
                    idx = i;
                    break;
                }
            }
        }

        int[] answer = {carpets.get(idx).w, carpets.get(idx).h};

        return answer;
    }

    private ArrayList<Carpet> getDivisors(int n){
        ArrayList<Carpet> list = new ArrayList<>();

        int i=3;
        while(i*i<=n){
            if(n%i==0)
                list.add(new Carpet(n/i, i));
            i++;
        }

        return list;
    }

    class Carpet{
        int w;
        int h;

        public Carpet(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}