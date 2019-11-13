package com.wonoh.point;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonoh.redis.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/point")
public class PointController {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;
    private final PointRedisRepository pointRedisRepository;

    @GetMapping
    public ResponseEntity savePoint() throws JsonProcessingException {
        Point point = Point.builder()
                        .id("1")
                        .amount(3L)
                        .refreshTime(LocalDateTime.now())
                        .build();


        //redisTemplate.opsForValue().set("point",objectMapper.writeValueAsString(point));
        pointRedisRepository.save(point);

        Point point2 = Point.builder()
                .id("2")
                .amount(3L)
                .refreshTime(LocalDateTime.now())
                .build();
        //redisTemplate.opsForValue().append("point",objectMapper.writeValueAsString(point2));
        return ResponseEntity.ok(pointRedisRepository.findAll());

    }
}
