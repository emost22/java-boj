package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj25206 {
    private static double sumGrade, sumScore;

    private static double getDoubleGrade(double score, String grade) {
        if ("P".equals(grade)) {
            return 0.0;
        }

        sumScore += score;
        if ("A+".equals(grade)) {
            return 4.5 * score;
        } else if ("A0".equals(grade)) {
            return 4.0 * score;
        } else if ("B+".equals(grade)) {
            return 3.5 * score;
        } else if ("B0".equals(grade)) {
            return 3.0 * score;
        } else if ("C+".equals(grade)) {
            return 2.5 * score;
        } else if ("C0".equals(grade)) {
            return 2.0 * score;
        } else if ("D+".equals(grade)) {
            return 1.5 * score;
        } else if ("D0".equals(grade)) {
            return 1.0 * score;
        } else {
            return 0.0;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subjectCnt = 20;
        while (subjectCnt-- > 0) {
            String[] subs = br.readLine().split(" ");
            double score = Double.parseDouble(subs[1]);
            String grade = subs[2];
            sumGrade += getDoubleGrade(score, grade);
        }

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%.6f", sumGrade / sumScore));
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
