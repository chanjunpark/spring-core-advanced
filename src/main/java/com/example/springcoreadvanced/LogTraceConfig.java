package com.example.springcoreadvanced;

import com.example.springcoreadvanced.trace.logtrace.FiledLogTrace;
import com.example.springcoreadvanced.trace.logtrace.LogTrace;
import com.example.springcoreadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        //return new FiledLogTrace();
        return new ThreadLocalLogTrace();
    }

}
