package programmers.DFS_BFS.Network;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    private static ArrayList<Node> nodeList;
    private static int[] parent;

    class Node{
        int from;
        int to;
        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n+1];

        for(int i=1;i<=n;i++)
            parent[i] = i;

        nodeList = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]>0 && i!=j){
                    nodeList.add(new Node(i+1,j+1));
                }
            }
        }

        makeNetwork();

        HashSet<Integer> group = new HashSet<>();
        for(int i=1;i<=n;i++)
            group.add(getParent(i));

        return group.size();
    }

    private void makeNetwork(){
        for(Node node:nodeList){
            if(!find(node.from,node.to))
                union(node.from,node.to);
        }
    }

    private boolean find(int from, int to){
        int x = getParent(from);
        int y = getParent(to);
        return x==y;
    }

    private void union(int from, int to){
        int x = getParent(from);
        int y = getParent(to);

        if(y>x)
            parent[y] = parent[x];
        else
            parent[x] = parent[y];
    }

    private int getParent(int a){
        if(parent[a] == a)
            return a;
        return parent[a] = getParent(parent[a]);//경로압축
    }

    public static void main(String[] args) {
//        int[][] test = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};//2
//        int[][] test = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};//1
//        int[][] test = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};//1
        int[][] test = {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}};//1

        System.out.println(new Solution().solution(6,test));
    }
}
