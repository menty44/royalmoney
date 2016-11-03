
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

public class RMSendTransaction {
	
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
		 
		 SOAPElement soapElement1 = soapBody.addChildElement("RMSendTransaction");
         //SOAPElement soapElement1 = soapBody.addBodyElement(Name);
		 SOAPElement soapElement = soapElement1.addChildElement("RemReQ");
		 
		 SOAPElement soapElement3 = soapElement.addChildElement("Credentials");
		 SOAPElement soapElement4 = soapElement.addChildElement("CBCR");
		 SOAPElement soapElement5 = soapElement.addChildElement("Credentials");
		 
		 
		 
		 SOAPElement element1 = soapElement3.addChildElement("LoginCode");
		 element1.addTextNode("RMTTest4");
		 
		 SOAPElement element2 = soapElement3.addChildElement("AgentCode");
		 element2.addTextNode("ILT");
		 
		 SOAPElement element3 = soapElement3.addChildElement("UserCode");
		 element3.addTextNode("ILT18745");
		 
		 SOAPElement element4 = soapElement3.addChildElement("Password");
		 element4.addTextNode("Welcome@252");
		 
		 SOAPElement element5 = soapElement5.addChildElement("LoginCode");
		 element1.addTextNode("RMTTest4");
		 
		 SOAPElement element6 = soapElement5.addChildElement("AgentCode");
		 element2.addTextNode("ILT");
		 
		 SOAPElement element7 = soapElement5.addChildElement("UserCode");
		 element3.addTextNode("ILT18745");
		 
		 SOAPElement element8 = soapElement5.addChildElement("Password");
		 element4.addTextNode("Welcome@252");
		 
		 SOAPElement element9 = soapElement1.addChildElement("CustomerNo");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element10 = soapElement.addChildElement("SenderFirstName");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element11 = soapElement.addChildElement("SenderLastName");
		 element8.addTextNode("1");
		 
		 SOAPElement element12 = soapElement1.addChildElement("SenderDOB");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element13 = soapElement.addChildElement("SenderGender");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element14 = soapElement.addChildElement("SenderAddress");
		 element8.addTextNode("1");
		 
		 SOAPElement element15 = soapElement1.addChildElement("SenderPostorZipCode");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element16 = soapElement.addChildElement("SenderStateorCounty");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element17 = soapElement.addChildElement("SenderCountryCode");
		 element8.addTextNode("1");
		 
		 SOAPElement element18 = soapElement1.addChildElement("SenderTelephone");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element19 = soapElement.addChildElement("SenderDocType");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element20 = soapElement.addChildElement("SenderDOC");
		 element8.addTextNode("1");
		 
		 SOAPElement element21 = soapElement1.addChildElement("SenderDOCDateOfIssue");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element22 = soapElement.addChildElement("SenderDOCDateOfExpiry");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element23 = soapElement.addChildElement("SenderDOCCountryOfIssue");
		 element8.addTextNode("1");
		 
		 SOAPElement element24 = soapElement1.addChildElement("SenderPlaceOfBirth");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element25 = soapElement.addChildElement("SenderOccupation");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element26 = soapElement.addChildElement("SenderSocialSecurityNo");
		 element8.addTextNode("1");
		 
		 SOAPElement element27 = soapElement1.addChildElement("SenderStateOfIssue");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element28 = soapElement.addChildElement("SenderNationality");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element29 = soapElement.addChildElement("ReceiverNo");
		 element8.addTextNode("1");
		 
		 SOAPElement element30 = soapElement1.addChildElement("ReceiverFirstName");
		 element6.addTextNode("ILT");
		 
		 SOAPElement element31 = soapElement.addChildElement("ReceiverLastName");
		 element7.addTextNode("cancel by fred");
		 
		 SOAPElement element32 = soapElement.addChildElement("ReceiverDOB");
		 element8.addTextNode("1");
		 
		 SOAPElement element33 = soapElement.addChildElement("ReceiverGender");
		 element8.addTextNode("1");
		 
		 SOAPElement element34 = soapElement.addChildElement("ReceiverAddress");
		 element8.addTextNode("1");
		 
		 SOAPElement element35 = soapElement.addChildElement("ReceiverPostorZipCode");
		 element8.addTextNode("1");
		 
		 SOAPElement element36 = soapElement.addChildElement("ReceiverStateorCounty");
		 element8.addTextNode("1");
		 
		 SOAPElement element37 = soapElement.addChildElement("ReceiverCountryCode");
		 element8.addTextNode("1");
		 
		 SOAPElement element38 = soapElement.addChildElement("ReceiverTelephone");
		 element8.addTextNode("1");
		 
		 SOAPElement element39 = soapElement.addChildElement("ReceiverEmail");
		 element8.addTextNode("1");
		 
		 SOAPElement element40 = soapElement.addChildElement("ReceiverDocType");
		 element8.addTextNode("1");
		 
		 SOAPElement element41 = soapElement.addChildElement("ReceiverDOC");
		 element8.addTextNode("1");
		 
		 SOAPElement element42 = soapElement.addChildElement("ReceiverDOCDateOfIssue");
		 element8.addTextNode("1");
		 
		 SOAPElement element43 = soapElement.addChildElement("ReceiverDOCDateOfExpiry");
		 element8.addTextNode("1");
		 
		 SOAPElement element44 = soapElement.addChildElement("ReceiverDOCCountryOfIssue");
		 element8.addTextNode("1");
		 
		 SOAPElement element45 = soapElement.addChildElement("ReceiverPlaceOfBirth");
		 element8.addTextNode("1");
		 
		 SOAPElement element46 = soapElement.addChildElement("TestQuestion");
		 element8.addTextNode("1");
		 
		 SOAPElement element47 = soapElement.addChildElement("TestAnswer");
		 element8.addTextNode("1");
		 
		 SOAPElement element48 = soapElement.addChildElement("ReasonForPayment");
		 element8.addTextNode("1");
		 
		 SOAPElement element49 = soapElement.addChildElement("SourceOfFund");
		 element8.addTextNode("1");
		 
		 SOAPElement element50 = soapElement.addChildElement("BankAccount");
		 element8.addTextNode("1");
		 
		 SOAPElement element51 = soapElement.addChildElement("Bank");
		 element8.addTextNode("1");
		 
		 SOAPElement element52 = soapElement.addChildElement("LocalBankCode");
		 element8.addTextNode("1");		 
		 
		 SOAPElement element53 = soapElement.addChildElement("BankBranch");
		 element8.addTextNode("1");
		 
		 SOAPElement element54 = soapElement.addChildElement("BankAddress");
		 element8.addTextNode("1");
		 
		 SOAPElement element55 = soapElement.addChildElement("BankCity");
		 element8.addTextNode("1");
		 
		 SOAPElement element56 = soapElement.addChildElement("IBAN");
		 element8.addTextNode("1");
		 
		 SOAPElement element57 = soapElement.addChildElement("BankState");
		 element8.addTextNode("1");
		 
		 SOAPElement element58 = soapElement.addChildElement("BankCountry");
		 element8.addTextNode("1");		 
		 
		 SOAPElement element59 = soapElement.addChildElement("CPFNumber");
		 element8.addTextNode("1");
		 
		 SOAPElement element60 = soapElement.addChildElement("BankAccountType");
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






