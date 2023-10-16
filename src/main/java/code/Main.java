package code;

public class Main {
    public static void main(String[] args) {
        Block testblock = new Block("This is the test for a block");
        System.out.println("A Block is created: " + testblock.GetData() + " at timestamp: " + testblock.GetTimestamp());

        Chain newblockchain = new Chain();
        newblockchain.readLastBlock();
        newblockchain.addBlock("Hallo das ist meine neue Blockchain!");

        System.out.println("Last Block in Chain: " + newblockchain.readLastBlock());
    }
}
