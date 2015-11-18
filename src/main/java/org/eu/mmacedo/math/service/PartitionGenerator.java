package org.eu.mmacedo.math.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Da matematica sabemos que todas as combinações possiveis de N elementos é
 * igual a 2^N. Se usarmos a representação binaria de todas as possibilidades,
 * teremos que 1 ou 0 filtra se o elemento naquela posição faz parte daquele
 * set, se a coluna binaria j for 1 então o elemento na posição j faz parte da
 * combinação.
 * 
 * Uma solução mais escalável é usar do Actor model para passar via Message
 * Passing cada set gerado por um channel/queue/MQ onde um load balancer poderá
 * distribuir o processamento
 * 
 * 
 * @author macedo
 *
 */
public class PartitionGenerator {

	public static <T extends Comparable<? super T>> Collection<LinkedList<T>> call(List<T> A) {
		Collection<LinkedList<T>> ans = new LinkedList<LinkedList<T>>();
		//Para uma melhor solução substituir a Collection por um channel/queue/MQ
		
		int ansSize = (int) Math.pow(2, A.size());

		IntStream.range(0, ansSize).forEach(i -> { // TODO para operação em um
													// cluster os ranges podem
													// ser particionados
													// igualmente entre os nodes

			// for (int i = 0; i < ansSize; ++i) {
			String bin = Integer.toBinaryString(i); // Converte para binário
			while (bin.length() < A.size()) // Adiciona zeros a esquerda de
											// forma todos
											// terem N = A.size elementos
				bin = "0" + bin;
			LinkedList<T> thisComb = new LinkedList<T>();
			for (int j = 0; j < A.size(); ++j) {
				if (bin.charAt(j) == '1') // Se o elemento na posição j for 1
											// então o elemento na posição j
											// também faz parte da combinação
					thisComb.add(A.get(j));
			}
			// Collections.sort(thisComb);
			ans.add(thisComb);
		});
		return ans;
	}

}
