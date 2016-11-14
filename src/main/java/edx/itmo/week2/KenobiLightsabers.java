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
//            Deque<Integer> deq = new LinkedList<>();
            Saber head = null;//new Saber(null, null, 0);
            Saber middle = null;
            Saber tail = null;//new Saber(null, null, 0);
            int len = 0;
            for (int i = 0; i < N; i++) {
                String str = in.next();
                if ("take".equals(str)) {
//                    deq.removeLast();
                    if (len % 2 == 0) {
                        middle = middle.prev;
                        if (middle == null) {
                            middle = head;
                        }
                    }

                    tail = removeLast(tail);
                    if (tail == null) {
                        head = null;
                        middle = null;
                    }
                    len--;
                } else if ("mum!".equals(str)) {
//                    int size = deq.size();
//                    for (int j = 0; j < size / 2; j++) {
//                        int t = deq.removeFirst();
//                        deq.addLast(t);
//                    }

                    if (len == 0) {
                        continue;
                    }
                    Saber tmpTail = tail;

                    tail.next = head;
                    tail.next.prev = tail;
                    tail = middle;

                    head = middle.next;
                    head.prev = null;
                    middle = tmpTail;
                    if (len % 2 != 0) {
                        middle = middle.prev;
                    }
                    tail.next = null;
                } else {
                    int num = in.nextInt();
//                    deq.addLast(num);
                    if (tail == null) {
                        Saber s = new Saber(null, null, num);
                        tail = s;
                        head = s;
                        middle = head;
                    } else {
                        tail = addLast(tail, num);
                        if (len == 0) {
                            middle = head;
                        } else if (len == 1) {
                            middle = head;
                        } else if (len == 2) {
                            middle = head;
                        } else if (len % 2 != 0) {
                            middle = middle.next;
                        }
                    }
                    len++;
                }

            }
//            int size = deq.size();
//            out.println(size);
//            for (int i = 0; i < size; i++) {
//                out.print(deq.removeFirst());
//                out.print(' ');
//            }
//            out.println(" ");

            out.println(len);
            Saber cur = head;
            while (cur != null) {
                out.print(cur.number);
                out.print(' ');
                cur = cur.next;
            }
        }
    }
    static Saber addLast(Saber s, int n) {
        if (s != null) {
            Saber newTail = new Saber(s, null, n);
            s.next = newTail;
            newTail.prev = s;
            return newTail;
        }
        return new Saber(null, null, n);
    }

    static Saber removeLast(Saber s) {
        if (s != null) {
            s = s.prev;
            if (s == null) {
                return s;
            }
            s.next = null;
            return s;
        }
        return null;
    }

    static class Saber {
        Saber prev;
        Saber next;
        int number;

        public Saber(Saber prev, Saber next, int number) {
            this.prev = prev;
            this.next = next;
            this.number = number;
        }
    }
}
