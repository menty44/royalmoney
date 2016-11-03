
package com.fred.uat;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class RMCancelTransaction {
	
	private static SOAPMessage createSoapRequest() throws Exception{
		
		 MessageFactory messageFactory = MessageFactory.newInstance();
		 SOAPMessage soapMessage = messageFactory.createMessage();
		 SOAPPart soapPart = soapMessage.getSOAPPart();
    	 SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
         soapEnvelope.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");
    	 soapEnvelope.addNamespaceDeclaration("end", "http://www.w3.org/TR/html4/");
    	 //soapEnvelope.addNamespaceDeclaration("xmlns", "http://www.w3.org/TR/html4/");
                 
         //SOAPMessage message = factory.createMessage();
         //SOAPHeader header = soapMessage.getSOAPHeader();
         MimeHeaders headers = soapMessage.getMimeHeaders();
         headers.addHeader("SOAPAction", "http://tempuri.org/RMCancelTransaction");
         //headers.getAllHeaders();    	         
    	      
    	 // remove all header information from envelope
    	 soapEnvelope.getHeader();
    	 //.detachNode();
    	         
		 SOAPBody soapBody = soapEnvelope.getBody();	    
		 //String Name = "RMGetExchangeRates";
		 
		 SOAPElement soapElement1 = soapBody.addChildElement("RMCancelTransaction");
         //SOAPElement soapElement1 = soapBody.addBodyElement(Name);
		 SOAPElement soapElement = soapElement1.addChildElement("CanslTrnReq");
		 
		 SOAPElement soapElement3 = soapElement.addChildElement("Credentials");
		 
		 
		 SOAPElement element1 = soapElement3.addChildElement("LoginCode");
		 element1.addTextNode("RMTTest4");
		 
		 SOAPElement element2 = soapElement3.addChildElement("AgentCode");
		 element2.addTextNode("ILT");
		 
		 SOAPElement element3 = soapElement3.addChildElement("UserCode");
		 element3.addTextNode("ILT");
		 
		 SOAPElement element4 = soapElement3.addChildElement("Password");
		 element4.addTextNode("Welcome@252");
		 
		 SOAPElement element6 = soapElement.addChildElement("PartnerTransactionNo");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element7 = soapElement.addChildElement("Remark");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element8 = soapElement.addChildElement("ProductID");
		 element8.addTextNode("1");
		 
		 
		 soapMessage.saveChanges();
		 System.out.println("----------SOAP Request------------");
		 soapMessage.writeTo(System.out);
		 return soapMessage;
	 }
	
	 private static void createSoapResponse(SOAPMessage soapResponse) throws Exception  {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.println("");
        System.out.println("");
		System.out.println("\n----------SOAP Response-----------");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
		
		System.out.println(" ****  **** ");
		
		// Get reply content		
		String resp1  = soapResponse.getSOAPPart().getElementsByTagName("PartnerTransactionNo").item(0).getFirstChild().getNodeValue();
		String resp2  = soapResponse.getSOAPPart().getElementsByTagName("status").item(0).getFirstChild().getNodeValue(); 
		String resp3  = soapResponse.getSOAPPart().getElementsByTagName("Message").item(0).getFirstChild().getNodeValue();
		
		System.out.println("PartnerTransactionNo              ::::  " + resp1);
		System.out.println("status               ::::  " + resp2);
		System.out.println("Message           ::::  " + resp3);

		
		
		System.out.println(" ****  **** ");
	 }
	 
	 public static void main(String args[]){
		 
		 try{
			 
			 SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			 SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			 //String url = "https://www.royalexchange.co.in:460/RoyalMoneyCashnBankServiceAsmx/RMService.asmx?WSDL";
			 String url = "https://www.royalexchange.co.in:460/RoyalMoneyCashnBankServiceAsmx/RMService.asmx";
			 SOAPMessage soapRequest = createSoapRequest();
			 //hit soapRequest to the server to get response
			 SOAPMessage soapResponse = soapConnection.call(soapRequest, url);
			 createSoapResponse(soapResponse);
			 soapConnection.close();
			 
			 }catch (Exception e) {
				 e.printStackTrace();
				 }
		 }
	 }






