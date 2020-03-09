package com.example;

import co.cask.cdap.api.flow.AbstractFlow;

public class ProcessingFlow extends AbstractFlow {

	@Override
	public void configure() {
		setName("ProcessingFlow");
		setDescription("A flow that receives pdf file paths and converts into plain text");
	    addFlowlet("rawToTextFlowlet", new RawToTextFlowlet());
	    connectStream("filePath", "rawToTextFlowlet");
	}

}
