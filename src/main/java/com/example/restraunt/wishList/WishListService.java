package com.example.restraunt.wishList;

import com.example.restraunt.naver.NaverClient;
import com.example.restraunt.naver.dto.SearchImageReq;
import com.example.restraunt.naver.dto.SearchLocalReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;

    public WishListDto search(String query){

        //지역검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.localSearch(searchLocalReq);

        if(searchLocalRes.getTotal() > 0){
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);
            //이미지 검색
            var searchImageRes = naverClient.imageSearch(searchImageReq);

            if(searchImageRes.getTotal() > 0){

                var imageItem = searchImageRes.getItems().stream().findFirst().get();
                //결과 리턴
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setReadAddress(localItem.getRoadAddress());
                result.setAddress(localItem.getAddress());
                result.setImageLink(imageItem.getLink());
                result.setHomePageLink(localItem.getLink());

                return result;
            }

        }
        return new WishListDto();
    }

}
