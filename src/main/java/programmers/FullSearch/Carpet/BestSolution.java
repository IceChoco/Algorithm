package programmers.FullSearch.Carpet;

public class BestSolution {
    public int[] solution(int brown, int red) {
        int a = (brown+4)/2;
        int b = red+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }

    public static void main(String[] args) {
        int[] result = new BestSolution().solution(10,2);
        for(int r:result)
            System.out.println(r);
    }
}
