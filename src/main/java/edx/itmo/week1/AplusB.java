package edx.itmo.week1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ekiselev on 10/25/2016.
 */
public class AplusB {
    static Scanner newInput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File("aplusb.in"));
        } else {
            return new Scanner(System.in);
        }
    }
    static PrintWriter newOutput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter("aplusb.out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            out.println(in.nextInt() + in.nextInt());
        }
    }
}
