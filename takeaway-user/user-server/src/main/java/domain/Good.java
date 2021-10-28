package domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Good)表实体类
 *
 * @author makejava
 * @since 2021-10-27 17:19:14
 */
@SuppressWarnings("serial")
public class Good extends Model<Good> {
    //商品主键
    private BigInteger id;
    //商户id
    private BigInteger merchantId;
    //种类id
    private BigInteger categoryId;
    //商品名称
    private String name;
    //商品描述
    private String description;
    //商品价格
    private BigDecimal price;
    //商品限购数量
    private Object limitNum;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastModifyTime;
    //商品状态
    private Byte isBanned;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Object getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Object limitNum) {
        this.limitNum = limitNum;
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

    public Byte getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Byte isBanned) {
        this.isBanned = isBanned;
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

