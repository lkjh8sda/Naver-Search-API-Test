package com.example.restraunt.wishlist;

import com.example.restraunt.wishList.WishListEntity;
import com.example.restraunt.wishList.WishListRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class WishListRepositoryTest {
    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setReadAddress("address");
        wishList.setReadAddress("readAddress");
        wishList.setHomePageLink("link");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }

    @Test
    public void saveTest(){
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }
    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

        expected.setTitle("update test");
        wishListRepository.save(expected);

        Assertions.assertEquals(1, wishListRepository.listAll().size());
        Assertions.assertEquals("update test", expected.getTitle());
    }
    @Test
    public void findByIdTest(){
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        var expected = wishListRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());

    }
    @Test
    public void deleteTest(){
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(0, count);
    }
    @Test
    public void listAllTest(){
        var wishListEntity1 = create();
        var wishListEntity2 = create();
        wishListRepository.save(wishListEntity1);
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(2, count);
    }
}