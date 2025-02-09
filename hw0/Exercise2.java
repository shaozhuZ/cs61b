public class Exercise2 {

    public static final int A_NUMBER = 15;
    public static final int B_NUMBER = 22;

    public static final int C_NUMBER = 10;
    public static int[] max(int[] m) {
        for (int i = 0; i <= m.length - 1; i++) {
            for (int j = i + 1; j <= m.length - 1; j++) {
                if (m[i] < m[j]) {
                    int maxNum = m[j];
                    int minNum = m[i];
                    m[i] = maxNum;
                    m[j] = minNum;
                }

            }

        }

        System.out.println(m[0]);
        return m;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, A_NUMBER, 2, B_NUMBER, C_NUMBER, 6};
        max(numbers);
    }
}
