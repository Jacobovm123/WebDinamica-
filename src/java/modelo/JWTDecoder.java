package modelo;

import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;

public class JWTDecoder {

    public static String getClaims(String Token){
        System.out.println("------------ Decode JWT ------------");
        String[] split_string = Token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);


        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println("JWT Body : "+body);
        return body;
    }
}
