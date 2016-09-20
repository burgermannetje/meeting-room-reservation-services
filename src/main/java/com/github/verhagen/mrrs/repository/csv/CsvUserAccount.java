package com.github.verhagen.mrrs.repository.csv;

import com.github.verhagen.mrrs.domain.UserAccount;

/**
 * Implementation based on <a href="http://csveed.org/">CSVeed</a>. 
 */
public class CsvUserAccount {
	private String id;
	private String name;


	public UserAccount createUserAccount() {
		return new UserAccount(id, name);
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
