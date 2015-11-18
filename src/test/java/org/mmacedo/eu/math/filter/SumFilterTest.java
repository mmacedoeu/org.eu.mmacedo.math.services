package org.mmacedo.eu.math.filter;

import java.util.ArrayList;
import java.util.Arrays;

import org.eu.mmacedo.math.filter.SumFilter;
import org.junit.Test;
import static org.junit.Assert.*;

public class SumFilterTest {

	@Test
	public final void testCall1() {
		assertTrue (SumFilter.call(Arrays.<Integer>asList(1, 2, 3), 6));
	}
	
	@Test
	public final void testCall2() {
		assertTrue (SumFilter.call(Arrays.<Integer>asList(6), 6));
	}	
	
	@Test
	public final void testCall3() {
		assertFalse(SumFilter.call(new ArrayList<Integer>(), 6));
	}	

}
