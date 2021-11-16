package com.example.restraunt;

import com.example.restraunt.wishList.WishListDto;
import com.example.restraunt.wishList.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restraunt")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    //위시 리스트 추가
    @PostMapping("")
    public WishListDto add(@RequestParam WishListDto wishListDto){

        return wishListService.add(wishListDto);
    }
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }
    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);
    }
    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }
}
