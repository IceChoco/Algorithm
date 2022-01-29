package programmers.takeAgroupPhoto;
/* [풀이방법]
 * 1. DFS로 8명의 KakaoFriends에 대해 완전탐색
 * 2. 8개의 원소를 다 채우면, 해당 순열이 주어진 조건을 만족하는 순열인지 체크
 * 3. 조건들을 모두 만족한 경우 ans++, 만족하지 못한 경우 pass
 * 4. ans의 수를 출력!
 */
import java.util.HashMap;

public class Solution {
    private static boolean[] visited;
    private static int[] locByFriend;
    private static String[] globalData;
    private static int answer;
    private static HashMap<Character, Integer> kakaoFriends;

    public int solution(int n, String[] data) {
        answer = 0;
        locByFriend = new int[8];
        visited = new boolean[8];
        globalData = data;

        setKaKaoFriends();

        //8명의 kakaoFriends 친구들을 줄 세울 수 있는 경우의 수에 대해 완전 탐색을 실시한다
        lineUp(0);

        return answer;
    }

    private void setKaKaoFriends(){
        kakaoFriends = new HashMap<Character, Integer>();
        kakaoFriends.put('A',0);
        kakaoFriends.put('C',1);
        kakaoFriends.put('F',2);
        kakaoFriends.put('J',3);
        kakaoFriends.put('M',4);
        kakaoFriends.put('N',5);
        kakaoFriends.put('R',6);
        kakaoFriends.put('T',7);
    }

    private static void lineUp(int friendNum){
        if(friendNum >= 8){//배열의 범위를 벗어난 경우
            if (isValid()) answer++;
        }else{
            for (int idx=0;idx<8;idx++){//friend를 배치할 idx
                if(!visited[idx]){
                    visited[idx] = true;
                    locByFriend[friendNum] = idx;
                    lineUp(friendNum+1);
                    locByFriend[friendNum] = 0;
                    visited[idx] = false;
                }
            }
        }
    }

    private static boolean isValid(){
        int i,you,interval;
        char sign;
        for(String wants:globalData){
            i = locByFriend[kakaoFriends.get(wants.charAt(0))];
            you = locByFriend[kakaoFriends.get(wants.charAt(2))];
            sign = wants.charAt(3);
            interval = wants.charAt(4)-'0'+1;

            if(sign == '='){
                if(Math.abs(i-you)!=interval)
                    return false;
            }else if(sign == '>'){
                if(!(Math.abs(i-you)>interval))
                    return false;
            }else if(sign == '<'){
                if(!(Math.abs(i-you)<interval))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String[] input = {"N~F=1","R~T=2"};//1344
//        String[] input = {"N~F=0", "R~T>2"};//3648
        String[] input = {"M~C<2", "C~M>1"};//0

        System.out.println(new Solution().solution(2,input));
    }
}