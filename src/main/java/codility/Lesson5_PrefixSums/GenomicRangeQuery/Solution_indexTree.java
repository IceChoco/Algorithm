package codility.Lesson5_PrefixSums.GenomicRangeQuery;

import java.io.*;

public class Solution_indexTree {
    private static int[] ans, tree;
    public int[] solution(String S, int[] P, int[] Q){
        int N = S.length();
        ans = new int[P.length];
        tree = new int[N*4];
        int impFac;

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == 'A') impFac = 1;
            else if(S.charAt(i) == 'C') impFac = 2;
            else if(S.charAt(i) == 'G') impFac = 3;
            else impFac = 4;
            update(1, 1, N, i+1, impFac);
        }

        for(int i=0;i<P.length;i++){
            ans[i] = query(1,1,N,P[i]+1,Q[i]+1);
        }

        return ans;
    }

    private void update(int index, int left, int right, int target, int value){
        //범위를 벗어난 경우
        if(target < left || target > right) return;
        //도착한 경우
        if(target == left && target == right){
            tree[index] = value; return;
        }
        //제대로 가고 있는 경우!
        update(index*2, left, (left+right)/2, target, value);
        update(index*2+1, (left+right)/2+1, right, target, value);
        tree[index] = Integer.min(tree[index*2], tree[index*2+1]);
    }

    private int query(int index, int left, int right, int query_left, int query_right){
        //범위를 벗어난 경우
        if(query_right < left || query_left > right)
            return Integer.MAX_VALUE;
        //도착한 경우
        if(query_left <= left && right <= query_right)
            return tree[index];
        //제대로 가고 있는 경우!
        int sonLeft = query(index*2, left, (left+right)/2, query_left, query_right);
        int sonRight = query(index*2+1, (left+right)/2+1, right, query_left, query_right);
        return Integer.min(sonLeft,sonRight);
    }

    public static void main(String[] args) throws IOException {
        String s = "CAGCCTA";
        int p[] = {2,5,0};
        int q[] = {4,5,6};

        int result[] = new Solution().solution(s,p,q);
        for (int r:result) System.out.println(r);
    }
}
