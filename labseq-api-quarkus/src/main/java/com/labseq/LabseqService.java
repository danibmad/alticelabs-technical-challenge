package com.labseq;

import java.util.concurrent.ConcurrentHashMap;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author danie
 */
@ApplicationScoped
public class LabseqService {

    private static final int SIZE = 4;
    private static final long[] VECTOR3 = {1, 0, 1, 0};
    private static final long[][] MATRIX_TRANSFORM = {
        {0, 0, 1, 1},
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0}
    };
    private final ConcurrentHashMap<Long, Long> cache = new ConcurrentHashMap<>();

    /**
     * Calculates the labseq value for the given index n. Uses matrix
     * exponentiation and caching for O(log n) performance.
     *
     * @param n non-negative index
     * @return l(n)
     * @throws IllegalArgumentException if n < 0
     */
    public long calculateLabseq(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid n value, should be greataer than 0");
        }
        return cache.computeIfAbsent(n, this::calculate);
    }

    private long calculate(long n) {
        if (n == 0 || n == 2) {
            return 0;
        }
        if (n == 1 || n == 3) {
            return 1;
        }

        long result = 0;

        long[][] poweredMatrix = calculateMatrixToPower(MATRIX_TRANSFORM, n - 3);

        for (int i = 0; i < SIZE; i++) {
            result += poweredMatrix[0][i] * VECTOR3[i];
        }

        return result;
    }

    private long[][] calculateMatrixToPower(long[][] matrix, long power) {
        long[][] result = new long[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, matrix);
            }

            matrix = multiplyMatrices(matrix, matrix);

            power >>= 1;
        }

        return result;
    }

    private long[][] multiplyMatrices(long[][] matrixA, long[][] matrixB) {
        long[][] result = new long[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }
}
