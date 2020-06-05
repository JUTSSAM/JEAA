import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Encode {


    private static String encode(String arg5) throws JSONException {
        long v0 = System.currentTimeMillis();
        arg5 = b.b(Constant.hc, arg5);
        String v2 = a(arg5, v0);
        JSONObject v3 = new JSONObject();
        v3.put("errcode", 0);
        v3.put("timestamp", v0);
        v3.put("data", arg5);
        v3.put("sign", v2);
        return v3.toString();
    }

    private static String a(String paramString, long paramLong) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errcode=0");
        stringBuilder.append("data=");
        stringBuilder.append(paramString);
        stringBuilder.append("&timestamp=");
        stringBuilder.append(paramLong);
        stringBuilder.append(Constant.gc);
        return I.a(b.a(stringBuilder.toString()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in_str = sc.nextLine();
        System.out.println(encode(in_str));
    }
}
