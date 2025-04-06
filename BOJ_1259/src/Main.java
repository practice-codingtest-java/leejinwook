import java.io.*;
import java.util.ArrayList;

public class Main {
    public ArrayList<Boolean> solution(ArrayList<String> arr){
        ArrayList<Boolean> answer = new ArrayList<>();
        for (String s : arr) {
            String reverse = new StringBuilder(s).reverse().toString();
            if(s.equals(reverse)) answer.add(true);
            else answer.add(false);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        ArrayList<String> arr = new ArrayList<>();
        while (!(line = br.readLine()).equals("0")){
            arr.add(line);
        }
        ArrayList<Boolean> answer = T.solution(arr);
        for (Boolean b : answer) {
            if(b) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }
}