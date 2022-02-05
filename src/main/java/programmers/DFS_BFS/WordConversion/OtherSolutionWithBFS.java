package programmers.DFS_BFS.WordConversion;

import java.util.LinkedList;
import java.util.Queue;

/* [프로그래머스 다른 사람의 풀이]
 * - Queue를 사용한 BFS 알고리즘
 */
public class OtherSolutionWithBFS {

    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String to = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};//4
//        String[] words = {"hot", "dot", "dog", "lot", "log"};//0
        System.out.println(new OtherSolutionWithBFS().solution(begin, to, words));
    }
}
