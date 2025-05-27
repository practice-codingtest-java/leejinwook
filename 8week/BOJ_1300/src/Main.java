import java.io.*;

public class Main {
    public long solution(int n, int k){
        long answer = 0, left = 1, right = (long) n *n;
        while(left <= right){
            long mid = (left + right) / 2, sum = 0;
            for(int i=1;i<=n;i++){
                if(mid > ((long) i *n)) sum += n;
                else{
                    sum += (mid / i);
                }
            }
            if(sum >= k){
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(T.solution(n, k)));
        bw.flush();
        bw.close();
    }
}