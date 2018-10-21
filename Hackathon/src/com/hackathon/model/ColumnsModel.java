package com.hackathon.model;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ColumnsModel 
{
    private Queue<String> strings;
 
    public ColumnsModel() {
    	this.strings = new PriorityQueue<String>();
    }
 
    public ColumnsModel(Queue<String> strings) {
        this.strings = strings;
    }

	public Queue<String> getStrings() {
		return strings;
	}

	public void setStrings(Queue<String> strings) {
		this.strings = strings;
	}
	
	public void setString(String string)
	{
		this.strings.add(string);
	}
	public String getString()
	{
		return this.strings.poll();
	}


}
