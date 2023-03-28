package com.example.springcoreadvanced.trace.logtrace;

import com.example.springcoreadvanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
