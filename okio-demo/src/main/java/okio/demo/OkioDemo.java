package okio.demo;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Jie Zhao
 * @date 2022/6/9 23:58
 */
public class OkioDemo {

    public static void main(String[] args) throws Exception {

        InputStream in = new FileInputStream("okio-demo/src/main/resources/test.txt");
        BufferedSource source = Okio.buffer(Okio.source(in));
        String text = source.readUtf8();
        System.out.println(text);

        BufferedSink sink = Okio.buffer(Okio.sink(new File("okio-demo/src/main/resources/test_copy.txt")));
        sink.writeUtf8(text);
        source.close();
        sink.close();
    }
}
