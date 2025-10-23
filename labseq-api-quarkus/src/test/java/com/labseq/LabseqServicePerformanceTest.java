/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labseq;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author danie
 */
public class LabseqServicePerformanceTest {
    
    private final LabseqService service = new LabseqService();
    
    @Test
    void testPerformance() {
        long n = 100_000;
        
        long start = System.currentTimeMillis();
        BigInteger result = service.calculateLabseq(n);
        long duration = System.currentTimeMillis() - start;
        
        System.out.println("Result: " + result);
        System.out.println("Time: " + duration + "ms");
        
        assertTrue(duration < 10_000, "Calculation time exceded 10 seconds.");
    }
}
