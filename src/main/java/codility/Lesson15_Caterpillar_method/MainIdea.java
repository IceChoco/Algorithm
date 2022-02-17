package codility.Lesson15_Caterpillar_method;

public class MainIdea {
    private boolean caterpillarMethod(int[] A, int S){
        int n = A.length, front=0, total = 0;
        for(int back=0; back < n; back++){
            while(front < n && total + A[front] <=S){
                total++;
                front++;
            }
            if(total == S) return true;
            total -= A[back];
        }
        return false;
    }

    private boolean triangles(int[] A){
        int n = A.length, result=0;
        for(int x=0; x < n; x++){
            int z = x+2; //x+y>z를 만족하는 z의 최소값은 x+2이다. +1을 하면 같아져서 >를 만족하지 못한다.
            for(int y =x+1;y<n;y++){
                while(z<n && A[x]+A[y]>A[z])
                    z++;
                result += z-y-1;//ax+ay>az이므로 z와 y 사이의 값이 위 식을 만족하는 갯수임. y<k<=z인 k의 수를 모두 구하기 위함.
            }
        }
        return false;
    }
}
