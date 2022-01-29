package programmers.Open_ChattingRoom;

import java.util.*;

/* [유의해야 할 점]
 *  1. 채팅방에서 user가 나간다고해도 userTable에서 지우면 안되는데 지워버림^^;;
 *     그래서 null님이 나갔습니다. null님이 들어왔습니다로 나오면서 틀려버림
 *
 *  어이없는 걸로 삽질하지말자.... 젭알ㅜ
 */

public class Solution {
    private Map<String, String> userTables;
    private List<String> recordToPrint;
    private StringTokenizer st;

    public String[] solution(String[] record) {
        String flag, userId, nickname;
        userTables = new HashMap<>();
        recordToPrint = new ArrayList<>();

        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            flag = st.nextToken();
            userId = st.nextToken();

            if(flag.equals("Enter")){
                nickname = st.nextToken();
                enterOrChange(userId, nickname);
                recordToPrint.add(record[i]);
            }else if(flag.equals("Leave")){
                recordToPrint.add(record[i]);
            }else{//Change
                nickname = st.nextToken();
                enterOrChange(userId, nickname);
            }
        }

        return printMessage();
    }

    private String[] printMessage(){
        String[] answer = new String[recordToPrint.size()];
        String flagLoc, userIdLoc;
        StringBuffer sb;

        for(int i=0;i<recordToPrint.size();i++){
            sb = new StringBuffer();
            st = new StringTokenizer(recordToPrint.get(i));
            flagLoc = st.nextToken();
            userIdLoc = st.nextToken();

            if(flagLoc.equals("Enter")){
                sb.append(userTables.get(userIdLoc)).append("님이 들어왔습니다.");
            }else{
                sb.append(userTables.get(userIdLoc)).append("님이 나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private void enterOrChange(String userId,String nickname){
        userTables.put(userId, nickname);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        //1.채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
//        String[] record = {"Enter uid1234 Muzi",
//                            "Enter uid4567 Prodo",
//                            "Leave uid1234",
//                            "Enter uid1234 Prodo",
//                            "Change uid4567 Ryan"}; //ok

        //2.채팅방에서 닉네임을 변경한다.
        String[] record = {"Enter uid0000 Ara",
                            "Leave uid0000",
                           "Enter uid0000 Ara",
                            "Leave uid0000",
                            "Enter uid0000 Ara",
                            "Leave uid0000"};

        String[] ans = new Solution().solution(record);
        for(String s:ans){
            System.out.println(s);
        }
        System.out.print((float)(System.currentTimeMillis() - start)/1000+"sec");
    }
}
