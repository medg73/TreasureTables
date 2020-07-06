package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class MiscItemFactory {

    private List<MiscItem> miscItemList;

    public MiscItemFactory(Dice dice, MiscItemTableRoller miscItemTableRoller) {
        miscItemList = new ArrayList<>();
        miscItemList.add(new BagOfHolding(dice, miscItemTableRoller));
        miscItemList.add(new BagOfTricks(dice, miscItemTableRoller));
        miscItemList.add(new CrystalBall(dice,  miscItemTableRoller));
        miscItemList.add(new IounStones(dice,  miscItemTableRoller));
        miscItemList.add(new InstrumentOfTheBards(dice,  miscItemTableRoller));
        miscItemList.add(new IronFlask(dice,  miscItemTableRoller));
        miscItemList.add(new ManualOfGolems(dice, miscItemTableRoller));
        miscItemList.add(new MedallionOfESP(dice,  miscItemTableRoller));
        miscItemList.add(new NecklaceOfMissiles(dice,  miscItemTableRoller));
        miscItemList.add(new NecklaceOfPrayerBeads(dice,  miscItemTableRoller));
        miscItemList.add(new PearlOfPower(dice,  miscItemTableRoller));
        miscItemList.add(new PeriaptOfProofAgainstPoison(dice,  miscItemTableRoller));
        miscItemList.add(new QuaalsFeatherToken(dice,  miscItemTableRoller));
        miscItemList.add(new RobeOfTheArchmagi(dice,  miscItemTableRoller));
        miscItemList.add(new RobeOfUsefulItems(dice,  miscItemTableRoller));
    }

    public MiscItem getMiscItemByItemText(String text) {
        for(MiscItem miscItem : miscItemList) {
            if(text.equalsIgnoreCase(miscItem.getItemText())) {
                return miscItem;
            }
        }
        return null;
    }

}
