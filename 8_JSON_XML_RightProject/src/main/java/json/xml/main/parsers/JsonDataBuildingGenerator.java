package json.xml.main.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.xml.main.BaseDataObject;
import json.xml.main.Builder;
import json.xml.main.LocalDateTimeSerializer;
import json.xml.main.gift.Gift;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.time.LocalDateTime;

public class JsonDataBuildingGenerator implements Builder {


    @Override
    public BaseDataObject parse(String nameFile) {
        try{
            StringBuilder stringBuilder = new StringBuilder();

            Reader reader = new FileReader(nameFile);
            int data = reader.read();
            while (data != -1){
                char dataChar = (char) data;
                stringBuilder.append(dataChar);
                data = reader.read();
            }
            reader.close();
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                    .setPrettyPrinting().create();
            Gift gift = gson.fromJson(String.valueOf(stringBuilder), Gift.class);
            System.out.println(gift.getCandy().toString());
            return gift;
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String generate(BaseDataObject dataObject) {
        Gson gson1 = new Gson();
        String json = gson1.toJson(dataObject);
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .setPrettyPrinting().excludeFieldsWithModifiers().create();
        Gift candy = gson.fromJson(json, Gift.class);
        String string = gson.toJson(candy);
        try{
            Writer writer = new FileWriter("GiftJsonBin.xml");
            writer.write(string);
            writer.close();
        }catch (IOException e){
            System.out.println("Try again!");
            System.out.println(e.getMessage());
        }
        return string;
    }
}