package domain;

import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (GoodCategory)表实体类
 *
 * @author makejava
 * @since 2021-10-27 17:19:13
 */
@SuppressWarnings("serial")
public class GoodCategory extends Model<GoodCategory> {
    //分类主键
    private BigInteger id;
    //商户id
    private BigInteger merchantId;
    //分类类型
    private String name;
    //分类描述
    private String description;
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

    public BigInteger getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
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

