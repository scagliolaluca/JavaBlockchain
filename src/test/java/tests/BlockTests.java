package tests;

import code.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockTests {

    @Test
    public void testVerifyFirstBlockFlag1() {

        //when
        Block block = new Block("Test Data");

        //then
        Assertions.assertTrue(block.GetFirstFlag());
    }

    @Test
    public void testVerifyFirstBlockFlag2() {

        //when
        Block block = new Block("Test Data", "Hash of First Block");

        //then
        Assertions.assertFalse(block.GetFirstFlag());
    }

    @Test
    public void testGetData() {

        //when
        Block block = new Block("Test Data");

        //then
        Assertions.assertEquals("Test Data", block.GetData());
    }

    @Test
    public void testGetTimestamp() {

        //when
        Block block = new Block("Test Data");

        //then
        Assertions.assertNotNull(block.GetTimestamp());
    }

    @Test
    public void testGetHashFirstBlock() {

        //when
        Block block = new Block("Test Data");

        //then
        Assertions.assertNull(block.GetPrevHash());
    }

    @Test
    public void testGetHashBlock() {

        //when
        Block secondBlock = new Block("Test Data", "Hash of First Block");

        //then
        Assertions.assertEquals("Hash of First Block", secondBlock.GetPrevHash());
    }

}
