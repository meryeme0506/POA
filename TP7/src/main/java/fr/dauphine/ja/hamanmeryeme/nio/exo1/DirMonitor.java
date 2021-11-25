package fr.dauphine.ja.hamanmeryeme.nio.exo1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * @author Meryeme Haman
 * version 1.0
 */
public class DirMonitor {

    private Path path;

    /**
     * Build a directory monitor
     *
     * @param path a path
     * @throws InvalidPathException
     */
    public DirMonitor(Path path) throws IOException {
        if (!(Files.isDirectory(path)))
            throw new IOException( "The path isn't a directory");
        if (!(Files.isReadable(path)))
            throw new IOException("The path can't be readable");
        this.path = path;
    }

    public void listFiles() throws IOException {
        long min = 1000;
        new MyAction() {

            @Override
            public void perform(Path p) throws IOException {
                Iterator<Path> iter = Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>() {

                    @Override
                    public boolean accept(Path p) throws IOException {
                        return p.endsWith("txt") && p.toFile().length() >= min;
                    }
                }).iterator();
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            }

        };

    }

    public long sizeOfFiles() throws IOException{
        /*long size = 0;
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        for(Path p : stream)
            size += p.toFile().length();
        return size;*/
        return new SizeOfFiles().sizeOfFiles(path);
    }

    public File mostRecent() throws IOException {
        /*File file=null;
        long recent = 0;
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        for(Path p : stream){
            if(recent == 0) {
                file = p.toFile();
                recent = file.lastModified();
            }
            if(file.lastModified() < recent) {
                file = p.toFile();
                recent = file.lastModified();
            }
        }
        return file;*/
        return new MostRecentFile().mostRecent(path);

    }

    public class PrefixFilter implements DirectoryStream.Filter<Path> {

        private long size;

        public PrefixFilter(long n) {
            size = n;
        }
        @Override
        public boolean accept(Path path) throws IOException {
            return path.toFile().length() >= size;
        }

    }

    public class SizeOfFiles implements MyAction {

        private long size;

        public long sizeOfFiles(Path p) throws IOException {
            this.perform(p);
            return size;
        }

        @Override
        public void perform(Path p) throws IOException {
            long size = 0;

            DirectoryStream<Path> stream = Files.newDirectoryStream(p);
            for(Path p1 : stream)
                size += p1.toFile().length();

            this.size = size;
        }

    }

    public class MostRecentFile implements MyAction {

        File file;

        public File mostRecent(Path path) throws IOException {
            this.perform(path);
            return file;
        }

        @Override
        public void perform(Path path) throws IOException {
            long recent = 0;
            File file = null;
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            for(Path p1 : stream) {
                if(recent == 0) {
                    file = p1.toFile();
                    recent = file.lastModified();
                }
                if(file.lastModified() < recent) {
                    file = p1.toFile();
                    recent = file.lastModified();
                }
            }
            this.file = file;
        }

    }
}
