package com.example.restraunt.wishList;

import com.example.restraunt.naver.NaverClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;

    public void search(String query){
        //지역검색

        //이미지 검색

        //결과 리턴
    }

}
