package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;

import java.util.Arrays;
import java.util.List;

public class PotionColorGenerator {

    private Dice dice;


    private List<String> colors = Arrays.asList("black", "blue", "light blue", "dark blue", "brown",
            "light brown", "dark brown", "chartreuse",
            "coral", "cyan", "gold", "gray", "green", "light green", "dark green", "magenta",
            "mustard", "orange", "dark orange", "light orange", "pink", "purple", "dark purple", "light purple",
            "red", "light red", "dark red", "silver", "turquoise", "violet", "pale violet",
            "white", "yellow", "bright yellow", "dull yellow", "colorless", "ever-changing colors");

    private List<String> consistencies = Arrays.asList("translucent", "cloudy", "murky", "opaque",
            "bubbling", "iridescent");


    public PotionColorGenerator(Dice dice) {
        this.dice = dice;
    }

    public String getPotionColor() {
        int i = dice.getNumInLinearRange(0, colors.size() - 1);
        String color = colors.get(i);
        i = dice.getNumInLinearRange(0, consistencies.size() - 1);
        String consistency = consistencies.get(i);

        return consistency + " " + color;
    }
}
