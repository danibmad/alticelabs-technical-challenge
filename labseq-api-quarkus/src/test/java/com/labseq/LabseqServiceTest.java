/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labseq;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author danie
 */
public class LabseqServiceTest {

    private final LabseqService service = new LabseqService();

    @Test
    void testGivenValues() {
        assertEquals(0, service.calculateLabseq(0));
        assertEquals(1, service.calculateLabseq(1));
        assertEquals(0, service.calculateLabseq(2));
        assertEquals(1, service.calculateLabseq(3));
    }

    @Test
    void testNormalValues() {
        assertEquals(1, service.calculateLabseq(4));
        assertEquals(1, service.calculateLabseq(5));
        assertEquals(1, service.calculateLabseq(6));
        assertEquals(2, service.calculateLabseq(7));
        assertEquals(2, service.calculateLabseq(8));
        assertEquals(2, service.calculateLabseq(9));
        assertEquals(3, service.calculateLabseq(10));
        assertEquals(4, service.calculateLabseq(11));
        assertEquals(4, service.calculateLabseq(12));
        assertEquals(5, service.calculateLabseq(13));
    }

    @Test
    void testNegativeValues() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> service.calculateLabseq(-1));
        assertEquals("Invalid n value, should be greater than 0", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> service.calculateLabseq(-12));
        assertEquals("Invalid n value, should be greater than 0", exception2.getMessage());
    }
}
