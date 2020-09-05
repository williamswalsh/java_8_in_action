package ie.williamswalsh.patterns.chain_of_responsibility;

public class Spellchecker extends ProcessingObject<String> {

    @Override
    public String handleWork(String msg) {
        System.out.println("running");
        return msg.replaceAll("lamda","lambda");
    }
}
