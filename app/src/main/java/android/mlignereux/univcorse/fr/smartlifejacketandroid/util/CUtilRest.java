package android.mlignereux.univcorse.fr.smartlifejacketandroid.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by asus on 20/11/2015.
 */
public class CUtilRest<T> {

    public static <T> ResponseEntity<T> sendRequest (String pUrl,T pParam,HttpMethod pMethod,Class<T> pClass){

        if(pUrl == null ||pParam == null || pMethod == null || pClass == null){
            System.err.println("Un des champs de la requete est null");
            return null;
        }
        if(!(pUrl.contains("http://") || pUrl.contains("https://"))){
            System.err.println("URL invalid");
            return null;
        }

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<?> requestEntity = new HttpEntity<>(pParam,requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return restTemplate.exchange(pUrl,pMethod,requestEntity,pClass);
    }
}
