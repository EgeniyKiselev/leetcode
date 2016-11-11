package edx.itmo.week1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ekiselev on 10/25/2016.
 */
public class Prepare {
    static Scanner newInput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File("prepare.in"));
        } else {
            return new Scanner(System.in);
        }
    }
    static PrintWriter newOutput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter("prepare.out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            int days = in.nextInt();
            int res = 0;
            int[] a = new int[days];
            int[] b = new int[days];
            for (int i = 0; i < days; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < days; i++) {
                b[i] = in.nextInt();
            }

            int minDif = Integer.MAX_VALUE;
            int minDifIndex = 0;

            boolean useFirst = false;
            boolean useSecond = false;
            for (int i = 0; i < days; i++) {
                int dif = Math.abs(a[i] - b[i]);
                if (dif < minDif) {
                    minDif = dif;
                    minDifIndex = i;
                }
                if (a[i] < b[i]) {
                    res += b[i];
                    useSecond = true;
                } else {
                    res += a[i];
                    useFirst = true;
                }
            }
            if (!useFirst) {
                res -= b[minDifIndex];
                res += a[minDifIndex];
            }
            if (!useSecond) {
                res -= a[minDifIndex];
                res += b[minDifIndex];
            }

            out.println(res);
        }
    }
}
