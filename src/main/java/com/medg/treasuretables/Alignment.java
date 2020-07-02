package com.medg.treasuretables;

public enum Alignment {

    CG("chaotic good"), CN("chaotic neutral"), CE("chaotic evil"),
    NG("neutral good"), N("true neutral"), NE("neutral evil"),
    LG("lawful good"), LN("lawful neutral"), LE("lawful evil");

    private String name;

    Alignment(String name) {
        this.name = name;
    }
}
