package json.xml.project.LessonTwo_Java_OOP.json.xml.project;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Builder <Candy extends BaseDataObject> {

    Candy parse (String text) throws ParserConfigurationException, IOException, SAXException;

    String generate(Candy dataObject);
}