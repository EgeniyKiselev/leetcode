package edx.itmo.week2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by ekiselev on 11/10/2016.
 */
public class Stacks {
    private static String TASK_NAME = "stacks";

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
            int N = in.nextInt();
            PriorityQueue<Integer> pr = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                int n = in.nextInt();
                if (n == 0) {
                    int prev = 0;
                    if (!pr.isEmpty()) {
                        prev = pr.poll();
                    }
                    pr.add(prev + 1);
                } else {
                    pr.add(1);
                }
            }
            int res = Integer.MIN_VALUE;
            while (!pr.isEmpty())
                res = Math.max(pr.poll(), res);
            out.println(res);
        }
    }
}
