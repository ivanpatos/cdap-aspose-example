package com.example;

import co.cask.cdap.api.Config;
import co.cask.cdap.api.app.AbstractApplication;
import co.cask.cdap.api.data.stream.Stream;

public class MyApp <T extends Config> extends AbstractApplication<T> {
	
	@Override
	public void configure() {
		setName("MyApp");
		setDescription("A cdap app example that converts pdf into plain text using aspose library");
		addFlow(new ProcessingFlow());
		addStream(new Stream("filePath"));
	}
}
