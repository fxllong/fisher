package com.fisher.tsc.console.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * msg
 * @author 
 */
public class Msg implements Serializable {
    private Long id;

    /**
     * 消息唯一标识
     */
    private String msgKey;

    /**
     * 消息体json
     */
    private String msgBody;

    /**
     * 消息源系统

     */
    private String sourceService;

    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 最大可重复投递次数
     */
    private Integer maxRetryCount;

    /**
     * 重试次数
     */
    private Integer retryCount = 30;

    /**
     * 调用方状态查询接口地址
     */
    private String sourceStatesUri;

    /**
     * 消息状态,0 待发送
        1 已发送
        2 已消费
     */
    private Integer msgState;

    private Date createTime;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 延迟超过多少秒算超时
     */
    private Integer timeoutDelay;

    /**
     * 具体超时时间点
     */
    private Date timeoutTime;

    /**
     * 消息是否死亡
     */
    private Boolean isDead;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSourceService() {
        return sourceService;
    }

    public void setSourceService(String sourceService) {
        this.sourceService = sourceService;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    public void setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getSourceStatesUri() {
        return sourceStatesUri;
    }

    public void setSourceStatesUri(String sourceStatesUri) {
        this.sourceStatesUri = sourceStatesUri;
    }

    public Integer getMsgState() {
        return msgState;
    }

    public void setMsgState(Integer msgState) {
        this.msgState = msgState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getTimeoutDelay() {
        return timeoutDelay;
    }

    public void setTimeoutDelay(Integer timeoutDelay) {
        this.timeoutDelay = timeoutDelay;
    }

    public Date getTimeoutTime() {
        return timeoutTime;
    }

    public void setTimeoutTime(Date timeoutTime) {
        this.timeoutTime = timeoutTime;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(Boolean isDead) {
        this.isDead = isDead;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Msg other = (Msg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMsgKey() == null ? other.getMsgKey() == null : this.getMsgKey().equals(other.getMsgKey()))
            && (this.getMsgBody() == null ? other.getMsgBody() == null : this.getMsgBody().equals(other.getMsgBody()))
            && (this.getSourceService() == null ? other.getSourceService() == null : this.getSourceService().equals(other.getSourceService()))
            && (this.getQueueName() == null ? other.getQueueName() == null : this.getQueueName().equals(other.getQueueName()))
            && (this.getMaxRetryCount() == null ? other.getMaxRetryCount() == null : this.getMaxRetryCount().equals(other.getMaxRetryCount()))
            && (this.getRetryCount() == null ? other.getRetryCount() == null : this.getRetryCount().equals(other.getRetryCount()))
            && (this.getSourceStatesUri() == null ? other.getSourceStatesUri() == null : this.getSourceStatesUri().equals(other.getSourceStatesUri()))
            && (this.getMsgState() == null ? other.getMsgState() == null : this.getMsgState().equals(other.getMsgState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getTimeoutDelay() == null ? other.getTimeoutDelay() == null : this.getTimeoutDelay().equals(other.getTimeoutDelay()))
            && (this.getTimeoutTime() == null ? other.getTimeoutTime() == null : this.getTimeoutTime().equals(other.getTimeoutTime()))
            && (this.getIsDead() == null ? other.getIsDead() == null : this.getIsDead().equals(other.getIsDead()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMsgKey() == null) ? 0 : getMsgKey().hashCode());
        result = prime * result + ((getMsgBody() == null) ? 0 : getMsgBody().hashCode());
        result = prime * result + ((getSourceService() == null) ? 0 : getSourceService().hashCode());
        result = prime * result + ((getQueueName() == null) ? 0 : getQueueName().hashCode());
        result = prime * result + ((getMaxRetryCount() == null) ? 0 : getMaxRetryCount().hashCode());
        result = prime * result + ((getRetryCount() == null) ? 0 : getRetryCount().hashCode());
        result = prime * result + ((getSourceStatesUri() == null) ? 0 : getSourceStatesUri().hashCode());
        result = prime * result + ((getMsgState() == null) ? 0 : getMsgState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getTimeoutDelay() == null) ? 0 : getTimeoutDelay().hashCode());
        result = prime * result + ((getTimeoutTime() == null) ? 0 : getTimeoutTime().hashCode());
        result = prime * result + ((getIsDead() == null) ? 0 : getIsDead().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msgKey=").append(msgKey);
        sb.append(", msgBody=").append(msgBody);
        sb.append(", sourceService=").append(sourceService);
        sb.append(", queueName=").append(queueName);
        sb.append(", maxRetryCount=").append(maxRetryCount);
        sb.append(", retryCount=").append(retryCount);
        sb.append(", sourceStatesUri=").append(sourceStatesUri);
        sb.append(", msgState=").append(msgState);
        sb.append(", createTime=").append(createTime);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", timeoutDelay=").append(timeoutDelay);
        sb.append(", timeoutTime=").append(timeoutTime);
        sb.append(", isDead=").append(isDead);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}