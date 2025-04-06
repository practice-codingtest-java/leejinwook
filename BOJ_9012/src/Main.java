import java.io.*;
import java.util.Stack;

public class Main {
    public boolean solution(String str){
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            if(arr[i] == '(') stack.push(arr[i]);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            boolean answer = T.solution(str);
            if(answer) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}