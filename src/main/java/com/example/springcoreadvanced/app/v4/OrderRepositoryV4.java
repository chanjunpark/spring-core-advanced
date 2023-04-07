package com.example.springcoreadvanced.app.v4;

import com.example.springcoreadvanced.trace.TraceStatus;
import com.example.springcoreadvanced.trace.logtrace.LogTrace;
import com.example.springcoreadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("exception!");
                }
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepository.save()");
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
