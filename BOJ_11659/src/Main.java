import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int m, int[] arr, int[][] panel){
        int[] answer = new int[m];
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for(int i=1;i<n;i++){
            preSum[i] = arr[i] + preSum[i-1];
        }
        for(int i=0;i<m;i++){
            answer[i] = preSum[panel[i][1]-1] - preSum[panel[i][0]-1] + arr[panel[i][0]-1];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] panel = new int[n][2];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            panel[i][0] = Integer.parseInt(st.nextToken());
            panel[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] answer = T.solution(n, m, arr, panel);
        for (int i : answer) {
            bw.write(String.valueOf(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}