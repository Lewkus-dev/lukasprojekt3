package viewTest;

import se.sprinto.hakan.adventuregame.view.UI;

public class FakeUI implements UI {
    private String input;

    @Override
    public void showMessage(String message) {

    }

    @Override
    public String getInput(String prompt) {
        return input;
    }

    public void setInput(String input){
        this.input = input;
    }


}
