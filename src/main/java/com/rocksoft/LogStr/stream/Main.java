package com.rocksoft.LogStr.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		List<String> arrays = new ArrayList<String>();
		for(int i = 0; i < 100; i++) {
			arrays.add(UUID.randomUUID() + " ");
		}
		arrays.stream().parallel().filter(word -> word.startsWith("7")).forEach(System.out :: println);
	}

}
