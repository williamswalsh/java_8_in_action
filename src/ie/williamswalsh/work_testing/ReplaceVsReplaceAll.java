package ie.williamswalsh.work_testing;

import java.util.Arrays;
import java.util.List;

public class ReplaceVsReplaceAll {
    public static void main(String[] args) {
        String key = "email.reset-password.subject-line";

        System.out.println(key.replace("-","_"));
        System.out.println(key.replace(".","_"));
        System.out.println(key.replace("-","_").replace(".","_"));

        System.out.println("4" + key.replaceAll("-","_"));
        System.out.println(key.replaceAll("\\.","_"));
        System.out.println(key.replaceAll("-","_").replaceAll("\\.","_"));

        List<String> settings = Arrays.asList("h","my","name","is","wrll");
        System.out.println(settings.stream().anyMatch(s -> {
            if (s.contains("i")) {
                return true;
            }
            return false;
        }));
    }
}
