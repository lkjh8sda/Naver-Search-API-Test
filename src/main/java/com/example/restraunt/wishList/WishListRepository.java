package com.example.restraunt.wishList;

import com.example.restraunt.db.MemoryDbEntity;
import com.example.restraunt.db.MemoryDbRepositoryAbstract;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
