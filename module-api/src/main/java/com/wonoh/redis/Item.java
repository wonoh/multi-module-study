package com.wonoh.redis;

import com.wonoh.common.model.Member;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@ToString
public class Item implements Serializable {
    @Id
    private Long id;
    private String name;
    private int price;

    @Builder
    public Item(Long id,String name,int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
