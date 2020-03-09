package com.example;

import java.io.InputStream;

public class LicenseAsposeUtils {

	public void setUnlimitedLicense() throws Exception {
		setUnlimitedLicensePDF();
	}

	private void setUnlimitedLicensePDF() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		try (InputStream licenseFile = classLoader.getResource("Aspose.Total.Java.lic").openStream();){ 
			com.aspose.pdf.License licensepdf = new com.aspose.pdf.License();
			licensepdf.setLicense(licenseFile);
		}
	}

}
