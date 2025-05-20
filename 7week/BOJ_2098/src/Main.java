import java.io.*;
import java.util.*;

public class Main {

    static int bit, n, MAX = 1000000*16*15+1;
    static int[][] dp, w;
    public int solution(int now, int visitedBit){
        if(visitedBit == bit) {
            if(w[now][0] == 0) return MAX;
            else return w[now][0];
        }
        if(dp[now][visitedBit] != -1) return dp[now][visitedBit];
        dp[now][visitedBit] = MAX;
        for(int i=0;i<n;i++){
            int nv = (visitedBit) | (1 << i);
            if(w[now][i] != 0 && (visitedBit & (1 << i)) == 0){
                dp[now][visitedBit] = Math.min(dp[now][visitedBit], w[now][i] + solution(i, nv));
            }
        }
        return dp[now][visitedBit];
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        bit = (1 << n) - 1;

        StringTokenizer st;
        w = new int[n][n];
        dp = new int[n][bit];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = T.solution(0, 1);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}