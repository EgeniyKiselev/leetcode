package edx.itmo.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ekiselev on 11/10/2016.
 */
public class Snowmen {
    private static String TASK_NAME = "snowmen";

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
            int total = in.nextInt();
            List<SnowMan> snow = new ArrayList<>();
            snow.add(new SnowMan(0, 0));
            long res1 = 0;
            for (int i = 0; i < total; i++) {
                int t = in.nextInt();
                int m = in.nextInt();
                res1 += calc(t, m, snow);
            }
            out.println(res1);
        }
    }

    private static long calc(int t, int m, List<SnowMan> snow) {
        SnowMan sm = snow.get(t);
        if (m == 0) {
            SnowMan snowMan = snow.get(sm.prev);
            snow.add(snowMan);
            return snowMan.total;
        } else {
            SnowMan s = new SnowMan(sm.total + m, t);
            snow.add(s);
            return s.total;
        }
    }

    static class SnowMan {
        int total;
        int prev;

        public SnowMan(int total, int prev) {
            this.total = total;
            this.prev = prev;
        }
    }
}

//        0        []
//        0 1      [1]        = 1
//        1 5      [1 5]      = 6
//        2 4      [1 5 4]    = 10
//        3 2      [1 5 4 2]  = 12
//        4 3      [1 5 4 2 3]= 15
//        5 0      [1 5 4 2]  = 12
//        6 6      [1 5 4 2 6]= 18
//        1 0      []         = []

//15               []
//        0 1     [1]
//        0 2     [2]
//        1 3
//        2 4
//        4 0
//        5 0