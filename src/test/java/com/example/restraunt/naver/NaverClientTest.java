package com.example.restraunt.naver;

import com.example.restraunt.naver.dto.SearchImageReq;
import com.example.restraunt.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {
    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest(){

        var search = new SearchLocalReq();
        search.setQuery("갈비집");
        var result = naverClient.localSearch(search);
        System.out.println(result);
    }
    @Test
    public void searchImageTest(){
        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.imageSearch(search);
        System.out.println(result);
    }
}
