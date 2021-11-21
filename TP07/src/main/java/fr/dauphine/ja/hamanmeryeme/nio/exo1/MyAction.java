package fr.dauphine.ja.hamanmeryeme.nio.exo1;

import java.io.IOException;
import java.nio.file.Path;

public interface MyAction {

    void perform(Path p) throws IOException;

}
