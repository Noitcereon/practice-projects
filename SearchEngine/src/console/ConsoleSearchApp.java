package console;


import data.FakeData;
import data.IData;
import search.ISearchEngine;
import search.SearchEngine2;

import java.util.Collection;
import java.util.Objects;

public class ConsoleSearchApp implements Runnable{
    @Override
    public void run() {
        IUserInputHelper inputHelper = new UserInputHelper();
        IData<String> dataAccess = new FakeData();
        ISearchEngine<?> searchEngine = new SearchEngine2(dataAccess.get());

        while(true){
            String userInput = inputHelper.askForInput();
            System.out.println(userInput);
            Collection<?> output = searchEngine.search(userInput);
            System.out.println(output);
            if(Objects.equals(userInput, "q")) break;
        }
    }
}
