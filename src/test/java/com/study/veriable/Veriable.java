package com.study.veriable;

import com.study.veriable.impl.CommonHandler;
import com.study.veriable.impl.TimeHandler;
import com.study.veriable.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;

public class Veriable {

    private static Map<String, Class> handlers = new HashMap<>();

    private static Class handler = HandlerClassUtil.getHandler();

    static {
        HandlerClassUtil.getHandler();
        handlers.put("pgs", handler);
        handlers.put("pgd", TypeHandler.class);
        handlers.put("azf", CommonHandler.class);
    }

    public Map<String,Class> query(){
        return handlers;
    }

}
