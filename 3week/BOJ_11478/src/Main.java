import java.io.*;
import java.util.HashSet;

public class Main {
    public int solution(String str){
        int answer = 0;
        HashSet<String> hashSet = new HashSet<>();
        for(int lt = 0;lt<str.length();lt++){
            hashSet.add(String.valueOf(str.charAt(lt)));
            for(int rt = lt+1;rt<str.length();rt++){
                String substring = str.substring(lt, rt+1);
                hashSet.add(substring);
            }
        }
        answer = hashSet.size();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int answer = T.solution(str);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}