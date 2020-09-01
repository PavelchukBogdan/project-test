package dto;


import java.io.Serializable;

public class UserMessageDto implements Serializable {

    private Long id;
    private String userName;
    private String message;

    public UserMessageDto(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public UserMessageDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Person{"
                + "userName='" + userName + '\''
                + ", message=" + message
                + '}';
    }
}
