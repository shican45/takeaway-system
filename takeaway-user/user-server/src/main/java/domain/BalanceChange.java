package domain;

import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (BalanceChange)表实体类
 *
 * @author makejava
 * @since 2021-10-26 09:57:21
 */
@SuppressWarnings("serial")
public class BalanceChange extends Model<BalanceChange> {
    //资金变动id
    private BigInteger id;
    //用户id
    private BigInteger userId;
    //骑手id
    private BigInteger riderId;
    //商户id
    private BigInteger merchantId;
    //变动详情
    private String change;
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

    public BigInteger getRiderId() {
        return riderId;
    }

    public void setRiderId(BigInteger riderId) {
        this.riderId = riderId;
    }

    public BigInteger getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
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

