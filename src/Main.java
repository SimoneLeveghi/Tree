import java.io.File;
import java.sql.SQLOutput;

public class Main {
    public static void tree(File dir, int offset, boolean insideLastDir) {
        System.out.println(dir.getName());
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; ++i) {
                System.out.print(
                        ((insideLastDir? "│" : " ") + "\t").repeat(offset) +
                        (i != files.length - 1? "├" : "└") +
                        "─".repeat(3)
                );

                if (files[i].isDirectory()) {
                    tree(files[i], offset + 1, i != files.length - 1);
                } else {
                    System.out.println(files[i].getName());
                }
            }
        }
    }

    public static void tree(File dir){
        tree(dir, 0, false);
    }

    public static void main(String[] args) {
        File root = new File(".");
        if (root.exists() && root.isDirectory()) {
            tree(root);
        } else {
            System.out.println("Percorso non valido");
        }
    }
}