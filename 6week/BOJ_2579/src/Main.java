import java.io.*;

public class Main {
    static int n;
    static int[] dp;
    public int solution(int[] arr){
        int answer = 0;
        dp[0] = arr[0];
        dp[1] = arr[1] + arr[0];
        dp[2] = Math.max(dp[0] + arr[2], arr[1] + arr[2]);
        for(int i=3;i<n;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
        return answer = dp[n-1];
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n];
        int answer = T.solution(arr);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}