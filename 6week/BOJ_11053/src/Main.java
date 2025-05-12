import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public int solution(int n, int[] arr){
        int answer = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(T.solution(n, arr)));
        bw.flush();
        bw.close();
    }
}