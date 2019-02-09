package com.ag.load;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Read the File and load 
 * @author abhij
 *
 */
public class DelimitedFileLoader<T> {

	
	private String inputFile = null;

	public DelimitedFileLoader(String inputFile) {
		this.inputFile = inputFile;
	}
	

	public List<T> loadData(final Function<String, T> transform) throws  IOException {
		InputStream inputDataFileStream = DelimitedFileLoader.class.getClassLoader().getResourceAsStream(inputFile);

		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputDataFileStream))){
			// skip the header of the file
			return br.lines().skip(1).map(transform).collect(Collectors.toList());

		}

	}

}
