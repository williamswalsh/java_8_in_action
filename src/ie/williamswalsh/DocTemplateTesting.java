package ie.williamswalsh;

import java.util.*;

public class DocTemplateTesting {

    public static void main(String[] args) {
        List<Data> dataList = Arrays.asList(new Data("7", 40),new Data("7", 50), new Data("8", 50), new Data("N/A", 44));
        HashMap<String, Integer> levelSums = new HashMap<>();
        for (Data d:dataList) {
            if(levelSums.containsKey(d.lvl)){
                levelSums.put(d.lvl, (levelSums.get(d.lvl) + d.amt));
            }else{
                levelSums.put(d.lvl, d.amt);
            }
        }
        printMap(levelSums);
    }
    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
class Data{
    String lvl;
    int amt;

    public Data(String lvl, int amt) {
        this.lvl = lvl;
        this.amt = amt;
    }
}