package org.eu.mmacedo.math.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eu.mmacedo.math.domain.Graph;
import org.springframework.core.convert.converter.Converter;

/**
 * Converte uma requisição no padrão:
 * inicio;fim;no1>path1,path2,...;no2>path1,path2,...
 * 
 * @author macedo
 *
 */
public class StringGraphSearchConverter implements Converter<String, List<Object>> {

	public Map<String, List<String>> convertPath(final String source) {
		Map<String, List<String>> result = new HashMap<>();
		final String[] split = source.split(">");
		final String[] split2 = split[1].split(",");
		final List<String> asList = Arrays.<String> asList(split2);
		result.put(split[0].trim(), asList);

		return result;
	}

	@Override
	public List<Object> convert(String source) {
		final String[] split = source.split(";");
		Object[] result = new Object[3];
		result[0] = split[0].trim();
		result[1] = split[1].trim();

		Graph graph = new Graph();
		for (int i = 2; i < split.length; i++) {
			graph.addEdge(convertPath(split[i]));
		}
		result[2] = graph;

		return Arrays.<Object> asList(result);
	}

}
