package org.eu.mmacedo.math.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

/**
 * Converte requisição no padrão:
 * total;parcela1,parcela2,parcela3,...
 * @author macedo
 *
 */
public class StringCheckSumConverter implements Converter<String, List<Integer>>{

	@Override
	public List<Integer> convert(String source) {
		List<Integer> saida = new ArrayList<>();
		final String[] split = source.split(";");
		saida.add(Integer.parseInt(split[0]));
		final String[] split2 = split[1].split(",");
		for (String string : split2) {
			saida.add(Integer.parseInt(string));
		}
				
		return saida;
	}

}
