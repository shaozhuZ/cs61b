package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {

        AList<Double> times1 = new AList<>();
        AList<Integer> opCounts1 = new AList<>();
        AList<Integer> nCounts1 = new AList<>();

        Integer count = 1000;
        Integer location = 0;

        for (int i = 1; i <= 8; i++) {
            if (i == 1) {
                nCounts1.addLast(i * count);
            } else {
                int num = nCounts1.get(i - 2);
                nCounts1.addLast(num * 2);

            }
        }

        for (int j = 0; j < 128001; j++) {

            if (j == nCounts1.get(location) && location <= 7) {
                AList<Integer> Ns1 = new AList<>();

                Stopwatch sw = new Stopwatch();

                for (int k = 0; k < j; k++) {

                    Ns1.addLast(k);

                }

                Double timeInSeconds = sw.elapsedTime();
                times1.addLast(timeInSeconds);
                opCounts1.addLast(nCounts1.get(location));

                location += 1;

            }

        }
        printTimingTable(nCounts1, times1, opCounts1);



    }
}