package com.github.verhagen.mrrs.repository.csv;

import java.io.Reader;
import java.util.List;

import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;

import com.github.verhagen.mrrs.repository.UserAccountRepository;

public class CsvUserAccountRepository extends UserAccountRepository {

	public static UserAccountRepository importBy(final Reader reader) {
		final CsvUserAccountRepository roomRepo = new CsvUserAccountRepository();
		final CsvClient<CsvUserAccount> csvReader = new CsvClientImpl<>(reader, CsvUserAccount.class);
		final List<CsvUserAccount> beans = csvReader.readBeans();
		
		for (CsvUserAccount bean : beans) {
			roomRepo.add(bean.createUserAccount());
		}
		
		return roomRepo;
	}

}
