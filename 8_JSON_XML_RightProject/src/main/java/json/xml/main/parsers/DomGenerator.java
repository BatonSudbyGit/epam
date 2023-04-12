package json.xml.main.parsers;

import json.xml.main.BaseDataObject;
import json.xml.main.Builder;
import json.xml.main.enums.GetGiftClass;
import json.xml.main.gift.Gift;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DomGenerator implements Builder {

    private static String getElementContent(Element element, String name) {
        Node item = element.getElementsByTagName(name).item(0);
        Element singleElement = (Element) item;
        return singleElement != null ? singleElement.getTextContent() : null;
    }

    private void addSubElement(Document document, Node targetNode, String newElementName, String value) {
        Element element = document.createElement(newElementName);
        element.setTextContent(value);
        targetNode.appendChild(element);
    }

    @Override
    public BaseDataObject parse(String nameFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document1 = builder.parse(nameFile);
        Element root = document1.getDocumentElement();
        Gift gift = new Gift();
        gift.setCandy(new ArrayList<>());
        NodeList nodes = root.getElementsByTagName("Candy");
        ArrayList<String> visPar = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Element candyElement = (Element) nodes.item(i);
            Gift.Candy candy = new Gift.Candy();
            candy.setName(getElementContent(candyElement, "Name"));
            candy.setProduction(getElementContent(candyElement, "Production"));
            NodeList subNodes = root.getElementsByTagName("Type_and_taste");
            Element visElement = (Element) subNodes.item(i);
            visPar.add(getElementContent(visElement, "Type"));
            visPar.add(getElementContent(visElement, "Taste"));
            candy.setTypeAndTaste(visPar);
            candy.setEnergy(Integer.parseInt(Objects.requireNonNull(getElementContent(candyElement, "Energy"))));
            candy.setCost(Integer.parseInt(Objects.requireNonNull(getElementContent(candyElement, "Cost"))));
            candy.setBuyTime(LocalDateTime.parse
                    (Objects.requireNonNull(getElementContent(candyElement, "Time_of_Manufacture"))));
            gift.getCandy().add(candy);
            System.out.println(candy);
            visPar.clear();
        }
        return gift;
    }

    @Override
    public String generate(BaseDataObject dataObject) throws ParserConfigurationException, TransformerException, IOException {
        Gift.Candy candy = new Gift.Candy("candy", "prod", List.of("list"), 1, 1);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element elementDom = document.createElement("Gift");
        document.appendChild(elementDom);

        Element moduleElement = document.createElement("Candy");
        elementDom.appendChild(moduleElement);
        addSubElement(document,moduleElement, "Name", candy.getName());
        addSubElement(document,moduleElement, "Production", candy.getProduction());
        Element visPar = document.createElement("Type_and_taste");
        List<String> list = candy.getTypeAndTaste();
        moduleElement.appendChild(visPar);
        addSubElement(document, visPar, "Type", candy.getTypeAndTaste().get(0));
        addSubElement(document, visPar, "Taste", candy.getTypeAndTaste().get(1));
        addSubElement(document, moduleElement, "Energy", Integer.toString(candy.getEnergy()));
        addSubElement(document, moduleElement, "Cost", Integer.toString(candy.getCost()));
        addSubElement(document, moduleElement, "Time_of_Manufacture", candy.getBuyTime());
        return null;
       /*
        GetGiftClass getGiftClass = new GetGiftClass();
        Gift gift = getGiftClass.listOfCandy();
        System.out.println(gift);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element elementDom = document.createElement("Gift");
        document.appendChild(elementDom);
        for (Gift.Candy candy : gift.getCandy()) {
            Element moduleElement = document.createElement("Candy");
            elementDom.appendChild(moduleElement);
            addSubElement(document,moduleElement, "Name", candy.getName());
            addSubElement(document,moduleElement, "Production", candy.getProduction());
            Element visPar = document.createElement("Type_and_taste");
            List<String> list = candy.getTypeAndTaste();
            moduleElement.appendChild(visPar);
            addSubElement(document, visPar, "Type", candy.getTypeAndTaste().get(0));
            addSubElement(document, visPar, "Taste", candy.getTypeAndTaste().get(1));
            addSubElement(document, moduleElement, "Energy", Integer.toString(candy.getEnergy()));
            addSubElement(document, moduleElement, "Cost", Integer.toString(candy.getCost()));
            addSubElement(document, moduleElement, "Time_of_Manufacture", candy.getBuyTime());
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        OutputStream outputStream = Files.newOutputStream(Paths.get("GiftDom.xml"));
        transformer.transform(new DOMSource(document), new StreamResult(outputStream));
        return null;
    }

        */
    }
}