package json.xml.project.LessonTwo_Java_OOP.json.xml.project.parsers;

import json.xml.project.LessonTwo_Java_OOP.candies.createCandies.Candy;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.BaseDataObject;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
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
    public BaseDataObject parse(String failName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document1 = builder.parse(failName);
        Element root = document1.getDocumentElement();
        Candy gift  = new Candy();
        gift.generateData();
        NodeList nodes = root.getElementsByTagName("Candy");
        ArrayList<String> visPar = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Element candyElement = (Element) nodes.item(i);
            Candy candy = new Candy();
            candy.setTaste(getElementContent(candyElement, "Taste"));
            candy.setWeight(Integer.parseInt(Objects.requireNonNull(getElementContent(candyElement, "Weight"))));
            


        }

        return null;
    }

    @Override
    public String generate(BaseDataObject dataObject) {
        return null;
    }
}