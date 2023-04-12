package json.xml.main.parsers;

import json.xml.main.BaseDataObject;
import json.xml.main.Builder;
import json.xml.main.enums.GetGiftClass;
import json.xml.main.gift.Gift;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.StringWriter;
import java.nio.file.Paths;

public class JaxpGenerator implements Builder {


    @Override
    public BaseDataObject parse(String nameFile) throws JAXBException {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Gift.Candy.class);
            Unmarshaller um = context.createUnmarshaller();
            Gift gift = (Gift) um.unmarshal(Paths.get(nameFile).toFile());
            System.out.println(gift.getCandy());
            return gift;
        }catch (JAXBException e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public String generate(BaseDataObject dataObject) throws  JAXBException {
        GetGiftClass getGiftClass = new GetGiftClass();
        Gift gift = getGiftClass.listOfCandy();

        JAXBContext jaxbContext = JAXBContext.newInstance(Gift.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(gift, new File("GiftJAXB.xml"));

        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(dataObject, stringWriter);
        return stringWriter.toString();
    }
}
