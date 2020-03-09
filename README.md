Simple CDAP app that converts pdfs ingested using a stream, and logs the respective plaintext, using Aspose-pdf library

NOTE: before building, place a valid licence with name "Aspose.Total.Java.lic" in src/main/resources

1) Build the app using: mvn clean package
2) Deploy the app in CDAP
4) Start the ProcessingFlow
3) Using de UI, double click the filePath and ingest a pdf absolute path (ex: C:\Users\uC210737\Testing\TJSP-20140408-2057885-84.2013.8.26.0000.pdf)