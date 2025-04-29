import java.io.*;

public class Main {
    public int solution(int n, String[] arr){
        int answer = 0;
        for(int i=0;i<n;i++){
            String str = arr[i];
            int[] checked = new int[str.length()];
            for(int j=i+1;j<n;j++){

            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        int answer = T.solution(n, arr);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}