package com.example.restraunt.naver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NaverClient {
    //yaml에 설정한 값을 @value로 가져와 대입할 수 있다.
    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.clinet.secret}")
    private String naverSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;
}
