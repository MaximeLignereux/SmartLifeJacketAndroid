package android.mlignereux.univcorse.fr.smartlifejacketandroid.dao;

import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CCoach;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CRequeteValue;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CUser;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.util.CConstant;
import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by asus on 11/10/2015.
 */
public class CCoachDAO  {

    private final static String URL = CConstant.BASE_URI + "/SmartLifeJacketServer/api/coachs/";
    private static final String TAG = "CCoachDAO";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders requestHeaders = new HttpHeaders();

    public CRequeteValue create(CCoach pCoach) {

        String url = URL + "add";
        ResponseEntity responseEntity = null;
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        HttpStatus status = null;
        if(pCoach != null){
            try {
                requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                multiValueMap.add("email", pCoach.getEmail());
                multiValueMap.add("password", pCoach.getPassword());

                HttpEntity<MultiValueMap<String,String>> requestEntity = new HttpEntity<>(multiValueMap, requestHeaders);

                restTemplate = new RestTemplate();

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

                responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
                status = responseEntity.getStatusCode();
                Log.d("EntityReponse", responseEntity.toString());


            }catch (HttpClientErrorException pE){
                Log.e("HttpClientError", pE.getMessage());
                status = pE.getStatusCode();
                Log.e("HttpClientError", pE.getLocalizedMessage());
                Log.e("HttpClientError", pE.getResponseBodyAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getResultRequete(status,pCoach);
    }

    public CRequeteValue getCoach(CCoach pCoach){

        HttpStatus status = null;
        String url = URL + "connect";
        ResponseEntity responseEntity;
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        if(pCoach != null){
            try {
                requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                multiValueMap.add("email", pCoach.getEmail());
                multiValueMap.add("password", pCoach.getPassword());
                multiValueMap.add("status", pCoach.getStatus().toString());

                UriComponentsBuilder uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("email", pCoach.getEmail())
                        .queryParam("password", pCoach.getPassword())
                        .queryParam("status", pCoach.getStatus().toString());

                HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

                restTemplate = new RestTemplate();

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

                responseEntity =  restTemplate.exchange(uriComponents.build().encode().toUri(), HttpMethod.GET, requestEntity, CCoach.class);
                pCoach = restTemplate.getForObject(uriComponents.build().encode().toUri(),CCoach.class);
                Log.d(TAG, "getCoach: "+ pCoach);
                status = responseEntity.getStatusCode();

            }catch (HttpClientErrorException pE){
                Log.e("HttpClientError", pE.getMessage());
                status = pE.getStatusCode();
                Log.e("HttpClientError", pE.getLocalizedMessage());
                Log.e("HttpClientError", pE.getResponseBodyAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return getResultRequete(status, pCoach);
    }

    public static CRequeteValue getResultRequete(HttpStatus httpStatus, CUser user){
        return new CRequeteValue(httpStatus,user);
    }

}
