package fr.dauphine.ja.hamanmeryeme.nio.exo1;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException{
        Path path = Paths.get(".");
        DirMonitor dirMonitor = new DirMonitor(path);
        dirMonitor.listFiles();
        System.out.println(dirMonitor.sizeOfFiles());
        System.out.println(dirMonitor.mostRecent());

    }

}
