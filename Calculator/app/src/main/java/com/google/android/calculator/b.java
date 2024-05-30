package com.google.android.calculator;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

public final class b {
    private static final long a = TimeUnit.SECONDS.toMillis(1L);

    private static int a(byte[] paramArrayOfbyte, int paramInt) {
        byte b1 = 0;
        int i = 0;
        while (b1 < 4) {
            i |= (paramArrayOfbyte[b1 + paramInt] & 0xFF) << b1 << 3;
            b1++;
        }
        return i;
    }

    public static com.google.android.calculator.a a(com.google.android.calculator.a a) {
        return null;
    }

    public a a(byte[] paramArrayOfbyte) {
        a a = new a();
        a.a = a(paramArrayOfbyte, 0);
        a.b = this.a * a(paramArrayOfbyte, 12);
        b(paramArrayOfbyte, 16, 16);
        b(paramArrayOfbyte, 32, 16);
        int i = 48;
        int j = i;
        if ((a.a & 0x1) != 0) {
            a.c = a(paramArrayOfbyte, 8000, 100);
            j = i;
        }
        while (paramArrayOfbyte[j] != 0) {
            g g = new g();
            g.a = a(paramArrayOfbyte, j, 512);
            j = j + 512 + 4;
            g.b = this.a * a(paramArrayOfbyte, j);
            j += 4;
            g.c = b.a * this.a(paramArrayOfbyte, j);
            i = j + 4;
            j = i;
            if (g.a.startsWith("http")) {
                StringBuilder stringBuilder;
                a(paramArrayOfbyte, i, 128);
                j = i + 128;
                a(paramArrayOfbyte, j, 64);
                j += 64;
                a(paramArrayOfbyte, j, 64);
                j += 64;
                g.d = a(paramArrayOfbyte, j, 256);
                j += 256;
                g.e = null;
                byte[] arrayOfByte = b(paramArrayOfbyte, j, 20);
                i = j + 20;
                j = 0;
                while (true) {
                    if (j < arrayOfByte.length)
                        if (arrayOfByte[j] != 0) {
                            g.e = arrayOfByte;
                        } else {
                            j++;
                            continue;
                        }
                    stringBuilder = new StringBuilder();
                    int k = paramArrayOfbyte.length;
                    j = i;
                    while (j < k) {
                        byte b1 = paramArrayOfbyte[j];
                        if (b1 != 0) {
                            stringBuilder.append((char)(b1 & 0xFF));
                            j++;
                        }
                    }
                    break;
                }
                String str = stringBuilder.toString();
                g.f = str;
                j = str.length() + i;
            }
            a.d.add(g);
        }
        return a;
    }

    private static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
        String str;
        byte[] arrayOfByte = b(paramArrayOfbyte, paramInt1, paramInt2);
        str = new String();
        a(arrayOfByte, Integer.parseInt("ISO-8859-1"));
        str = str.trim();
        return str;
    }

    private static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
        return arrayOfByte;
    }
}

