package com.hackathon.model;

import javax.validation.constraints.NotNull;

/**
 * Reference for bean validation:
 * https://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
 * @author Trevor
 *
 */

import javax.validation.constraints.Size;

public class SearchModel
{
	@NotNull(message="Search cannot be left blank.")
	@Size(min=1, max=25, message="Search input must be between 1 and 25 characters.")
	private String search;

	public SearchModel()
	{
		this.search = "";
	}

	public SearchModel(String search) 
	{
		super();
		this.search = search;
	}

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
