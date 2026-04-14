package day8;

interface Readable {
    String readContent();
}

interface Writable {
    void writeContent(String content);
}

public interface ReadWritable extends Readable, Writable {

}


