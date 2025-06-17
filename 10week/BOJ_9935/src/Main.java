import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String regex = br.readLine();
        int regexSize = regex.length();

        Stack<Character> st = new Stack<>();

        for(int i=0; i<line.length(); i++) {
            st.push(line.charAt(i));

            if(st.size()>= regexSize) {
                boolean flag = true;

                for(int j=0; j<regexSize; j++) {
                    if(st.get(st.size()-regexSize+j) != regex.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<regexSize; j++) {
                        st.pop();
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(Character c : st) {
            sb.append(c);
        }
        bw.write(sb.length()==0? "FRULA" : sb.toString());
        bw.flush();
        bw.close();
    }
}