package data;

import java.util.ArrayList;
import java.util.List;

public class FakeData implements IData<String>{
    public List<String> get(){
        List<String> fakeData = new ArrayList<>();
        fakeData.add("House of the Rising Sun");
        fakeData.add("The Forgotten");
        fakeData.add("Emperor's Cassock");
        fakeData.add("Industrialism at it's Finest");
        fakeData.add("What We Seek, We Find");
        fakeData.add("Cloud Above");
        fakeData.add("Cloud Below");
        fakeData.add("As Above, So Below");
        fakeData.add("Equality is a Tough Concept to Implement Fairly");
        fakeData.add("Art Thou Whom I Seek");
        return fakeData;
    }
}
