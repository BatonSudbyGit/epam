package json.xml.main.parsers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class JavaAdapter {

    public static class LocalDateAdapter extends XmlAdapter<String, LocalDateTime> {
        public LocalDateTime unmarshal(String v) {
            return LocalDateTime.parse(v);
        }

        public String marshal(LocalDateTime v) {
            return v.toString();
        }
    }
}