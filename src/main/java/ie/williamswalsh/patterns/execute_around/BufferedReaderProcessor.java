package ie.williamswalsh.patterns.execute_around;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
    public String process(BufferedReader bufferedReader) throws IOException;
}
