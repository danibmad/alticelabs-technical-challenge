package com.labseq;

import java.util.concurrent.ConcurrentHashMap;
import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigInteger;

/**
 *
 * @author danie
 */
@ApplicationScoped
public class LabseqService {

    private static final int SIZE = 4;
    private static final BigInteger[] VECTOR3 = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO};
    private static final BigInteger[][] MATRIX_TRANSFORM = {
        {BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE},
        {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
        {BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO},
        {BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO}
    };
    private final ConcurrentHashMap<Long, BigInteger> cache = new ConcurrentHashMap<>();

    /**
     * Calculates the labseq value for the given index n. Uses matrix
     * exponentiation and caching for O(log n) performance.
     *
     * @param n non-negative index
     * @return l(n)
     * @throws IllegalArgumentException if n < 0
     */
    public BigInteger calculateLabseq(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid n value, should be greataer than 0");
        }
        return cache.computeIfAbsent(n, this::calculate);
    }

    private BigInteger calculate(long n) {
        if (n == 0 || n == 2) {
            return BigInteger.ZERO;
        }
        if (n == 1 || n == 3) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ZERO;

        BigInteger[][] poweredMatrix = calculateMatrixToPower(MATRIX_TRANSFORM, n - 3);

        for (int i = 0; i < SIZE; i++) {
            result = result.add(poweredMatrix[0][i].multiply(VECTOR3[i]));
        }

        return result;
    }

    private BigInteger[][] calculateMatrixToPower(BigInteger[][] matrix, long power) {
        BigInteger[][] result = initializeMatrix();
        
        for (int i = 0; i < SIZE; i++) {
            result[i][i] = BigInteger.ONE;
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

    private BigInteger[][] multiplyMatrices(BigInteger[][] matrixA, BigInteger[][] matrixB) {
        BigInteger[][] result = initializeMatrix();
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    result[i][j] = result[i][j].add(matrixA[i][k].multiply(matrixB[k][j]));
                }
            }
        }

        return result;
    }
    
    private BigInteger[][] initializeMatrix() {
        BigInteger[][] result = new BigInteger[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = BigInteger.ZERO;
            }
        }
        return result;
    }
}
