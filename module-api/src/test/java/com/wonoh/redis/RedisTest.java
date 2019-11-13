package com.wonoh.redis;

import com.wonoh.point.PointRedisRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @After
    public void tearDown() throws Exception {
        pointRedisRepository.deleteAll();
    }

    @Test
    public void 기본_등록_조회기능() {
        //given
        String id = "wonoh";
        LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
        Point point = Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();

        //when
        pointRedisRepository.save(point);

        //then
        Point savedPoint = pointRedisRepository.findById(id).get();
        log.info("{},{},{}",point.getId(),point.getAmount(),point.getRefreshTime());

        assertThat(savedPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
    }



}