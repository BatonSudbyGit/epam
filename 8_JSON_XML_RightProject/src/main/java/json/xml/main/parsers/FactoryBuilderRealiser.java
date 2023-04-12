package json.xml.main.parsers;

import json.xml.main.Builder;
import json.xml.main.BuilderFactory;


import json.xml.main.BuilderType;
import json.xml.main.enums.GetGiftClass;
import json.xml.main.gift.Gift;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FactoryBuilderRealiser implements BuilderFactory {

    @Override
    public Builder create(BuilderType builderType) throws ParserConfigurationException, IOException, SAXException, TransformerException, JAXBException {
        GetGiftClass getGiftClass = new GetGiftClass();
        Gift gift = getGiftClass.listOfCandy();
        try{
            if (builderType == BuilderType.XML) {
                new DomGenerator().generate(gift);
                new DomGenerator().parse("GiftDom.xml");
                return new DomGenerator();
            } else if (builderType == BuilderType.JAXB) {
                new JaxpGenerator().generate(gift);
                new JaxpGenerator().parse("GiftJAXB.xml");
                return new JaxpGenerator();
            }else if (builderType == BuilderType.JSON_BIND) {
                new JsonDataBuildingGenerator().generate(gift);
                new JsonDataBuildingGenerator().parse("GiftJsonBin.xml");
                return new JsonDataBuildingGenerator();
            }else if (builderType == BuilderType.JSON_TREE) {
                new JsonTreeGenerator().generate(gift);
                new JsonTreeGenerator().parse("GiftJsonTree.xml");
                return new JsonTreeGenerator();
            }else {
                throw new RuntimeException("Wrong builder " + builderType);
            }
        }catch (FileNotFoundException | IllegalArgumentException e){
            System.out.println("File has not been created yet");
        }
        return null;
    }
}
