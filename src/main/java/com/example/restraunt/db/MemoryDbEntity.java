package com.example.restraunt.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {

    //db에 0 들어갈 수 있게 Integer로
    protected Integer index;

}
