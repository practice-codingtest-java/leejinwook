import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public long solution(int k, int n, int[] arr){
        long answer = 0;
        long left = 1, right = 0;
        for (int i : arr) {
            right = Math. max(i, right);
        }
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i : arr) {
                sum += (i / mid);
            }
            if(sum >= n) {
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

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i=0;i<k;i++) arr[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(T.solution(k, n, arr)));
        bw.flush();
        bw.close();
    }
}