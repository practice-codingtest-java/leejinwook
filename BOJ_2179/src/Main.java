import java.io.*;

public class Main {
    public String[] solution(int n, String[] arr){
        String[] answer = new String[2];
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
        String[] answer = T.solution(n, arr);
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}