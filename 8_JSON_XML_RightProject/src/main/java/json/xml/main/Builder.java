package json.xml.main;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface Builder <Gift extends BaseDataObject> {

    Gift parse (String text) throws ParserConfigurationException, IOException, SAXException, JAXBException;

    String generate(Gift dataObject) throws ParserConfigurationException, TransformerException, IOException, JAXBException;
}