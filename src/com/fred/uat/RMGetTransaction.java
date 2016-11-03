
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

public class RMGetTransaction {
	
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
         headers.addHeader("SOAPAction", "http://tempuri.org/RMGetTransaction");
         //headers.getAllHeaders();    	         
    	      
    	 // remove all header information from envelope
    	 soapEnvelope.getHeader();
    	 //.detachNode();
    	         
		 SOAPBody soapBody = soapEnvelope.getBody();	    
		 //String Name = "RMGetExchangeRates";
		 
		 SOAPElement soapElement1 = soapBody.addChildElement("RMGetTransaction");
         //SOAPElement soapElement1 = soapBody.addBodyElement(Name);
		 SOAPElement soapElement = soapElement1.addChildElement("GetTrnReQ");
		 
		 SOAPElement soapElement3 = soapElement.addChildElement("Credentials");
		 
		 
		 SOAPElement element1 = soapElement3.addChildElement("LoginCode");
		 element1.addTextNode("RMTTest4");
		 
		 SOAPElement element2 = soapElement3.addChildElement("AgentCode");
		 element2.addTextNode("ILT");
		 
		 SOAPElement element3 = soapElement3.addChildElement("UserCode");
		 element3.addTextNode("ILT18745");
		 
		 SOAPElement element4 = soapElement3.addChildElement("Password");
		 element4.addTextNode("Welcome@252");
		 
		 SOAPElement element5 = soapElement.addChildElement("PartnerTransactionNo");
		 element5.addTextNode("ILT");
		 
//		 SOAPElement element6 = soapElement.addChildElement("DestinationCurrency");
//		 element6.addTextNode("INR");
//		 
//		 SOAPElement element7 = soapElement.addChildElement("SourceCurrency");
//		 element7.addTextNode("USD");		 
		 
		 
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
		String resp1  = soapResponse.getSOAPPart().getElementsByTagName("CustomerNo").item(0).getFirstChild().getNodeValue();
		String resp2  = soapResponse.getSOAPPart().getElementsByTagName("SenderDOB").item(0).getFirstChild().getNodeValue(); 
		String resp3  = soapResponse.getSOAPPart().getElementsByTagName("SenderDocType").item(0).getFirstChild().getNodeValue();
		String resp4  = soapResponse.getSOAPPart().getElementsByTagName("SenderDOCDateOfIssue").item(0).getFirstChild().getNodeValue();
		String resp5  = soapResponse.getSOAPPart().getElementsByTagName("SenderDOCDateOfExpiry").item(0).getFirstChild().getNodeValue();
		String resp6  = soapResponse.getSOAPPart().getElementsByTagName("ReceiverNo").item(0).getFirstChild().getNodeValue();
		String resp7  = soapResponse.getSOAPPart().getElementsByTagName("ReceiverDOB").item(0).getFirstChild().getNodeValue();
		String resp8  = soapResponse.getSOAPPart().getElementsByTagName("ReceiverDocType").item(0).getFirstChild().getNodeValue();
		String resp9  = soapResponse.getSOAPPart().getElementsByTagName("ReceiverDOCDateOfIssue").item(0).getFirstChild().getNodeValue();
		String resp10 = soapResponse.getSOAPPart().getElementsByTagName("ReceiverDOCDateOfExpiry").item(0).getFirstChild().getNodeValue();
		String resp11 = soapResponse.getSOAPPart().getElementsByTagName("ProcessDateTime").item(0).getFirstChild().getNodeValue();
		String resp12 = soapResponse.getSOAPPart().getElementsByTagName("ProductId").item(0).getFirstChild().getNodeValue();
		String resp13 = soapResponse.getSOAPPart().getElementsByTagName("LocalAmount").item(0).getFirstChild().getNodeValue();
		String resp14 = soapResponse.getSOAPPart().getElementsByTagName("PayoutAmount").item(0).getFirstChild().getNodeValue();
		String resp15 = soapResponse.getSOAPPart().getElementsByTagName("PayoutAgentID").item(0).getFirstChild().getNodeValue();
		String resp16 = soapResponse.getSOAPPart().getElementsByTagName("SenderFirstName").item(0).getFirstChild().getNodeValue();
		
		System.out.println("CustomerNo              ::::  " + resp1);
		System.out.println("SenderDOB               ::::  " + resp2);
		System.out.println("SenderDocType           ::::  " + resp3);
		System.out.println("SenderDOCDateOfIssue    ::::  " + resp4);
		System.out.println("SenderDOCDateOfExpiry   ::::  " + resp5);
		System.out.println("ReceiverNo              ::::  " + resp6);
		System.out.println("ReceiverDOB             ::::  " + resp7);
		System.out.println("ReceiverDocType         ::::  " + resp8);
		System.out.println("ReceiverDOCDateOfIssue  ::::  " + resp9);
		System.out.println("ReceiverDOCDateOfExpiry ::::  " + resp10);
		System.out.println("ProcessDateTime         ::::  " + resp11);
		System.out.println("ProductId               ::::  " + resp12);
		System.out.println("LocalAmount             ::::  " + resp13);
		System.out.println("PayoutAmount            ::::  " + resp14);
		System.out.println("PayoutAgentID           ::::  " + resp15);
		System.out.println("SenderFirstName                    ::::  " + resp16);
		
		
		System.out.println(" ****  **** ");
	 }
	 
	 public static void main(String args[]){
		 
		 try{
			 
			 SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			 SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			 String url = "https://www.royalexchange.co.in:460/RoyalMoneyCashnBankServiceAsmx/RMService.asmx?WSDL";
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






