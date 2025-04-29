import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int[] count = new int[n];
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                if(j == k) continue;
                for(int i=0;i<5;i++){
                    if(arr[j][i] == arr[k][i]){
                        count[j]++;
                        break;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < count[i]) {
                max = count[i];
                answer = i + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(String.valueOf(T.solution(n, arr)));
        bw.flush();
        bw.close();
    }
}