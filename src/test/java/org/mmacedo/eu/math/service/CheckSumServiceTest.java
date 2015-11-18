package org.mmacedo.eu.math.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eu.mmacedo.math.service.CheckSumService;
import org.junit.Test;

public class CheckSumServiceTest {

	@Test
	public final void testCall1() {
		final Collection<LinkedList<Integer>> call = CheckSumService.call(Arrays.<Integer>asList(1, 2, 3, 4, 6), 6);
		System.out.println(call);
		assertNotNull(call);
		assertTrue(call.size() == 3);
	}
	
	@Test
	public final void testCall2() {
		final Collection<LinkedList<Integer>> call = CheckSumService.call(Arrays.<Integer>asList(1, 2, 2, 3, 4), 8);
		System.out.println(call);
		assertNotNull(call);
		assertTrue(call.size() == 3);
	}	
	
	@Test
	public final void testCall3() {
		final Collection<LinkedList<Integer>> call = CheckSumService.call(Arrays.<Integer>asList(-1, 2, 2, 4, 3, 9), 8);
		System.out.println(call);
		assertNotNull(call);
		assertTrue(call.size() == 4);
	}		

}
