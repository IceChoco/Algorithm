package programmers.Hash.Camouflage;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class FunctionalSolution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p->p[0],counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x,y) -> x*(y+1))).intValue()-1;
    }

    public static void main(String[] args) {
//        String[][] test = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};//5
        String[][] test = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};//3
        System.out.println(new FunctionalSolution().solution(test));
    }
}
