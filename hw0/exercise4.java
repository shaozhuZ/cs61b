public class exercise4 {
    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }

    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
//            定义一个剩余数字
            int left_num = a.length - i - 1;
            int break_num = a.length - 1;

            if (a[i] < 0) {
                continue;
            } else if (break_num == i) {
                break;
            } else if (left_num < n) {
                for (int k = 1; k <= left_num; k++) {
                    a[i] = a[i] + a[i + k];}
            } else for (int j = 1; j <= n; j++) {
                    a[i] = a[i] + a[i + j];
                }


            }
        }
    }
