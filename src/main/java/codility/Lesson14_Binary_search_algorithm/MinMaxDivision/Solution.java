package codility.Lesson14_Binary_search_algorithm.MinMaxDivision;

public class Solution {
    public int solution(int K, int M, int[] A){
        int min = 0, max = 0;
        for(int a:A){
            max += a;
            min = Math.max(min, a);
        }

        int ans = max, mid = 0, blocks;
        while(min <= max){
            mid = (min+max)/2;
            blocks = getBlocks(A, mid);

            if(blocks > K){
                min = mid+1;
            }else{
                max = mid-1;
                ans = Math.min(mid, ans);
            }
        }

        return ans;
    }

    private int getBlocks(int[] A, int mid){
        int blocks = 1;
        int blockSum = 0;
        for(int a:A){
            blockSum += a;
            if(blockSum > mid){
                blockSum = a;
                blocks++;
            }
        }

        return blocks;
    }

    public static void main(String[] args) {
        int[] test = {2,1,5,1,2,2,2};
        System.out.println(new Solution().solution(3,5,test));

//        int[] test = {5,2,3,4,6};
//        System.out.println(new Solution().solution(3,6,test));
    }
}
