package code;

public class Block {
    boolean first;
    public String data;
    public String timestamp;
    public String prevHash;

    public Block(String data, String prevHash){
        this.prevHash = prevHash;
        this.timestamp = String.valueOf(System.currentTimeMillis());
        this.first = false;
        this.data = data;
    }

    public Block(String data){
        this.first = true;
        this.timestamp = String.valueOf(System.currentTimeMillis());
        this.data = data;
    }

    public String GetData(){
        return this.data;
    }
    public String GetTimestamp(){
        return this.timestamp;
    }
    public String GetPrevHash(){
        return this.prevHash;
    }
}
