package com.github.verhagen.mrrs.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.verhagen.mrrs.domain.UserAccount;

public class UserAccountRepositoryTest {

	@Test
	public void create() throws Exception {
		UserAccountRepository repo = new UserAccountRepository();
		repo.add(createUserAccount("tintin", "Tintin"));
		repo.add(createUserAccount("haddock", "Captain Haddock"));
//		repo.add(createUserAccount("calculus", "Professor Calculus"));
//		repo.add(createUserAccount("thomson", "Thomson and Thompson"));

		assertEquals(2, repo.size());
		UserAccount userAccount = repo.search("Tintin");
		assertEquals(userAccount.getName(), "Tintin");
	}


	private UserAccount createUserAccount(final String id, final String name) {
		return new UserAccount(id, name);
	}

}
