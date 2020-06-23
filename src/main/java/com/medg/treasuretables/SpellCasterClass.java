package com.medg.treasuretables;

public enum SpellCasterClass {

    CLERIC("Cleric"),DRUID("Druid"),MAGIC_USER("Magic-User"),ILLUSIONIST("Illusionist");


    private final String name;

    SpellCasterClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
