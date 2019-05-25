package board.api;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import board.api.dto.NonPaymentCodeDto;
import board.api.dto.NonPaymentHospDto;
import board.api.impl.UrlConnecntionXmlHandler;


public class NonPaymentDamtInfo {
	
    public static List<NonPaymentCodeDto> xmlCodeDataParsing () throws Exception{
    	
    	XmlHandler handler = new UrlConnecntionXmlHandler();
    	String xmlData = handler.getCodeXml();
    	//System.out.println("?????????????????????????????????????");
    	List<NonPaymentCodeDto> dtoList = new ArrayList<NonPaymentCodeDto>();
    	
    	InputSource is = new InputSource(new StringReader(xmlData));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xpath = XPathFactory.newInstance().newXPath(); // xpath 생성
       
        NodeList items = (NodeList) xpath.evaluate("//response/body/items/item", document, XPathConstants.NODESET);
        
        for(int i=0; i< items.getLength(); i++) {
        	Node node = items.item(i);
        	if(node.getNodeType() == Node.ELEMENT_NODE){
        		NonPaymentCodeDto dto = new NonPaymentCodeDto();
//        		System.out.println("node name: " + nodeName);
        		NodeList itemNode = node.getChildNodes();
        		for(int j=0; j<itemNode.getLength(); j++) {
        			Node itemChildNode = itemNode.item(j);
//        			System.out.println("itemChileNode Name : "+ itemChildNode);
        			switch (itemChildNode.getNodeName()) {
						case "divCd1":
							//System.out.println("divCd1 : "+ itemChildNode.getTextContent());
							dto.setDivCd1(itemChildNode.getTextContent());
							break;
						case "divCd1Dsc":
							//System.out.println("divCd1Dsc : "+ itemChildNode.getTextContent());
							dto.setDivCd1Dsc(itemChildNode.getTextContent());
							break;
						case "divCd1Nm":
							//System.out.println("divCd1Nm : "+ itemChildNode.getTextContent());
							dto.setDivCd1Nm(itemChildNode.getTextContent());
							break;
						case "divCd2":
							//System.out.println("divCd2 : "+ itemChildNode.getTextContent());
							dto.setDivCd2(itemChildNode.getTextContent());
							break;
						case "divCd2Dsc":
							//System.out.println("divCd2Dsc : "+ itemChildNode.getTextContent());
							dto.setDivCd2Dsc(itemChildNode.getTextContent());
							break;
						case "divCd3":
							//System.out.println("divCd2Nm : "+ itemChildNode.getTextContent());
							dto.setDivCd3(itemChildNode.getTextContent());
							break;
						case "divCd3Nm":
							//System.out.println("divCd2Nm : "+ itemChildNode.getTextContent());
							dto.setDivCd3Nm(itemChildNode.getTextContent());
							break;
						case "divCd3Dsc":
							//System.out.println("divCd2Nm : "+ itemChildNode.getTextContent());
							dto.setDivCd3Dsc(itemChildNode.getTextContent());
							break;
						case "divCd2Nm":
							//System.out.println("divCd2Nm : "+ itemChildNode.getTextContent());
							dto.setDivCd2Nm(itemChildNode.getTextContent());
							break;
						default:
							break;
					}
        		}
        		//System.out.println(dto);
        		dtoList.add(i, dto);
        	}
        }
        //System.out.println(dtoList);
        return dtoList;
    }
    
    
    public static void xmlHospDataParsing () throws Exception {
    	XmlHandler handler = new UrlConnecntionXmlHandler();
    	String xmlData = handler.getCodeXml();
    	List<NonPaymentHospDto> dtoList = new ArrayList<NonPaymentHospDto>();
    	
    	InputSource is = new InputSource(new StringReader(xmlData));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xpath = XPathFactory.newInstance().newXPath(); // xpath 생성
       
        NodeList items = (NodeList) xpath.evaluate("//response/body/items/item", document, XPathConstants.NODESET);
        

        for(int i=0; i< items.getLength() ; i++) {
        	Node node = items.item(i);
        	
        	if(node.getNodeType() == Node.ELEMENT_NODE) {
        		NodeList itemNode = node.getChildNodes();
        		for(int j=0; j<itemNode.getLength(); j++) {
        			Node itemChildNode = itemNode.item(j);
        			switch (itemChildNode.getNodeName()) {
	        			case "clCd":
	        				System.out.println("clCd : "+ itemChildNode.getTextContent());
	        				break;
						case "divCd1":
							System.out.println("divCd1 : "+ itemChildNode.getTextContent());
							break;
						case "divCd1Nm":
							System.out.println("divCd1Nm : "+ itemChildNode.getTextContent());
							break;
						case "divCd2":
							System.out.println("divCd2 : "+ itemChildNode.getTextContent());
							break;
						case "divCd2Nm":
							System.out.println("divCd2Nm : "+ itemChildNode.getTextContent());
							break;
						case "divCd3":
							System.out.println("divCd3 : "+ itemChildNode.getTextContent());
							break;
						case "divCd3Nm":
							System.out.println("divCd3Nm : "+ itemChildNode.getTextContent());
							break;
						case "invtDt":
							System.out.println("invtDt : "+ itemChildNode.getTextContent());
							break;
						case "itmCd":
							System.out.println("itmCd : "+ itemChildNode.getTextContent());
							break;
						case "itmCdNm":
							System.out.println("itmCdNm : "+ itemChildNode.getTextContent());
							break;
						case "itmPrcMax":
							System.out.println("itmPrcMax : "+ itemChildNode.getTextContent());
							break;
						case "itmPrcMin":
							System.out.println("itmPrcMin : "+ itemChildNode.getTextContent());
							break;
						case "prcMax":
							System.out.println("prcMax : "+ itemChildNode.getTextContent());
							break;
						case "prcMin":
							System.out.println("prcMin : "+ itemChildNode.getTextContent());
							break;										
						case "sgguCd":
							System.out.println("sgguCd : "+ itemChildNode.getTextContent());
							break;
						case "sgguCdNm":
							System.out.println("sgguCdNm : "+ itemChildNode.getTextContent());
							break;
						case "sidoCd":
							System.out.println("sidoCd : "+ itemChildNode.getTextContent());
							break;
						case "sidoCdNm":
							System.out.println("sidoCdNm : "+ itemChildNode.getTextContent());
							break;
						case "url":
							System.out.println("url : "+ itemChildNode.getTextContent());
							break;
						case "yadmNm":
							System.out.println("yadmNm : "+ itemChildNode.getTextContent());
							break;
						case "ykiho":
							System.out.println("ykiho : "+ itemChildNode.getTextContent());
							break;
						default:
							break;
						}
        			
        		}
        		
        	}
        }
        
    	
    	
    }
}