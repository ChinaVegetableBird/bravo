package com.example.bravo.action;

import com.example.bravo.vo.PersonVO;

public class Fight {
    PersonVO p1;
    PersonVO p2;
    public int execute(){
        int curRound=0;
        int total=p1.getAttrs().get("speed")+p2.getAttrs().get("speed");
        while (p1.getAttrs().get("blood")>0&&p2.getAttrs().get("blood")>0){
            if(curRound%total<p1.getAttrs().get("speed")){
                oneRound(p1, p2);
            }else{
                oneRound(p2, p1);
            }
            curRound=curRound+Math.min(p1.getAttrs().get("speed"),p2.getAttrs().get("speed"));
        }
        if (p1.getAttrs().get("blood")>0){
            System.out.println(p1.getName()+"胜利");
            return 1;
        }else if(p2.getAttrs().get("blood")>0){
            System.out.println(p2.getName()+"胜利");
            return 2;
        }
        System.out.println("平分秋色");
        return 0;
    }

    private void oneRound(PersonVO p1, PersonVO p2) {
        int damage=0;
        if((int)(Math.random()*100)<p1.getAttrs().get("goalRate")){
            System.out.print(p1.getName()+"发起攻击,造成");
            if((int)(Math.random()*100)<=p1.getAttrs().get("comboRate")){
                System.out.print((damage=(p1.getAttrs().get("attack")+(int)(p1.getAttrs().get("attack")*p1.getAttrs().get("comboWave")/100)))+"暴击伤害;");
            }else{
                System.out.print((damage=p1.getAttrs().get("attack"))+"普通伤害;");
            }
            p2.getAttrs().put("blood",p2.getAttrs().get("blood")-damage);
            System.out.println(p2.getName()+"血量-"+(damage+"")+",剩余血量"+p2.getAttrs().get("blood"));
        }else{
            System.out.println(p1.getName()+"发起攻击,然而并没有命中");
        }
    }

    public Fight(PersonVO p1, PersonVO p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
