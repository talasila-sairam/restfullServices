package com.abstractprograming.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Path;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.abstractprograming.dto.NewPackage;

@Path("xmltourmanager")
public class XMLTourManager extends TourManager {

	public XMLTourManager() {
		System.out.println("XMLTourManager Constructor");
	}
	@Override
	public NewPackage readAndConvert(InputStream in) {
		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		Document document = null;
		NewPackage newPackage = null;
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(in);
			NodeList nodeList = document.getFirstChild().getChildNodes();
			newPackage = new NewPackage();
			for(int i = 0;i<nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				String nodeName = node.getNodeName();
				String nodeValue = node.getTextContent();
				if(nodeName.equalsIgnoreCase("name")) {
					newPackage.setName(nodeValue);
				}else if(nodeName.equalsIgnoreCase("mobile")) {
					newPackage.setMobile(nodeValue);
				}else if(nodeName.equalsIgnoreCase("packageName")) {
					newPackage.setPackageName(nodeValue);
				}else if(nodeName.equalsIgnoreCase(" ")) {
					newPackage.setReason(nodeValue);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newPackage;
	}

}
