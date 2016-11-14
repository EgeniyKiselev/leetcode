package edx.itmo.week2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by ekiselev on 11/10/2016.
 */
public class KenobiLightsabers {
    private static String TASK_NAME = "kenobi";

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
            Deque<Integer> deq = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                String str = in.next();
                if ("take".equals(str)) {
                    deq.removeLast();
                } else if ("mum!".equals(str)) {
                    int size = deq.size();
                    for (int j = 0; j < size / 2; j++) {
                        int t = deq.removeFirst();
                        deq.addLast(t);
                    }
                } else {
                    int num = in.nextInt();
                    deq.addLast(num);
                }

            }
            int size = deq.size();
            out.println(size);
            for (int i = 0; i < size; i++) {
                out.print(deq.removeFirst());
                out.print(' ');
            }
        }
    }
}
