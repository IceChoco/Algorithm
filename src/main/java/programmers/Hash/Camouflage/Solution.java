package programmers.Hash.Camouflage;

import java.util.HashMap;

/* [풀이방법]
 * 1. 전체 경우의 수에서 아무것도 안입는 경우의수 - 1
 *  1) 왜냐 전체 의상중 최소 1개는 입어야 하기 때문 -> 즉, 아무것도 안입는 경우의수를 빼면 됨
 *  2) 전체 경우의수: 의상 종류별로 안 입는 경우를 추가. 2, 1, 1, 1이라면 3, 2, 2, 2의 곱이 전체 경우의 수
 *    (ex)
 *      안경, 선글라스, 안 입는 경우
 *      티셔츠, 안 입는 경우
 *      청바지, 안 입는 경우
 *      긴 코트, 안 입는 경우
 */

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> closet = new HashMap<>();

        String type;
        for(String[] clothe:clothes){
            type = clothe[1];
            closet.put(type, closet.getOrDefault(type,0)+1);
        }

        int product = 0;
        for(String key : closet.keySet()){
            product = product==0?closet.get(key)+1:product*(closet.get(key)+1);
        }

        return product-1;
    }

    public static void main(String[] args) {
//        String[][] test = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};//5
        String[][] test = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};//3
        System.out.println(new Solution().solution(test));
    }
}
