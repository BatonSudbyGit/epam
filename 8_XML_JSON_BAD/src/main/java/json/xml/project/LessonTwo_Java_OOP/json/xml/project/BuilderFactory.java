package json.xml.project.LessonTwo_Java_OOP.json.xml.project;

public interface BuilderFactory <Gift extends BaseDataObject> {
    Builder<Gift> create(BuilderType builderType);
}
enum BuilderType {
    XML, JAXB, JSON_TREE, JSON_BIND
}
