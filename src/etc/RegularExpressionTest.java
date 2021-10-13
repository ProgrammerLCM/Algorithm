package etc;

public class RegularExpressionTest {

    public void splitTest() {
        String DELIMITER = "(?<=[#|*|S|D|T])";
        String DELIMITER2 = "(?=[#|*|S|D|T])";
        String str = "10S2D*0T";
        String[] strArr = str.split(DELIMITER);
        String[] strArr2 = str.split(DELIMITER2);
        String test = "";
    }
}
