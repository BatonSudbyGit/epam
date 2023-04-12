package json.xml.main;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface BuilderFactory <Gift extends BaseDataObject> {
    Builder<Gift> create(BuilderType builderType) throws ParserConfigurationException, IOException, SAXException, TransformerException, JAXBException;
}
