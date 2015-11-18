package org.eu.mmacedo.math.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eu.mmacedo.math.filter.SumFilter;

/**
 * Gera todas as combinações de todas as somas das parcelas e filtra aquelas em
 * que a soma é igual ao valor alvo pretendido
 * 
 * @author macedo
 * 
 */
public class CheckSumService {
	public static Collection<LinkedList<Integer>> call(List<Integer> A, Integer sum) {

		// Utilizamos o pacote stream do Java 8 para fazer uso do processador multicore e filtrar em paralelo
		return PartitionGenerator.call(A).parallelStream().filter(p -> SumFilter.call(p, sum))
				.collect(Collectors.toList());

	}
	
	public Collection<LinkedList<Integer>> call(List<Integer> params) {
		Integer total = params.get(0);
		params.remove(0);
		return CheckSumService.call(params, total);		
	}
}
