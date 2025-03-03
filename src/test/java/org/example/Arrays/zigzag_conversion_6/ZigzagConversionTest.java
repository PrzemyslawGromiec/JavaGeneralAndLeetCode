package org.example.Arrays.zigzag_conversion_6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZigzagConversionTest {

    @Test
    public void testConvert_singleRow() {
        String input = "PAYPALISHIRING";
        int numRows = 1;
        String expected = "PAYPALISHIRING";
        assertEquals(expected, Solution.convert(input,numRows));
    }

    @Test
    public void testConvert_fourRows() {
        String input = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI"; // Zigzag pattern for 4 rows
        assertEquals(expected, Solution.convert(input, numRows));
    }

    @Test
    public void testConvert_edgeCase_twoRows() {
        String input = "HELLO";
        int numRows = 2;
        String expected = "HLOEL";
        assertEquals(expected,Solution.convert(input,numRows));
    }

}
