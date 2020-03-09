package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;

import co.cask.cdap.api.annotation.ProcessInput;
import co.cask.cdap.api.common.Bytes;
import co.cask.cdap.api.flow.flowlet.AbstractFlowlet;
import co.cask.cdap.api.flow.flowlet.FlowletContext;
import co.cask.cdap.api.flow.flowlet.StreamEvent;

public class RawToTextFlowlet extends AbstractFlowlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(RawToTextFlowlet.class);
	
	private LicenseAsposeUtils asposeUtils;
	
	@Override
	public void initialize(FlowletContext context) throws Exception {
		super.initialize(context);
		asposeUtils = new LicenseAsposeUtils();
		try {
			asposeUtils.setUnlimitedLicense();
		} catch (Exception e) {
			LOG.error("Aspose Licence not recognized");
		}
	}
	
	@ProcessInput(maxRetries = 2)
	public void process(StreamEvent event) {
		
		String path = Bytes.toString(event.getBody());
		LOG.info("Path received: " + path);
		
		Document pdfDocument = new Document(path);
		TextExtractionOptions options = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure);
		TextAbsorber absorber = new TextAbsorber(options);
		pdfDocument.getPages().accept(absorber);
		LOG.info(absorber.getText());
		
		pdfDocument.freeMemory();
		pdfDocument.dispose();
		pdfDocument.close();
		
	}
	

}
