package com.wonoh.point;

import com.wonoh.redis.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRedisRepository extends CrudRepository<Point,String> {
}
