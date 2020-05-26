package br.com.input.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.com.input.api.InputReader;

public class FileInputReaderTest {

	@Test
	public void testGetRows_emptyFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test_file_empty.txt").getFile());
		InputReader fileInputReader = new FileInputReader(file);

		assertTrue(fileInputReader.getRowsAsArray(0).length == 0);
	}

	@Test
	public void testGetRowsAsArray_twoRows() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test_file_twoRows.txt").getFile());

		InputReader fileInputReader = new FileInputReader(file);

		String[] expetedRows = { "row1", "row2" };

		String[] s = fileInputReader.getRowsAsArray(2);
		Arrays.asList(s).forEach((o) -> System.out.println(o));

		Assert.assertArrayEquals(expetedRows, fileInputReader.getRowsAsArray(2));
	}

}
