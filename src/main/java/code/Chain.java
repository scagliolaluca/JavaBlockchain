package code;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class Chain {
    List<Block> blocks = new ArrayList<>();

    public void addBlock(String data){

        Block newBlock;
        if (blocks.isEmpty()) {
            // If the blockchain is empty, create the first block
            newBlock = new Block(data);
        } else {
            // If there are existing blocks, create a new block with ref. to old block
            Block previousBlock = blocks.get(blocks.size() -1);
            String prevHash = calculateHash(previousBlock);
            newBlock = new Block(data, prevHash);
        }

        // Add new Block to Blockchain
        blocks.add(newBlock);
    }

    // return last Block
    public String readLastBlock(){
        Block lastBlock = blocks.get(blocks.size() -1);
        return readBlock(lastBlock);
    }

    // Read Block
    public String readBlock(Block block){
        String data = block.GetData();
        String timestamp = block.GetTimestamp();
        String prevHash = block.GetPrevHash();
        String totalData = "Data: " + data + " Timestamp: " + timestamp + " PreviousHash: " + prevHash;
        return totalData;
    }

    // Hash function to compute the hash of a block
    private String calculateHash(Block block) {
        String data = block.GetData();
        String timestamp = block.GetTimestamp();
        String prevHash = block.GetPrevHash();
        String dataToHash = data + timestamp + prevHash;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            return toHexString(md.digest(dataToHash.getBytes(StandardCharsets.UTF_8)));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e){
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return null; // Todo: Throw error not return
        }
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
