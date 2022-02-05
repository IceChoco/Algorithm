package programmers.DFS_BFS.WordConversion;

public class Solution {
    private int min;
    private static int N;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        N=words.length;
        boolean[] visited = new boolean[N];
        min = 50;

        boolean isTarget = false;
        for(String s:words){
            if(s.equals(target)){
                isTarget = true;
                break;
            }
        }

        if(!isTarget) return 0;

        changeToTarget(begin, target, 0,visited, words);

        return min==50?answer:min;
    }

    private void changeToTarget(String begin, String target, int cnt, boolean[] visited, String[] words){
        if(begin.equals(target)){
            min = Integer.min(min,cnt);
            return;
        }

        for(int i=0;i<words.length;i++){
            String to = words[i];

            if(!almostSame(begin,to) || visited[i])
                continue;

            cnt++;
            visited[i]=true;
            changeToTarget(to, target, cnt, visited, words);
            visited[i]=false;
            cnt--;
        }
    }

    private boolean almostSame(String begin, String to){
        String b, t;
        for(int i=0;i<begin.length();i++){
            b = begin.substring(0,i)+begin.substring(i+1);
            t = to.substring(0,i)+to.substring(i+1);
            if(b.equals(t)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String to = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};//4
//        String[] words = {"hot", "dot", "dog", "lot", "log"};//0
        System.out.println(new Solution().solution(begin, to, words));
    }
}
