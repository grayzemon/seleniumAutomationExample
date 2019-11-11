package com.grayzemon.systemtest.utils;
import static com.grayzemon.systemtest.utils.LoggingFactory.*;


/**
 * Created by Graham.Smith on 13/09/2017.
 *
 */

public class TestException extends RuntimeException {

    public TestException(){
        super();
    }

    public TestException(String msg){
        super(msg);
        log.error(msg);
    }

    public TestException(String msg, Exception e){
        super(msg);
        log.error(e);
    }
}
