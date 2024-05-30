package com.google.android.calculator;

import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class f implements HostnameVerifier, X509TrustManager {
    private byte[] a;

    private f(byte[] paramArrayOfbyte) {
        this.a = paramArrayOfbyte;
    }

    public static void a(URLConnection paramURLConnection, byte[] paramArrayOfbyte) throws NoSuchAlgorithmException, KeyManagementException {
        if (paramURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            paramURLConnection = paramURLConnection;
            f f1 = new f(paramArrayOfbyte);
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            SecureRandom secureRandom = new SecureRandom();
            sSLContext.init(null, new TrustManager[] { f1 }, secureRandom);
            ((HttpsURLConnection) paramURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
            ((HttpsURLConnection) paramURLConnection).setHostnameVerifier(f1);
        }
    }

    public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}

    public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
        if (this.a != null) {
            if (paramArrayOfX509Certificate == null || paramArrayOfX509Certificate.length <= 0)
                throw new CertificateException();
            int i = paramArrayOfX509Certificate.length;
            byte b = 0;
            while (true) {
                if (b < i) {
                    X509Certificate x509Certificate = paramArrayOfX509Certificate[b];
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                        messageDigest.update(x509Certificate.getEncoded());
                        byte[] arrayOfByte = messageDigest.digest();
                        if (!Arrays.equals(this.a, arrayOfByte)) {
                            CertificateException certificateException = new CertificateException();
                            throw certificateException;
                        }
                    } catch (Exception exception) {
                        throw new CertificateException(exception);
                    }
                    b++;
                    continue;
                }
                return;
            }
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public final boolean verify(String paramString, SSLSession paramSSLSession) {
        return true;
    }
}

