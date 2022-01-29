package codility.Lesson7_StacksAndQueues.Fish;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
/*
[풀이]
어차피 상류로 흘러가는 친구랑 하류로 흘러가는 친구를 모두 구해야 하니까.
결국 배열의 끝에서 부터 넣던 시작부터 넣던 동일한 결과가 나와야 할꺼야 일단. 혹은 두번 돌리거나

1. 상류로 빠져나가는 친구들
앞에서부터 차례대로 보겠지.
1) 이미 상류쪽으로 흘러가고 있는 친구들은 알아서 들어갈꺼고
2) 하류로 흘러가는 친구가 나왔으면, 이 친구는 자기보다 크면서 상류로 가고있는 친구 만나기 전까진 상류로 올라가는 친구들을 다 잡아먹을꺼야
 - 그러다가 하류로 흘러가는 더 큰 친구가 나오면? 더 큰 값 기준으로 비교한다.
   즉, 2)처럼 기준보다 크면서 상류로 가고있는 친구가 있지 않은 이상 다 잡아먹힐것이다.
3) 만약 더 크면서 상류로 가고있는 친구가 있다면,
 - 그 친구가 하류 방향으로 흐르던 물고기들 다 잡아먹고 그 뒤에 있는 상류로 가는 친구들은 안전하게 상류로 가겠지

결국, 앞에서부터 보면서 현재까지 나온 것 중에 제일 큰 친구만 기억하면서 가면 돼
그럼 상류로 빠지는 친구를 다 찾을 수 있어. 하류로 빠지는건 너가 한것처럼 뒤에서 부터 똑같이 보면 될껴

[내 소스의 문제점]
하류로 빠지는 친구가 모든 친구들을 다 잡아먹었을 경우, 본인을 스택에 넣지 않았음.
→ 끝까지 모든 물고기를 다 잡아먹은 경우 now를 스택에 넣는 로직 추가로 해결
* */
public class Solution {
    public int solution(int[] A, int[] B){
        Stack<Fish> st = new Stack<>();
        int nowSize,tgtSize, nowDirection, tgtDirection;
        boolean jumpYn;
        st.push(new Fish(A[A.length-1],B[A.length-1]));

        for(int i=A.length-2;i>=0;i--){//시간 복잡도: O(N)

            nowSize = A[i];
            nowDirection = B[i];
            jumpYn = false;

            while (!st.isEmpty()){//스택이 비어있지 않으면 원소값 비교를 진행한다.
                tgtSize = st.peek().size;
                tgtDirection = st.peek().direction;

                if(0 == nowDirection){//1. 상류 방향이라면
                    st.push(new Fish(nowSize, nowDirection));
                    jumpYn = true;
                    break;
                }
                else{//2.하류방향
                    if(nowDirection == tgtDirection){//2-1.둘다 하류방향!
                        st.push(new Fish(nowSize, nowDirection));
                        jumpYn = true; break;
                    }

                    //2-2.기존이 되는게 하류, 타겟이 상류 방향이라면?
                    if(nowSize > tgtSize){//내가 물고기 크기가 더 크면
                        st.pop();
                    }else{//더 작으면 a는 버리고, b는 두고
                        jumpYn = true; break;
                    }
                }
            }
            //끝까지 모든 물고기를 다 잡아먹은 경우 now를 스택에 넣는다.
            if(!jumpYn)
                st.push(new Fish(nowSize, nowDirection));
        }

        return st.size() == 0 ? 1 : st.size();
    }

    private class Fish{
        int size;
        int direction;

        public Fish(int size, int direction) {
            this.size = size;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Lesson7_StackAndQueues_Fish.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N;
        int[] A, B;
        StringTokenizer st;

        for(int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());
            A = new int[N];
            B = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                B[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#"+(i+1)+" "+new Solution().solution(A,B));
        }
    }
}

/* 테스트 케이스 별 예상 답
#1 2
#2 1
#3 2
#4 2
#5 2
* */
