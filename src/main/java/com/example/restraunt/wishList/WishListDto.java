package com.example.restraunt.wishList;

import com.example.restraunt.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDto extends MemoryDbEntity {
    private int index;
    private String title;
    private String category;
    private String readAddress;
    private String address;
    private String homePageLink;
    private boolean isVisit;
    private String imageLink;
    private int visitCount;
    private LocalDateTime lastVisitDate;
}
