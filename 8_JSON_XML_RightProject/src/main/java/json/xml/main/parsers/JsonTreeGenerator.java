package json.xml.main.parsers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import jdk.security.jarsigner.JarSigner;
import json.xml.main.BaseDataObject;
import json.xml.main.Builder;
import json.xml.main.enums.GetGiftClass;
import json.xml.main.gift.Gift;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class JsonTreeGenerator implements Builder {
    @Override
    public BaseDataObject parse(String nameFile) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Reader reader;
        Gift gift = new Gift();
        try{
            reader = new FileReader(nameFile);
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement jsonElement = JsonParser.parseReader(jsonReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            System.out.println(jsonObject);
            gift.setCandy(new ArrayList<>());
            JsonArray candyArray = jsonObject.getAsJsonArray("Candy");
            for (JsonElement element : candyArray) {
                Gift.Candy candy = new Gift.Candy();
                gift.getCandy().add(candy);
                JsonObject candyObject = element.getAsJsonObject();
                candy.setName(candyObject.get("name").getAsString());
                candy.setProduction(candyObject.get("production").getAsString());
                candy.setTypeAndTaste(Collections.singletonList(candyObject.get("typeAndTaste").getAsJsonObject().toString()));
                candy.setEnergy(candyObject.get("energy").getAsInt());
                candy.setCost(candyObject.get("cost").getAsInt());
                candy.setBuyTime(LocalDateTime.parse(candyObject.get("buyTime").getAsString()));
            }
            System.out.println(gift.getCandy());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return gift;
    }

    @Override
    public String generate(BaseDataObject dataObject) throws ParserConfigurationException, TransformerException, IOException, JAXBException {
        GetGiftClass getGiftClass = new GetGiftClass();
        Gift gift = getGiftClass.listOfCandy();
        JsonObject giftJson = new JsonObject();
        JsonArray moduleArray = new JsonArray();
        giftJson.add("Candy", moduleArray);
        for (Gift.Candy candy : gift.getCandy()) {
            JsonObject moduleJson = new JsonObject();
            moduleArray.add(moduleJson);
            moduleJson.addProperty("name", candy.getName());
            moduleJson.addProperty("production", candy.getProduction());
            JsonObject visJson = new JsonObject();
            moduleJson.add("typeAndTaste", visJson);
            visJson.addProperty("type", candy.getTypeAndTaste().get(0));
            visJson.addProperty("taste", candy.getTypeAndTaste().get(1));
            moduleJson.addProperty("energy", candy.getEnergy());
            moduleJson.addProperty("cost", candy.getCost());
            moduleJson.addProperty("buyTime", candy.getBuyTime());
        }
        String string = giftJson.toString();
        try {
            Writer writer = new FileWriter("GiftJsonTree.xml");
            writer.write(string);
            writer.close();
        }catch (IOException e){
            System.out.println("Try again");
            System.out.println(e.getMessage());
        }
        return string;
    }
}
