package ie.williamswalsh.functional_design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllSubsets {
    public static List<List<Integer>> subset(List<Integer> list){
        if (list.isEmpty()) {
            List<List<Integer>> emptyList = new ArrayList<>();
            emptyList.add(Collections.emptyList());
            return emptyList;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1,list.size());
        List<List<Integer>> subset1 = subset(rest);
        List<List<Integer>> subset2 = insertAll(first, rest);
        return concat(subset1, subset2);
    }

    private static List<List<Integer>> insertAll(Integer i, List<Integer> list) {
        return null;
    }

    private static List<List<Integer>> concat(List<List<Integer>> list1, List<List<Integer>> list2) {
        List<List<Integer>> out = new ArrayList<>();
        out.addAll(list1);
        out.addAll(list2);
        return out;
    }

    private static List<List<Integer>> concatImproved(List<List<Integer>> list1, List<List<Integer>> list2) {
        List<List<Integer>> out = new ArrayList<>(list1);
        out.addAll(list2);
        return out;
    }
}
