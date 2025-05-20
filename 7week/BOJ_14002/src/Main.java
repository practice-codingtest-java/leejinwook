import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp, answerArr;
    public int solution(int n, int[] arr){
        int answer = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        answerArr = new int[answer];
        int cnt = answer;
        for (int i=n-1;i>=0;i--) {
            if(cnt == dp[i]){
                answerArr[cnt-1] = arr[i];
                cnt--;
            }
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(T.solution(n, arr)));
        bw.write("\n");
        for (int i : answerArr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}