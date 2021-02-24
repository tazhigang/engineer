package com.ittzg.rsa;


import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * @author: tazhigang
 * @date: 2021/2/22 15:48
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class LoadCertUtil {


    private static final String publicKey = "-----BEGIN CERTIFICATE-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDXfU9LnQh/FWsR\n" +
            "fa3pBp+ei/xyO0tobSxvCsugZ6pKT8IhAU91dzizfbuTG5RSw1auk4dEScEZpnli\n" +
            "9hJXQ2pOikcYGSbfV9htvdLNiR0twzXHCqPOYzMBLMLm4lKPQXM143lGtvU/3+lz\n" +
            "iiTTtEAllzocCQvqfjXFfWan08kK0Rdm7TPgqRMpNo9q7Wy/AtOZAjQAKcmkrxkF\n" +
            "FjeoGtmbQmUERZxyBrJ63sCtG8kS/vlrlmdaAza2v0ScvN0B/jQW3RQFkjGViNKi\n" +
            "cP3USBHLGy38zJXF0Thqc60JZzRQtlG3eKbi2kc/ytzevaNGWOTnUUfpVR0jxCkM\n" +
            "H44z3lSHAgMBAAECggEBAKCYaSJHE+/yPGs6qQODxi3Y0fkoK5jV1EmlWABhgc4E\n" +
            "Bv+mBFvc0Eskp0iJQ08y+UT9+c9w0BKXuNuB3EVgnreN4lIZXJkS1N9kmthHGZHj\n" +
            "bA685TuJPpffjhmYDkNpWb2Nm/KRo9FIxKkxCSUlrrDVNZ9zNog6K0TVok3tTmVZ\n" +
            "9ONY7X6bZsdziR3X/rjCiWTn3F3YJHXegKcXHbClEhhOCFMg+pN3RZORNxUf5h7H\n" +
            "/LVkBPVs5czbXtGgB1zbe+ILmou/rHmVgQT7TCrThEsi1ZRszWXJllZvrt2+KlVt\n" +
            "OJw/aQqk/qAWypoI+1qyQnruKU9fcg3XLHm/HDaypaECgYEA7dy1Jz71jRhgb9qq\n" +
            "yJjws6eG73o61rWdVmXr0WX+7UlTxwfRWqtHBQuOHLDiqwKc2JRZAhP2RuwNzgOb\n" +
            "Ce+fraiDQiOgZ8/lU+haO1JgTdVSMzzuj2Jv1Kfrefrt/8EKS/fhYcm/RMmf0lGw\n" +
            "cCe/Tr8Mkt1qsKxEKFGLhjU71bkCgYEA5+vd9LZeXWNa7+l74nxhIfgptydoUSct\n" +
            "vG21hdgXvJMCL2heFmAUyB6dSYm8St0klignEMD+S9pTz9KICXOnzm3kbjnng41A\n" +
            "e2QOGFGfkI9B78HF7QxY4zLtpRy5gZye2xtzjw3F/4Kf7lvDgkmEuuoHXFf8PKiY\n" +
            "TN70prconD8CgYBgrV0fx3IsV+UScXEKuUbT7lpkyWxSylxZunE/mdIkhbI8agwI\n" +
            "aychgNHRDYADe7teN+V5d72Yk+cEfeitAC0Jez1mS26t4wzVrtHF3LRxzitr0e8w\n" +
            "bhT//QQzfu7vDXnu6KA9i69m+QAxjqxE2ZLjIbmtk7sCdfH55TLtaIOaWQKBgA1S\n" +
            "0pR9aZxp2c6QlkpjpNzjudnIzMhkvM7napc+29Y8h9KbZ1RXvrnkcFrKK+QNIk3y\n" +
            "DpR60eEfsNLuoFwSpeBJFedzMiavlbXBAMJK5iTS5hHVCv7cR7r9sQNcTBfzHHkv\n" +
            "8YqVWvub0H5MDUZN3O80BKo8b8Q4V0+LO3jcatvXAoGBAJ4GRLN5hLxkQwwG4Pa0\n" +
            "Q4F64HOZkk/gOENUVGMT/9xE2mToil5y6i0lqt8Egvb3CXfP9UhheFZe1Jkrblnc\n" +
            "zMA63/Ut1x5T9pKgopKTk2CmZwrY5mIurqPX45wMOCe6pEgU42hNxWNDhaJK+g+S\n" +
            "DzdK90dop2ByyY7SYRH52fUF\n"+
            "-----END CERTIFICATE-----\n";



    private static final String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDXfU9LnQh/FWsR\n" +
            "fa3pBp+ei/xyO0tobSxvCsugZ6pKT8IhAU91dzizfbuTG5RSw1auk4dEScEZpnli\n" +
            "9hJXQ2pOikcYGSbfV9htvdLNiR0twzXHCqPOYzMBLMLm4lKPQXM143lGtvU/3+lz\n" +
            "iiTTtEAllzocCQvqfjXFfWan08kK0Rdm7TPgqRMpNo9q7Wy/AtOZAjQAKcmkrxkF\n" +
            "FjeoGtmbQmUERZxyBrJ63sCtG8kS/vlrlmdaAza2v0ScvN0B/jQW3RQFkjGViNKi\n" +
            "cP3USBHLGy38zJXF0Thqc60JZzRQtlG3eKbi2kc/ytzevaNGWOTnUUfpVR0jxCkM\n" +
            "H44z3lSHAgMBAAECggEBAKCYaSJHE+/yPGs6qQODxi3Y0fkoK5jV1EmlWABhgc4E\n" +
            "Bv+mBFvc0Eskp0iJQ08y+UT9+c9w0BKXuNuB3EVgnreN4lIZXJkS1N9kmthHGZHj\n" +
            "bA685TuJPpffjhmYDkNpWb2Nm/KRo9FIxKkxCSUlrrDVNZ9zNog6K0TVok3tTmVZ\n" +
            "9ONY7X6bZsdziR3X/rjCiWTn3F3YJHXegKcXHbClEhhOCFMg+pN3RZORNxUf5h7H\n" +
            "/LVkBPVs5czbXtGgB1zbe+ILmou/rHmVgQT7TCrThEsi1ZRszWXJllZvrt2+KlVt\n" +
            "OJw/aQqk/qAWypoI+1qyQnruKU9fcg3XLHm/HDaypaECgYEA7dy1Jz71jRhgb9qq\n" +
            "yJjws6eG73o61rWdVmXr0WX+7UlTxwfRWqtHBQuOHLDiqwKc2JRZAhP2RuwNzgOb\n" +
            "Ce+fraiDQiOgZ8/lU+haO1JgTdVSMzzuj2Jv1Kfrefrt/8EKS/fhYcm/RMmf0lGw\n" +
            "cCe/Tr8Mkt1qsKxEKFGLhjU71bkCgYEA5+vd9LZeXWNa7+l74nxhIfgptydoUSct\n" +
            "vG21hdgXvJMCL2heFmAUyB6dSYm8St0klignEMD+S9pTz9KICXOnzm3kbjnng41A\n" +
            "e2QOGFGfkI9B78HF7QxY4zLtpRy5gZye2xtzjw3F/4Kf7lvDgkmEuuoHXFf8PKiY\n" +
            "TN70prconD8CgYBgrV0fx3IsV+UScXEKuUbT7lpkyWxSylxZunE/mdIkhbI8agwI\n" +
            "aychgNHRDYADe7teN+V5d72Yk+cEfeitAC0Jez1mS26t4wzVrtHF3LRxzitr0e8w\n" +
            "bhT//QQzfu7vDXnu6KA9i69m+QAxjqxE2ZLjIbmtk7sCdfH55TLtaIOaWQKBgA1S\n" +
            "0pR9aZxp2c6QlkpjpNzjudnIzMhkvM7napc+29Y8h9KbZ1RXvrnkcFrKK+QNIk3y\n" +
            "DpR60eEfsNLuoFwSpeBJFedzMiavlbXBAMJK5iTS5hHVCv7cR7r9sQNcTBfzHHkv\n" +
            "8YqVWvub0H5MDUZN3O80BKo8b8Q4V0+LO3jcatvXAoGBAJ4GRLN5hLxkQwwG4Pa0\n" +
            "Q4F64HOZkk/gOENUVGMT/9xE2mToil5y6i0lqt8Egvb3CXfP9UhheFZe1Jkrblnc\n" +
            "zMA63/Ut1x5T9pKgopKTk2CmZwrY5mIurqPX45wMOCe6pEgU42hNxWNDhaJK+g+S\n" +
            "DzdK90dop2ByyY7SYRH52fUF";


    public static PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {



        return null;

    }




    public static PublicKey getPublicKey(){

        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            InputStream inputStream = new ByteArrayInputStream(publicKey.getBytes());

            Certificate certificate = cf.generateCertificate(inputStream);

            return certificate.getPublicKey();
        } catch (CertificateException e) {
            e.printStackTrace();
        }




        return null;

    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
//        System.out.println(getPublicKey());

        byte[] decode = Base64.getDecoder().decode(privateKey);


        System.out.println(new String(decode));
    }
}
