import java.io.*;
import java.util.Stack;

public class Main {
    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == '(') stack.push(str.charAt(i));
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int answer = T.solution(str);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}