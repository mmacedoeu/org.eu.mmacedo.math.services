package org.mmacedo.eu.math.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eu.mmacedo.math.service.PartitionGenerator;
import org.junit.Test;

public class PartitionGeneratorTest {

	@Test
	public final void testCall() {
		Integer[] testsequence = {1,2,3,4,6};
		Collection<LinkedList<Integer>> call = PartitionGenerator.call(Arrays.<Integer>asList(testsequence));
		call.stream().forEach(System.out::println);
		assertTrue(call.size() == 32);
	}

}
