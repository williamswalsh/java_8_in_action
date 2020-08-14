package ie.williamswalsh.patterns.chain_of_responsibility;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderPrepender();
        ProcessingObject<String> p2 = new Spellchecker();
        p1.setSucessor(p2);

        System.out.println(p1.handleWork("This is my message about lamda dfsf"));
    }

}
