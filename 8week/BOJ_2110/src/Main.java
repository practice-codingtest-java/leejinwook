import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public long solution(int n, int c, int[] arr){
        long answer = 0;
        Arrays.sort(arr);
        long left = 1, right = arr[n-1];
        while(left <= right){
            long mid = (left + right) / 2, ep = arr[0], cnt = 1;
            for(int i=1;i<n;i++){
                if((arr[i] - ep) >= mid){
                    cnt++;
                    ep = arr[i];
                }
            }
            if(cnt >= c){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(T.solution(n, c, arr)));
        bw.flush();
        bw.close();
    }
}