package edx.itmo.week1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ekiselev on 10/25/2016.
 */
public class AplusBB {
    static Scanner newInput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File("aplusbb.in"));
        } else {
            return new Scanner(System.in);
        }
    }
    static PrintWriter newOutput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter("aplusbb.out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            int A = in.nextInt();
            int B = in.nextInt();
            out.println(A + (long)B * B);
        }
    }
}
