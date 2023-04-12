package json.xml.main;

import json.xml.main.parsers.FactoryBuilderRealiser;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {

        int genFile = getScannerInfoInt();
        FactoryBuilderRealiser factoryBuilderRealiser = new FactoryBuilderRealiser();
        switch (genFile) {
            case 1:
                factoryBuilderRealiser.create(BuilderType.XML);
                break;
            case 2:
                factoryBuilderRealiser.create(BuilderType.JAXB);
                break;
            case 3:
                factoryBuilderRealiser.create(BuilderType.JSON_TREE);
                break;
            case 4:
                factoryBuilderRealiser.create(BuilderType.JSON_BIND);
                break;
            default:
                System.out.println("You entered incorrect number");
        }
    }

    public static int getScannerInfoInt() {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            result = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("You entered incorrect number. Try again");
            getScannerInfoInt();
        }
        return result;
    }
}
