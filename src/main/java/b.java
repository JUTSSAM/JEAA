import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b {
    public static String a(String paramString) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(paramString.getBytes("UTF-8"));
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        return "";
    }

    public static String a(String paramString1, String paramString2) {
        try {
            byte[] arrayOfByte1 = b(paramString2);
            byte[] arrayOfByte2 = Arrays.copyOfRange(arrayOfByte1, 0, 16);
            arrayOfByte1 = Arrays.copyOfRange(arrayOfByte1, 16, arrayOfByte1.length);
            byte[][] arrayOfByte = a(32, 16, null, paramString1.getBytes("UTF-8"), 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(arrayOfByte2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte[0], "AES");
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(arrayOfByte1), "UTF-8");
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] paramArrayOfbyte) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < paramArrayOfbyte.length; i++) {
            String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
            if (str.length() == 1)
                stringBuffer.append("0");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
        byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramArrayOfbyte2.length];
        System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
        System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte, paramArrayOfbyte1.length, paramArrayOfbyte2.length);
        return arrayOfByte;
    }

    public static byte[][] a(int paramInt1, int paramInt2, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt3) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        byte[][] arrayOfByte = new byte[2][];
        byte[] arrayOfByte2 = new byte[paramInt1];
        byte[] arrayOfByte3 = new byte[paramInt2];
        arrayOfByte[0] = arrayOfByte2;
        arrayOfByte[1] = arrayOfByte3;
        if (paramArrayOfbyte2 == null)
            return arrayOfByte;
        byte[] arrayOfByte1 = null;
        int j = paramInt2;
        int k = 0;
        paramInt2 = 0;
        int i = paramInt1;
        int m = 0;
        paramInt1 = j;
        j = k;
        while (true) {
            messageDigest.reset();
            if (m > 0)
                messageDigest.update(arrayOfByte1);
            messageDigest.update(paramArrayOfbyte2);
            if (paramArrayOfbyte1 != null)
                messageDigest.update(paramArrayOfbyte1, 0, 8);
            arrayOfByte1 = messageDigest.digest();
            for (k = 1; k < paramInt3; k++) {
                messageDigest.reset();
                messageDigest.update(arrayOfByte1);
                arrayOfByte1 = messageDigest.digest();
            }
            if (i > 0) {
                k = 0;
                while (i != 0 && k != arrayOfByte1.length) {
                    arrayOfByte2[j] = arrayOfByte1[k];
                    i--;
                    k++;
                    j++;
                }
            } else {
                k = 0;
            }
            int n = paramInt1;
            int i1 = paramInt2;
            if (paramInt1 > 0) {
                n = paramInt1;
                i1 = paramInt2;
                if (k != arrayOfByte1.length)
                    while (true) {
                        if (paramInt1 == 0) {
                            n = paramInt1;
                            i1 = paramInt2;
                            break;
                        }
                        if (k == arrayOfByte1.length) {
                            n = paramInt1;
                            i1 = paramInt2;
                            break;
                        }
                        arrayOfByte3[paramInt2] = arrayOfByte1[k];
                        paramInt1--;
                        k++;
                        paramInt2++;
                    }
            }
            if (i == 0 && n == 0) {
                for (paramInt1 = 0; paramInt1 < arrayOfByte1.length; paramInt1++)
                    arrayOfByte1[paramInt1] = 0;
                return arrayOfByte;
            }
            m++;
            paramInt1 = n;
            paramInt2 = i1;
        }
    }

    public static String b(String paramString1, String paramString2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            byte[][] arrayOfByte = a(32, 16, null, paramString1.getBytes("UTF-8"), 0);
            cipher.init(1, new SecretKeySpec(arrayOfByte[0], "AES"), new IvParameterSpec(arrayOfByte[1]));
//            String str = new String(,"ascii");
//            for(byte item: arrayOfByte[0]){
//                System.out.print(item);
//                System.out.print(",");
//            }
            return b(a(cipher.getIV(), cipher.doFinal(paramString2.getBytes("UTF-8"))));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static String b(byte[] paramArrayOfbyte) {
        String str = "";
        for (int i = 0; i < paramArrayOfbyte.length; i++) {
            String str1 = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
            if (str1.length() == 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("0");
                stringBuilder.append(str1);
                str = stringBuilder.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(str1);
                str = stringBuilder.toString();
            }
        }
        return str.toUpperCase();
    }

    private static byte[] b(String paramString) {
        if (paramString == null)
            return null;
        int i = paramString.length();
        if (i % 2 == 1)
            return null;
        int j = i / 2;
        byte[] arrayOfByte = new byte[j];
        for (i = 0; i != j; i++) {
            int k = i * 2;
            arrayOfByte[i] = (byte) Integer.parseInt(paramString.substring(k, k + 2), 16);
        }
        return arrayOfByte;
    }
}
