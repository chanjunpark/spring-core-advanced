package com.example.springcoreadvanced.trace.strategy;

import com.example.springcoreadvanced.trace.strategy.code.strategy.ContextV2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void testContextV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비즈니스 로직 1 실행"));
        contextV2.execute(() -> log.info("비즈니스 로직 2 실행"));
    }
}
