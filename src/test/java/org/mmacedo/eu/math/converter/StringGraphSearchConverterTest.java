package org.mmacedo.eu.math.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eu.mmacedo.math.converter.StringGraphSearchConverter;
import org.eu.mmacedo.math.domain.Graph;
import org.junit.Test;

public class StringGraphSearchConverterTest {

	@Test
	public final void testConvert() {
		final StringGraphSearchConverter stringGraphSearchConverter = new StringGraphSearchConverter();
		String input = "1;4;1>2,3;2>4;3>5";
		final List<Object> convert = stringGraphSearchConverter.convert(input);
		assertNotNull(convert);
		assertTrue(convert.size() > 0);
		assertTrue("1".equals(convert.get(0)));
		assertTrue("4".equals(convert.get(1)));
		assertTrue(convert.get(2) != null && convert.get(2) instanceof Graph);		
	}

}
