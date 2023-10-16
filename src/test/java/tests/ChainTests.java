package tests;

import code.Block;
import code.Chain;
import code.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChainTests {
    @Test // Test for reading from Chain without any Blocks
    public void ReadFromEmptyChain() {

        //given
        Chain newChain = new Chain();

        //then
        final NullPointerException ex = Assertions.assertThrows(NullPointerException.class,
                () -> newChain.readLastBlock());
        Assertions.assertEquals("Blockchain is empty!", ex.getMessage());
    }

    @Test // Test for getting last Block from Chain without any Blocks
    public void GetFromEmptyChain() {

        //given
        Chain newChain = new Chain();

        //then
        final NullPointerException ex = Assertions.assertThrows(NullPointerException.class,
                () -> newChain.getLastBlock());
        Assertions.assertEquals("Blockchain is empty!", ex.getMessage());
    }

    @Test // Test if block can be added to Chain
    public void AddBlock() {

        //given
        Chain newChain = new Chain();

        //when
        newChain.addBlock("This is the first Block in this Chain!");

        //then
        Assertions.assertNotNull(newChain.getLastBlock());
        Assertions.assertNotNull(newChain.readLastBlock());
    }
    @Test // Test if Block with Data can be added and read to/from Chain
    public void AddReadDataFromChain() {

        //given
        Chain newChain = new Chain();
        newChain.addBlock("This is the first Block in this Chain!");

        //when
        String output = newChain.readBlockData(newChain.getLastBlock());

        //then
        Assertions.assertEquals("This is the first Block in this Chain!", output);
    }

    @Test
    public void ReadHashFromChain() {

        //given
        Chain newChain = new Chain();
        newChain.addBlock("This is the first Block in this Chain!");

        //when
        String output = newChain.readBlockHash(newChain.getLastBlock());

        //then
        Assertions.assertNull(output);
    }

    @Test
    public void AddReadHashFromChain() {

        //given
        Chain newChain = new Chain();
        newChain.addBlock("This is the first Block in this Chain!");
        newChain.addBlock("This is the second Block in this Chain!");

        //when
        String output = newChain.readBlockHash(newChain.getLastBlock());

        //then
        Assertions.assertNotNull(output);
    }


    @Test
    public void ReadTimeFromChain() {

        //given
        Chain newChain = new Chain();
        newChain.addBlock("This is the first Block in this Chain!");

        //when
        String output = newChain.readBlockTime(newChain.getLastBlock());

        //then
        Assertions.assertNotNull(output);
    }
}
