package com.example.bravo.action;

import com.example.bravo.vo.FightDetailVO;
import com.example.bravo.vo.PersonVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fight {
    PersonVO p1;
    PersonVO p2;
    public List<FightDetailVO> execute(){
        List<FightDetailVO> fight=new ArrayList<>();
        int curRound=0;
        int total=p1.getAttrs().get("speed")+p2.getAttrs().get("speed");
        while (p1.getAttrs().get("blood")>0&&p2.getAttrs().get("blood")>0){
            Map<String,Object> info=null;
            if(curRound%total<p1.getAttrs().get("speed")){
                info=oneRound(p1, p2);
            }else{
                info=oneRound(p2, p1);
            }
            Integer[] blood={p1.getAttrs().get("blood"),p2.getAttrs().get("blood")};
            String[] res={info.get("state").toString(),info.get("state").toString()+"ed"};
            String[] step={"","-"+info.get("damage").toString()};
            fight.add(new FightDetailVO(blood,res,step,info.get("detail").toString()));
            curRound=curRound+Math.min(p1.getAttrs().get("speed"),p2.getAttrs().get("speed"));
        }
        if (p1.getAttrs().get("blood")>0){
            Integer[] blood={p1.getAttrs().get("blood"),0};
            String[] res={"victory","fail"};
            String[] step={"yeah!!",""};
            fight.add(new FightDetailVO(blood,res,step,p1.getName()+"胜利"));
            return fight;
        }else if(p2.getAttrs().get("blood")>0){
            Integer[] blood={0,p2.getAttrs().get("blood")};
            String[] res={"fail","victory"};
            String[] step={"","yeah!!"};
            fight.add(new FightDetailVO(blood,res,step,p2.getName()+"胜利"));
            return fight;
        }
        Integer[] blood={0,0};
        String[] res={"soso","soso"};
        String[] step={"yeah!!","yeah!!"};
        fight.add(new FightDetailVO(blood,res,step,"平分秋色"));
        return fight;
    }

    private Map<String,Object> oneRound(PersonVO p1, PersonVO p2) {
        Map<String,Object> map=new HashMap<>();
        String detail=new String();
        int damage=0;
        if((int)(Math.random()*100)<p1.getAttrs().get("goalRate")){
            detail=p1.getName()+"发起攻击,造成";
            if((int)(Math.random()*100)<=p1.getAttrs().get("comboRate")){
                detail+=((damage=(p1.getAttrs().get("attack")+(int)(p1.getAttrs().get("attack")*p1.getAttrs().get("comboWave")/100)))+"暴击伤害;");
                map.put("state","combo");
            }else{
                detail+=((damage=p1.getAttrs().get("attack"))+"普通伤害;");
                map.put("state","normal");
            }
            p2.getAttrs().put("blood",p2.getAttrs().get("blood")-damage);
            detail+=(p2.getName()+"血量-"+(damage+"")+",剩余血量"+p2.getAttrs().get("blood"));
        }else{
            detail=p1.getName()+"发起攻击,然而并没有命中";
            map.put("state","miss");
        }
        map.put("detail",detail);
        map.put("damage",damage);
        return map;
    }

    public Fight(PersonVO p1, PersonVO p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
