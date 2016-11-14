package edx.itmo.week2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ekiselev on 11/10/2016.
 */
public class PostfixNotation {
    private static String TASK_NAME = "postfix";

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

        String nextLine() {
            try {
                String str = br.readLine();
                return str;
            } catch (IOException e) {
                e.printStackTrace();
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

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = newOutput(TASK_NAME)) {
            FastScanner in = newInput(TASK_NAME);
            String str = in.nextLine();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    continue;
                }
                int c1, c2;
                switch (ch) {
                    case '+':
                        c1 = stack.pop();
                        c2 = stack.pop();
                        stack.push(c2 + c1);
                        break;
                    case '-':
                        c1 = stack.pop();
                        c2 = stack.pop();
                        stack.push(c2 - c1);
                        break;
                    case '*':
                        c1 = stack.pop();
                        c2 = stack.pop();
                        stack.push(c2 * c1);
                        break;
                    default:
                        stack.push(ch - '0');
                        break;
                }

            }
            out.println(stack.pop());
        }
    }
}
