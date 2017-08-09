package com.example.bravo.action;

import com.example.bravo.po.User;

import java.util.HashMap;
import java.util.Map;

public class Birth {
    User user;
    Map<String,Integer> attrs=new HashMap<>();

    public Birth(User user) {
        this.user = user;
        attrs.put("attack",200+(int)(20*Math.random()));
        attrs.put("speed",400+(int)(40*Math.random()));
        attrs.put("blood",4000+(int)(100*Math.random()));
        attrs.put("goalRate",70+(int)(10*Math.random()));
        attrs.put("comboRate",50+(int)(20*Math.random()));
        attrs.put("comboWave",30+(int)(20*Math.random()));
    }

    public Map<String, Integer> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Integer> attrs) {
        this.attrs = attrs;
    }
}
