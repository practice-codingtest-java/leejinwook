import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public int solution(int n, int[] arr){
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(T.solution(n, arr)));
        bw.flush();
        bw.close();
    }
}