import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public long solution(int n, int m, int[] arr){
        long answer = 0, left = 0, right = 0;
        for (int i : arr) {
            right = Math.max(right, i);
        }
        while(left <= right){
            long mid = (left + right) / 2, sum = 0;
            for (int i : arr) {
                if((i-mid) <= 0) continue;
                sum += (i - mid);
            }
            if(sum >= m) {
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
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(T.solution(n, m, arr)));
        bw.flush();
        bw.close();
    }
}