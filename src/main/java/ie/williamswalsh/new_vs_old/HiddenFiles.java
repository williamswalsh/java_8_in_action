package ie.williamswalsh.new_vs_old;

import java.io.File;
import java.io.FileFilter;

public class HiddenFiles {
    public static void main(String[] args) {

        // new
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        for (File file: hiddenFiles) {
            System.out.println(file);
        }


        // old
        hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        for (File file: hiddenFiles) {
            System.out.println(file);
        }
    }
}
