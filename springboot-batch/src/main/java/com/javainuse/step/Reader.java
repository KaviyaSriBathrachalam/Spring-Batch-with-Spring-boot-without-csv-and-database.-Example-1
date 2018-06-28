//reader work









package com.javainuse.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

	private String[] messages = { "javainuse.com",                  // the file reads these set of strings
			"Welcome to Spring Batch Example",
			"We use H2 Database for this example" };

	private int count = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
				System.out.println("reader() in Reader.java");

		if (count < messages.length) {											//reading one by one
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}

}