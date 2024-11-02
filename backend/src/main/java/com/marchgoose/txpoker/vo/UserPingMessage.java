package com.marchgoose.txpoker.vo;

/**
 * @author steeveen
 * @date 2024/10/31 23:01
 */
public class UserPingMessage {
    private String senderId;
    private String targetUserId;

    // Getters and Setters
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }
}
