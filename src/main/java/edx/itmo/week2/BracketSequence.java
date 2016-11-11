package edx.itmo.week2;

import java.io.*;
import java.util.*;

/**
 * Created by ekiselev on 11/10/2016.
 */
public class BracketSequence {
    private static String TASK_NAME = "brackets";

    static class FastScanner {
        static BufferedReader br;
        static StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String str = br.readLine();
                    if (str == null) {
                        return null;
                    }
                    st = new StringTokenizer(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDoulbe() {
            return Double.parseDouble(next());
        }
    }

    static FastScanner newInput(String task) throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new FastScanner(new File(task + ".in"));
        } else {
            return new FastScanner(System.in);
        }
    }

    static PrintWriter newOutput(String task) throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter(task + ".out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    static String calculate(String next) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return "NO";
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = newOutput(TASK_NAME)) {
            FastScanner in = newInput(TASK_NAME);
//            long start = System.currentTimeMillis();
            String next;
            while ((next = in.next()) != null) {
                out.println(calculate(next));
            }
//            System.out.println(System.currentTimeMillis() - start);
        }
    }
}
