package com.example.restraunt.naver;

import com.example.restraunt.naver.dto.SearchImageReq;
import com.example.restraunt.naver.dto.SearchImageRes;
import com.example.restraunt.naver.dto.SearchLocalReq;
import com.example.restraunt.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {
    //yaml에 설정한 값을 @value로 가져와 대입할 수 있다.
    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes localSearch(SearchLocalReq searchLocalReq){
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
               //그냥 HashMap이 아닌 MultivalueMap쓰는이유 => 같은 Key를 가진 파라미터 값이 여러개일 경우
                .queryParams(searchLocalReq.toMultivalueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();
    }

    public SearchImageRes imageSearch(SearchImageReq searchImageReq){
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                //그냥 HashMap이 아닌 MultivalueMap쓰는이유 => 같은 Key를 가진 파라미터 값이 여러개일 경우
                .queryParams(searchImageReq.toMultivalueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();
    }
}
