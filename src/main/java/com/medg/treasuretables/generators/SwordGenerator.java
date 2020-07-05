package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.data.MagicTreasureDB;

import java.util.ArrayList;
import java.util.List;

public class SwordGenerator extends Generator {

    private final MagicTreasureDB magicTreasureDB;
    private final Dice dice;

    SwordGenerator(MagicTreasureDB magicTreasureDB, Dice dice) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
    }

    public String getMagicSword() {
        String swordType = getMagicSwordType();
        String swordBonus = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.SWORD).description;
        String[] intelligenceCapabilitiesCommunication = magicTreasureDB.getSwordIntelligence(dice.rollPercent()).split(":");
        String intelligence = intelligenceCapabilitiesCommunication[0];
        String capabilities = intelligenceCapabilitiesCommunication[1];
        String communication = intelligenceCapabilitiesCommunication[2];
        String unusual = "(NSA)";
        if(intelligence.equals("none")) {
            return swordType + " " + swordBonus + " " + unusual;
        } else {
            StringBuilder specialAbilities = new StringBuilder();
            int numPrimary = 0;
            if(capabilities.equals("1") || capabilities.equals("2") ||
                capabilities.equals("3")) {
                numPrimary = Integer.parseInt(capabilities);
            } else {
                numPrimary = 3;
            }
            List<String> primaryAbilities = new ArrayList<>();
            if(capabilities.equals("3R")) {
                primaryAbilities.add("read languages");
            } else if(capabilities.equals("3R+")) {
                primaryAbilities.add("read languages and magic");
            }
            boolean rollTwice = false;
            boolean hasExtraordinary = false;
            int i = 0;
            while(i < numPrimary) {
                String primary = magicTreasureDB.getSwordPrimary(dice.rollPercent());
                if(primary.equals("roll twice")) {
                    if(rollTwice == false) {
                        rollTwice = true;
                        numPrimary += 1;
                    }
                } else if(primary.equals("extraordinary") && !hasExtraordinary) {
                    hasExtraordinary = true;
                    String extraordinary = getExtraordinaryAndSpecialPurpose();
                    primaryAbilities.add(extraordinary);
                    i++;
                } else {
                    primaryAbilities.add(primary);
                    i++;
                }
            }

            if(capabilities.equals("3R+")) {
                String extraordinary = getExtraordinaryAndSpecialPurpose();
                primaryAbilities.add(extraordinary);
            }

            String swordAlignment = magicTreasureDB.getSwordAlignment(dice.rollPercent());

            specialAbilities.append("INT ").append(intelligence).append(" alignment: ").append(swordAlignment)
                .append(" ").append("communication: ").append(communication).append(" ");
            if(communication.contains("speech")) {
                String languages = magicTreasureDB.getSwordLanguages(dice.rollPercent());
                specialAbilities.append("languages: ").append(languages).append(" ");
            }
            specialAbilities.append("primary abilities: ");
            for(int j = 0; j < primaryAbilities.size(); j++) {
                specialAbilities.append(primaryAbilities.get(j));
                if(j < primaryAbilities.size() - 1) {
                    specialAbilities.append(", ");
                }
            }

            return swordType + " "  + swordBonus + " " + specialAbilities.toString();

        }
    }


    private String getExtraordinaryAndSpecialPurpose() {
        int i = 0;
        int numExtraordinary = 1;
        StringBuilder extraordinaryAbilities = new StringBuilder();
        boolean rollTwice = false;
        boolean hasSpecialPurpose = false;
        while(i < numExtraordinary) {
            String extraordinary = magicTreasureDB.getSwordExtraordinary(dice.rollPercent());
            if(extraordinary.equals("roll twice")) {
                if(rollTwice == false) {
                    rollTwice = true;
                    numExtraordinary++;
                }
            } else if(extraordinary.equals("1+special") && !hasSpecialPurpose) {
                hasSpecialPurpose = true;
            } else {
                extraordinaryAbilities.append(extraordinary);
                if(i < numExtraordinary - 1) {
                    extraordinaryAbilities.append(", ");
                }
                i++;
            }
        }

        if(hasSpecialPurpose) {
            extraordinaryAbilities.append(", ");
            String specialPurpose = magicTreasureDB.getSwordSpecialPurpose(dice.rollPercent());
            String specialPurposePower = magicTreasureDB.getSwordSpecialPurposePower(dice.rollPercent());
            extraordinaryAbilities.append("special purpose: ").append(specialPurpose).append(", ");
            extraordinaryAbilities.append("special purpose power: " + specialPurposePower);
        }

        return extraordinaryAbilities.toString();
    }

    private String getMagicSwordType() {
        int roll = dice.rollPercent();
        if(roll <= 70) {
            return "longsword";
        } else if(roll <= 90) {
            return "broadsword";
        } else if(roll <= 95) {
            return "shortsword";
        } else if(roll <= 99) {
            return "bastard sword";
        } else return "two-handed sword";
    }

}
