package entity;

import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Order)表实体类
 *
 * @author makejava
 * @since 2021-10-26 09:57:20
 */
@SuppressWarnings("serial")
public class Order extends Model<Order> {
    //订单主键
    private BigInteger id;
    //用户id
    private BigInteger userId;
    //商户id
    private BigInteger merchantId;
    //骑手id
    private BigInteger riderId;
    //配送费
    private Double sendCost;
    //总价
    private Double totalCost;
    //限定时间
    private Date demandTime;
    //状态
    private Object status;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastModifyTime;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }

    public BigInteger getRiderId() {
        return riderId;
    }

    public void setRiderId(BigInteger riderId) {
        this.riderId = riderId;
    }

    public Double getSendCost() {
        return sendCost;
    }

    public void setSendCost(Double sendCost) {
        this.sendCost = sendCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDemandTime() {
        return demandTime;
    }

    public void setDemandTime(Date demandTime) {
        this.demandTime = demandTime;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

