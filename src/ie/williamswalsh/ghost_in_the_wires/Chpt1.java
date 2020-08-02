package ie.williamswalsh.ghost_in_the_wires;

public class Chpt1 {
    public static void main(String[] args) {

        char[] code = "Max vhlm hy max unl wkboxk ingva B nlxw mh ingva fr hpg mktglyxkl".toLowerCase().toCharArray();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        System.out.println(code);

        for (int j = 0; j < code.length; j++) {
            if (code[j] == ' ') {
                continue;
            }
            // -97 -> UTF-8/ASCII -> alphabet array encoding
            // +7  -> Caesar Cipher Shift -> +7
            // %26 -> keep within bounds of 0 - 25
            // z wraps around to g
            code[j] = alphabet[((int)code[j] - 97 + 7)%26];
        }
        System.out.println(code);
    }

}
