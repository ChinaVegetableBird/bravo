package com.example.bravo.goal;

import com.example.bravo.action.Fight;
import com.example.bravo.vo.PersonVO;

import java.util.HashMap;
import java.util.Map;

public class FirstFight {
    public static void main(String [] args){
        Map<String,Integer> m1=new HashMap<>();
        m1.put("attack",200);
        m1.put("speed",400);
        m1.put("blood",1000);
        m1.put("goalRate",30);
        m1.put("comboRate",50);
        m1.put("comboWave",30);
        Map<String,Integer> m2=new HashMap<>();
        m2.put("attack",200);
        m2.put("speed",200);
        m2.put("blood",1000);
        m2.put("goalRate",70);
        m2.put("comboRate",50);
        m2.put("comboWave",30);
        PersonVO p1=new PersonVO(1L,"零老师",m1);
        PersonVO p2=new PersonVO(1L,"熊宝",m2);
        new Fight(p1,p2).execute();
    }
}
