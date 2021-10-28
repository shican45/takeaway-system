package domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Shopcar)表实体类
 *
 * @author makejava
 * @since 2021-10-26 09:57:19
 */
@SuppressWarnings("serial")
public class Shopcar extends Model<Shopcar> {
    //购物车主键
    private BigInteger id;
    //用户id
    private BigInteger userId;
    //商户id
    private BigInteger merchantId;
    //商品id
    private BigInteger goodId;
    //商品名称
    private String name;
    //商品数量
    private Object num;
    //商品价格
    private BigDecimal price;
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

    public BigInteger getGoodId() {
        return goodId;
    }

    public void setGoodId(BigInteger goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNum() {
        return num;
    }

    public void setNum(Object num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

