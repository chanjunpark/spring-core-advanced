package com.example.springcoreadvanced.trace.strategy;

import com.example.springcoreadvanced.trace.strategy.code.strategy.ContextV1;
import com.example.springcoreadvanced.trace.strategy.code.strategy.Strategy;
import com.example.springcoreadvanced.trace.strategy.code.strategy.StrategyLogic1;
import com.example.springcoreadvanced.trace.strategy.code.strategy.StrategyLogic2;
import com.example.springcoreadvanced.trace.template.code.AbstractTemplate;
import com.example.springcoreadvanced.trace.template.code.SubClassLogic1;
import com.example.springcoreadvanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {

        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }

    private void logic2() {

        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };
        log.info("클래스 이름  = {}", template1.getClass());
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };
        log.info("클래스 이름  = {}", template2.getClass());
        template2.execute();
    }

    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);

        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);

        contextV2.execute();

    }

    @Test
    void strategyV2() {
        Strategy strategy1 = () -> log.info("비즈니스 로직 1 실행");
        ContextV1 contextV1 = new ContextV1(strategy1);

        contextV1.execute();

        Strategy strategy2 = () -> log.info("비즈니스 로직 2 실행");
        ContextV1 contextV2 = new ContextV1(strategy2);

        contextV2.execute();

        ContextV1 contextV3 = new ContextV1(() -> log.info("비즈니스 로직 3 실행"));
        contextV3.execute();

    }
}
