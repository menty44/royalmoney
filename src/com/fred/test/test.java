package com.fred.test;

import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConnection;

import java.security.MessageDigest;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
// add this import if you need soapaction
import javax.xml.soap.MimeHeaders;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Source;

import javax.xml.transform.stream.StreamResult;

public class test {

  public static void main(String[] args) {

    try {
    	
    	String LoginCode = "RMTTest4";
        String AgentCode = "ILT";
        String UserCode = "ILT";
        String Password = "Welcome@252";
        String PartnerTransactionNo = "225";
        String Remark = "testin gcancel";
        String ProductID = "1";
        String Credentials = null;
        
        // Create the connection
		SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
		SOAPConnection conn = scf.createConnection();
				
		// Create message
		MessageFactory mf = MessageFactory.newInstance();
		SOAPMessage msg = mf.createMessage();

        // Add eventually a SoapAction header if necessary
        /*
        MimeHeaders hd = msg.getMimeHeaders();
        hd.addHeader("SOAPAction", "urn:yoursoapaction");
        */
		
		MimeHeaders headers = msg.getMimeHeaders();
        headers.addHeader("SOAPAction", "http://tempuri.org/RMCancelTransaction");

		// Object for message parts
		SOAPPart sp = msg.getSOAPPart();
	
		SOAPEnvelope env = sp.getEnvelope();
		env.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
		env.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");
		env.addNamespaceDeclaration("enc","http://schemas.xmlsoap.org/soap/encoding/");
		env.addNamespaceDeclaration("env","http://schemas.xmlsoap.org/soap/envelop/");
		env.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
	
		SOAPBody bd = env.getBody();
		
		// Populate body
		// Main element and namespace
		SOAPElement be = bd.addChildElement(env.createName("RMCancelTransaction")); 
		SOAPElement be1 = bd.addChildElement(env.createName("CanslTrnReq"));
		
		// namespace to use for my rpc/encoded wsdl version is:
	    	
		// Add content
		be.addChildElement("Credentials").addTextNode(Credentials).setAttribute("xsi:type","xsd:string");
		be.addChildElement("LoginCode").addTextNode(LoginCode).setAttribute("xsi:type","xsd:string");
		be.addChildElement("AgentCode").addTextNode(AgentCode).setAttribute("xsi:type","xsd:string");
		be.addChildElement("UserCode").addTextNode(UserCode).setAttribute("xsi:type","xsd:string");
		be.addChildElement("Password").addTextNode(Password).setAttribute("xsi:type","xsd:string");
		be1.addChildElement("PartnerTransactionNo").addTextNode(PartnerTransactionNo).setAttribute("xsi:type","xsd:string");
		be1.addChildElement("Remark").addTextNode(Remark).setAttribute("xsi:type","xsd:string");
		be1.addChildElement("ProductID").addTextNode(ProductID).setAttribute("xsi:type","xsd:int");
	
		// Save message
		msg.saveChanges();
	
		// View input
		System.out.println("\n Soap XML request:\n");
		msg.writeTo(System.out);
		System.out.println();
	
		// Send
		String urlval = "https://www.royalexchange.co.in:460/RoyalMoneyCashnBankServiceAsmx/RMService.asmx";
	    // or /rcx-ws-rpc/rcx for my rpc/encoded web service
	
		SOAPMessage rp = conn.call(msg, urlval);

		// View the output
		System.out.println("\n XML response\n");
	
		// Create transformer
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
	
		// Get reply content
		Source sc = rp.getSOAPPart().getContent();
	
		// Set output transformation
		StreamResult result = new StreamResult(System.out);
		tf.transform(sc, result);
		System.out.println("");
		System.out.println("");
		System.out.println(" ****  **** ");
		
		String resp1 = rp.getSOAPPart().getElementsByTagName("PartnerTransactionNo").item(0).getFirstChild().getNodeValue();
		String resp2 = rp.getSOAPPart().getElementsByTagName("Status").item(0).getFirstChild().getNodeValue(); 
		String resp3 = rp.getSOAPPart().getElementsByTagName("Message").item(0).getFirstChild().getNodeValue();
				
		System.out.println("PartnerTransactionNo           ::::  " + resp1);
		System.out.println("Status  ::::  " + resp2);
		System.out.println("Message        ::::  " + resp3);
		
		
		System.out.println(" ****  **** ");
				
		// Close connection
		conn.close();
		
		}
    catch (Exception e){
	System.out.println(e.getMessage());
	}
    
    }
  
  }