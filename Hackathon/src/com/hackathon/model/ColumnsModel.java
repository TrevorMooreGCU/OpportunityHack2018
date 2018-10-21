package com.hackathon.model;

import java.util.ArrayList;

public class ColumnsModel 
{
    private ArrayList<String> strings;
 
    public ColumnsModel() {
    }
 
    public ColumnsModel(ArrayList<String> strings) {
        this.strings = strings;
    }

	public ArrayList<String> getStrings() {
		return strings;
	}

	public void setStrings(ArrayList<String> strings) {
		this.strings = strings;
	}
	
	public void addString(String string)
	{
		this.strings.add(string);
	}


}
