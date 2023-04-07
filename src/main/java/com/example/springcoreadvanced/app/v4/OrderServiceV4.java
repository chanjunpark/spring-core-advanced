package com.example.springcoreadvanced.app.v4;

import com.example.springcoreadvanced.trace.TraceStatus;
import com.example.springcoreadvanced.trace.logtrace.LogTrace;
import com.example.springcoreadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepositoryV4.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }
}
