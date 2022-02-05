package programmers.Heap.DiskController;

import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        Queue<Disk> q = new LinkedList<>();
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        for(int[] j:jobs)
            q.add(new Disk(j[0],j[1]));

        int nowTime = 0, acmmTime = 0;
        while(!q.isEmpty()){
            Disk d = null;
            for(Disk insp:q){
                if(nowTime >= insp.req){//끝난시간>= 요청시간
                    //작업시간이 제일 빠른 친구만 poll, 나머지는 peek
                    if(d == null || d.time > insp.time)
                        d = insp;
                }else{
                    break;
                }
            }

            if(d == null)
                d = q.poll();
            else{
                q.remove(d);
            }

            if(nowTime < d.req){//지금 시간 < 요청시간
                nowTime += (d.req-nowTime) + d.time;//붕뜬 시간(d.req-nowTime) + 작업시간
            }else{//지금시간 >= 요청시간
                nowTime += d.time;
            }
            acmmTime += nowTime - d.req;
        }

        return acmmTime/jobs.length;
    }

    private static final Comparator<Disk> sortByShortTime = Comparator.comparingInt(o -> o.time);

    class Disk implements Comparable<Disk>{
        int req;
        int time;

        public Disk(int req, int time) {
            this.req = req;
            this.time = time;
        }

        @Override
        public int compareTo(Disk o) {
            if(this.req == o.req)
                return this.time - o.time;//작업시간 오름차
            return this.req - o.req;//요청시간 오름차
        }
    }

    public static void main(String[] args) {
//        int[][] jobs = {{0,10},{100,1},{90,200}};//133
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20,1}}; //7
//        int[][] jobs = {{0, 3}, {1, 9}, {500, 6}};//6
//        int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};//13
//        int[][] jobs = {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}};//13
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};//답:72     나:78
        System.out.println(new Solution().solution(jobs));
    }
}
