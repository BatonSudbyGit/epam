package json.xml.project.LessonTwo_Java_OOP.candies.factory;

import json.xml.project.LessonTwo_Java_OOP.json.xml.project.BaseDataObject;

//Interface for 'NewPresentFactory'.
public interface INewPresentFactory <Candy extends BaseDataObject>{
    Candy buyNewPresent();
}