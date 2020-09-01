package dto;


public class UserMessageWithHashDto extends UserMessageDto {

    private int hash;
    private long timestamp;

    public UserMessageWithHashDto(String userName, String message) {
        super(userName, message);
        this.timestamp = System.currentTimeMillis();

    }

    public UserMessageWithHashDto() {

    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


}
