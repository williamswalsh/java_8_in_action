package ie.williamswalsh.patterns.chain_of_responsibility;

public class HeaderPrepender extends ProcessingObject<String> {

    @Override
    public String handleWork(String msg) {
        return "Williams msg: " + msg;
    }
}
