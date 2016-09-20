package com.github.verhagen.mrrs.repository.csv;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import com.github.verhagen.mrrs.repository.UserAccountRepository;

public class CsvUserAccountRepositoryTest {

	@Test
	public void importByReader() throws Exception {
		UserAccountRepository roomRepo = CsvUserAccountRepository.importBy(createReader());

		assertEquals("Tintin", roomRepo.search("Tintin").getName());
		assertEquals("tintin", roomRepo.search("Tintin").getId());
		assertEquals("Professor Calculus", roomRepo.search("Professor Calculus").getName());
		assertEquals("calculus", roomRepo.search("Professor Calculus").getId());
	}

	private Reader createReader() {
		final StringBuilder bldr = new StringBuilder();
		bldr.append("id; name\n");
		bldr.append("tintin; Tintin\n");
		bldr.append("calculus; Professor Calculus\n");
		bldr.append("thomson; Thomson and Thompson\n");
		return new StringReader(bldr.toString());
	}

}
