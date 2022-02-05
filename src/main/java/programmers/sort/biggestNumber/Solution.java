package programmers.sort.biggestNumber;

import java.util.Arrays;
import java.util.Comparator;

/* cmp(string a, string b) 안에 a , b를 비교할때 string은 +를 지원하므로
   return Integer.compare(Integer.parseInt(o2+o1),Integer.parseInt(o1+o2));
   한줄로 끝난다. 잘생각해보면 a+b는 a가 앞에 있을때 b+a는 b가 앞에 있을 경우입니다. 허무하죠 ㅎㅎ
 */

public class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(stringNumbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(Integer.parseInt(o2+o1),Integer.parseInt(o1+o2));
            }
        });

        StringBuffer sb = new StringBuffer();
        for(String n:stringNumbers)
            sb.append(n);

        String answer = sb.toString();
        return answer.chars().filter(c-> c == '0').count() == answer.length() ? "0" : answer;
    }

    public static void main(String[] args) {
//        int[] test = {6,10,2};//6210
        int[] test = {3, 30, 34, 5, 9};//9534330
//        int[] test = {0, 0, 0};//0
//        int[] test = {979, 97, 978, 81,818,817};//9799797881881817 - 정답 , 나 - 9799797881881817
//        int[] test = {67,676,677};//67767676 - 정답

        System.out.println(new Solution().solution(test));
    }

}