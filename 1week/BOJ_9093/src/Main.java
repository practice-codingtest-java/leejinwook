import java.io.*;

public class Main {
    public String solution(String str){
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        for (String s : arr) {
            String reverse = new StringBuilder(s).reverse().toString();
            sb.append(reverse).append(" ");
        }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        for (String s : arr) {
            String answer = T.solution(s);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}