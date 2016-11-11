package edx.itmo.week2;

import java.io.*;
import java.util.*;

/**
 * Created by ekiselev on 11/10/2016.
 */
public class MinQueue {
    private static String TASK_NAME = "queuemin";

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
                    st = new StringTokenizer(br.readLine());
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

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = newOutput(TASK_NAME)) {
            FastScanner in = newInput(TASK_NAME);
            int lines = in.nextInt();
//            long start = System.currentTimeMillis();
            ArrayDeque<Integer> queue = new ArrayDeque<>(lines);
            ArrayDeque<Integer> queueMin = new ArrayDeque<>(lines);
            for (int i = 0; i < lines; i++) {
                String line = in.next();
                if (line.charAt(0) == '-') {
                    Integer cur = queue.removeFirst();
                    if (Objects.equals(cur, queueMin.peekFirst())) {
                        queueMin.removeFirst();
                    }
                } else if (line.charAt(0) == '?') {
                    out.println(queueMin.peek());
                } else {
                    int e = Integer.parseInt(in.next());
                    queue.addLast(e);
                    while (!queueMin.isEmpty() && queueMin.peekLast() > e) {
                        queueMin.removeLast();
                    }
                    queueMin.addLast(e);
                }
            }
//            System.out.println(System.currentTimeMillis() - start);
        }
    }
}
