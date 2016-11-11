package edx.itmo.week1;

import java.io.*;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by ekiselev on 11/1/2016.
 */
public class CreateTeam {
    private static String TASK_NAME = "team";
    static Scanner newInput(String task) throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File(task + ".in"));
        } else {
            return new Scanner(System.in);
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

        try (Scanner in = newInput(TASK_NAME); PrintWriter out = newOutput(TASK_NAME)) {
            int[][] input = new int[3][3];
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int i1 = in.nextInt();
                    input[i][j] = i1 * i1;
                }
            }
            int res = IntStream.of(
                    (input[0][0] + input[1][1] + input[2][2]),
                    (input[0][0] + input[1][2] + input[2][1]),
                    (input[0][1] + input[1][0] + input[2][2]),
                    (input[0][1] + input[1][2] + input[2][0]),
                    (input[0][2] + input[1][0] + input[2][1]),
                    (input[0][2] + input[1][1] + input[2][0]))
                    .max().getAsInt();
            out.println(Math.sqrt(res));

        }
    }
}
