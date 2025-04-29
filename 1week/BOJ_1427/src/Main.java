import java.io.*;
import java.util.Arrays;

public class Main {
    public String solution(String str){
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for (char c : arr) {
            sb.append(String.valueOf(c));
        }
        answer = sb.reverse().toString();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String answer = T.solution(str);
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}