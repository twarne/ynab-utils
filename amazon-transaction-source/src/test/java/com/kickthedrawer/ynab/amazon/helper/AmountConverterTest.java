package com.kickthedrawer.ynab.amazon.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.java.Log;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

@Log
public class AmountConverterTest {

    private AmountConverter instance;

    @BeforeEach
    public void init() {
        instance = new AmountConverter();
    }

    @Test
    public void testBasicConversion() throws Exception {
        float value = (Float)instance.convert("$22.00");
        assertEquals(22.0f, value, "Expected value not found");
    }

    @Test
    public void testBlankConversion() throws Exception {
        float value = (Float)instance.convert("");
        assertEquals(0.0f, value, "Expected value not found");
    }
    
}
