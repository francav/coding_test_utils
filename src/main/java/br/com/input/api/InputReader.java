package br.com.input.api;

import java.util.List;

public interface InputReader {

	public String[] getRowsAsArray(int rowsCount);

	public List<String> getRowsAsList(int rowsCount);

}
