package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {

        AList<Integer> ns1 = new AList<>();
        AList<Double> times1 = new AList<>();
        AList<Integer> opCounts1 = new AList<>();
        AList<Integer> forMyself = new AList<>();

        for (int N = 1000; N < 128001; N = N * 2 ) {
            SLList<Integer> sList = new SLList<>();

            ns1.addLast(N);
            opCounts1.addLast(10000);

            for (int i = 0; i < N; i++) {
                sList.addLast(i);
            }

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j <= 10000; j++) {
                sList.getLast();
            }

            double timeInSeconds = sw.elapsedTime();
            times1.addLast(timeInSeconds);

        }


        printTimingTable(ns1, times1, opCounts1);
    }

}
