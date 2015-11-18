package org.mmacedo.eu.math.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eu.mmacedo.math.converter.StringCheckSumConverter;
import org.junit.Test;

public class StringCheckSumConverterTest {
	@Test
	public final void testConvert() {
		final StringCheckSumConverter stringCheckSumConverter = new StringCheckSumConverter();
		String input = "8;-1,2,2,4,3,9";	
		final List<Integer> convert = stringCheckSumConverter.convert(input);
		assertNotNull(convert);
		assertTrue(convert.size() == 7);
		assertTrue(convert.get(0) == 8);		
		
	}
}
