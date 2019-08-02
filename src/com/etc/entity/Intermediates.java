package com.etc.entity;

public class Intermediates {

    private int id;
    private String name;
    private String abbreciation;
    private String chinaName;
    private String casno;
    private String activeIngredient;
    private String market;
    private String type;
    private int line;//数据库中的排号，用于判读是否有下一条或上一条
    
    
    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        this.line = line;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    
    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAbbreciation() {
        return abbreciation;
    }
    public void setAbbreciation(String abbreciation) {
        this.abbreciation = abbreciation;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getChinaName() {
        return chinaName;
    }
    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }
    public String getCasno() {
        return casno;
    }
    public void setCasno(String casno) {
        this.casno = casno;
    }
    public String getActiveIngredient() {
        return activeIngredient;
    }
    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }
}
