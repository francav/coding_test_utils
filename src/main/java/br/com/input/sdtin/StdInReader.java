package br.com.input.sdtin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.input.api.InputReader;

public class StdInReader implements InputReader {

	public String[] getRowsAsArray(int rowsCount) {
		String[] array = new String[rowsCount];
		return getRowsAsList(rowsCount).toArray(array);
	}

	public List<String> getRowsAsList(int rowsCount) {

		List<String> rows = new ArrayList<String>();

		Scanner stdIn = new Scanner(System.in);

		for (int i = 0; i < rowsCount; i++) {
			if (stdIn.hasNextLine()) {
				rows.add(stdIn.nextLine());
			}
		}

		stdIn.close();

		return rows;

	}

}
