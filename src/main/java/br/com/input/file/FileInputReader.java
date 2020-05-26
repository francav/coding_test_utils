package br.com.input.file;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.input.api.InputReader;

public class FileInputReader implements InputReader {

	private File file;

	public FileInputReader(File file) {
		this.file = file;
	}

	@Override
	public String[] getRowsAsArray(int rowsCount) {
		assertNotNull(file);
		String[] array = new String[rowsCount];
		return getRowsAsList(rowsCount).toArray(array);
	}

	@Override
	public List<String> getRowsAsList(int rowsCount) {
		assertNotNull(file);

		List<String> rowsList = new ArrayList<String>();

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("aer"));
			String line = null;
			for (int i = 0; i < rowsCount; i++) {
				if ((line = in.readLine()) != null) {
					rowsList.add(line);
				}

			}
		} catch (IOException e) {
			throw new RuntimeException("File reading error");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException("File reading error");
			}
		}

		return rowsList;
	}

}
