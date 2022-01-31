package programmers.nationalNumbers124;

public class BestSolution {
    public String solution(int n){
        String[] num = {"4","1","2"};
        StringBuffer sb = new StringBuffer();

        while (n>0){
            sb.insert(0,num[n%3]);
            n = (n-1)/3;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BestSolution().solution(10));
    }
}
