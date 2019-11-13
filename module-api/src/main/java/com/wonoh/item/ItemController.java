package com.wonoh.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonoh.redis.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final RedisTemplate<String,String> redisTemplate;
    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity saveItem() throws JsonProcessingException {

        Item item = Item.builder()
                    .id(1L)
                    .name("iphone")
                    .price(200000)
                    .build();

        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("item",objectMapper.writeValueAsString(item));

        return ResponseEntity.ok(valueOperations.get("item"));
    }
}
