class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) return m;

        int size = 2 * m;
        long[][] T = new long[size][size];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                T[j + m][i] = 1;
            }
            for (int j = i + 1; j < m; j++) {
                T[j][i + m] = 1;
            }
        }

        T = matrixPower(T, n - 1);

        long ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ans = (ans + T[i][j]) % MOD;
            }
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] base, int exp) {
        int size = base.length;
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) res[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) res = multiply(res, base);
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int size = A.length;
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}