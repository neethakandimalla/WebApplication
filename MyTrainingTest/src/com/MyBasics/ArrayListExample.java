package com.MyBasics;

import java.util.ArrayList;


public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("neetha");
		a.add("yerramada");
		for(int i=0;i<a.size();i++)
		{
		System.out.println(a.get(i));
		}
	

	}

}
