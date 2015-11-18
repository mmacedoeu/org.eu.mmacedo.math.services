package org.eu.mmacedo.math.filter;

import java.util.Collection;

/**
 * Filtro que soma todas as parcelas em uma coleção e compara se igual a um
 * parametro passado como totalizador
 * 
 * @author macedo
 *
 */
public class SumFilter {
	public static Boolean call(Collection<Integer> param, Integer total) {
		if (param == null || param.isEmpty())
			return false;
		
		// Utilizamos o pacote stream do Java 8 para implementar map reduce e fazer uso do processador multicore
		// Para uma quantidade pequena de parcelas o pattern fork/join utilizado pelo pacote stream tem um overhead considerável
		int sum = param.parallelStream().mapToInt(Integer::intValue).sum();
		//int sum = param.stream().mapToInt(Integer::intValue).sum();
		return total == sum;
	}
}
