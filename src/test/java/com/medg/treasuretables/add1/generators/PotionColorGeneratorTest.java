package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.dice.RandomNumberGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PotionColorGeneratorTest {

    @Test
    public void testGetPotionColorBlack() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        Dice dice = new Dice(randomNumberGenerator);
        when(randomNumberGenerator.getNum()).thenReturn(0.0);

        PotionColorGenerator potionColorGenerator = new PotionColorGenerator(dice);
        assertEquals("translucent black", potionColorGenerator.getPotionColor());
    }

    @Test
    public void testGetPotionColorMax() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        Dice dice = new Dice(randomNumberGenerator);
        when(randomNumberGenerator.getNum()).thenReturn(0.999);

        PotionColorGenerator potionColorGenerator = new PotionColorGenerator(dice);
        assertEquals("iridescent ever-changing colors", potionColorGenerator.getPotionColor());
    }

}
