package example;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Hoge {
    private String aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAaaaaaaaaaaaaaaaaaaaaaaaaa = "test";
    private String a = "test";
    // 以下はコメントによる1行のチェック対象外
    private String b = "test";  //CHECKSTYLE IGNORE THIS LINE //NOPMD
    private String c = "test";
    // 以下は複数行でのチェック対象外
    //CHECKSTYLE:OFF
    private String d = "test";
    //CHECKSTYLE:ON
    private String e = "test";

    public void getTest(String str) {
        String ip = "127.0.0.1";

        if ("test".equals(str)) {
            this.a = "test1";
        }
        if ("test2".equals(str)) {
            this.a = "test2";
        }
        if ("test3".equals(str)) {
         this.a = "test3";
        }
    }

    public void setTest(String str) {
        if ("test".equals(str)) {
            this.a = "test1";
        }
        if ("test2".equals(str)) {
            this.a = "test2";
        }
        if ("test3".equals(str)) {
            this.a = "test3";
        }
    }
}
