package com.example.bravo.vo;

import java.util.Map;

public class FightDetailVO {
    Integer[] blood;
    String[] res;
    String [] step;

    public String[] getStep() {
        return step;
    }

    public void setStep(String[] step) {
        this.step = step;
    }

    String detail;

    public Integer[] getBlood() {
        return blood;
    }

    public void setBlood(Integer[] blood) {
        this.blood = blood;
    }

    public String[] getRes() {
        return res;
    }

    public void setRes(String[] res) {
        this.res = res;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public FightDetailVO(Integer[] blood, String[] res, String[] step, String detail) {
        this.blood = blood;
        this.res = res;
        this.step = step;
        this.detail = detail;
    }
}
