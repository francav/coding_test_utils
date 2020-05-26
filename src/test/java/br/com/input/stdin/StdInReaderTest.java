package br.com.input.stdin;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.input.api.InputReader;
import br.com.input.sdtin.StdInReader;

public class StdInReaderTest {

	private static final String row1 = "row1 a b c";
	private static final String row2 = "row2 a b c";
	private static String rows;

	@BeforeClass
	public static void init() {
		StringBuilder sb = new StringBuilder();
		sb.append(row1 + "\n");
		sb.append(row2);

		rows = sb.toString();
	}

	@Test
	public void testGetRows_empty() {
		InputReader stdInReader = new StdInReader();
		assertTrue(stdInReader.getRowsAsArray(0).length == 0);
	}

	@Test
	public void testGetRowsAsArray_twoRows() {
		InputReader stdInReader = new StdInReader();

		InputStream inputStream = new ByteArrayInputStream(rows.getBytes());
		System.setIn(new BufferedInputStream(inputStream));

		String[] expetedRows = { row1, row2 };

		Assert.assertArrayEquals(expetedRows, stdInReader.getRowsAsArray(2));
	}

}
