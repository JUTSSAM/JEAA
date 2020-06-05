import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class I {
    private static char[] a = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f' };

    public static String a(String paramString) {
        try {
            byte[] arrayOfByte = paramString.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(arrayOfByte);
            arrayOfByte = messageDigest.digest();
            int k = arrayOfByte.length;
            char[] arrayOfChar = new char[k * 2];
            int i = 0;
            int j = 0;
            while (i < k) {
                byte b = arrayOfByte[i];
                int m = j + 1;
                arrayOfChar[j] = a[b >>> 4 & 0xF];
                j = m + 1;
                arrayOfChar[m] = a[b & 0xF];
                i++;
            }
            return new String(arrayOfChar);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String b(String paramString) {
        try {
            byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            int j = arrayOfByte.length;
            for (int i = 0; i < j; i++) {
                int k = arrayOfByte[i] & 0xFF;
                if (k < 16)
                    stringBuffer.append(0);
                stringBuffer.append(Integer.toHexString(k));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return null;
        }
    }
}
