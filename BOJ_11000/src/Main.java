import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
    int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        return o.start - this.start;
    }
}
public class Main {
    public int solution(int n, ArrayList<Time> arr){
        int answer = 0, min = Integer.MAX_VALUE;
        for (Time time : arr) {
            int s = time.start;
            int e = time.end;
            if(min >= e){
                min = s;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);
        bw.write(String.valueOf(T.solution(n, arr)));
        bw.flush();
        bw.close();
    }
}