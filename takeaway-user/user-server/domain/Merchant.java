package entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Merchant)表实体类
 *
 * @author makejava
 * @since 2021-10-27 17:19:13
 */
@SuppressWarnings("serial")
public class Merchant extends Model<Merchant> {
    //商户主键
    private BigInteger id;
    //商户名称
    private String name;
    //商户账号
    private String account;
    //商户密码
    private String password;
    //商户电话
    private String phone;
    //商户地址
    private String address;
    //商户余额
    private BigDecimal balance;
    //商户描述
    private String description;
    //营业状态
    private String businessStatus;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastModifyTime;
    //商户状态
    private Byte isBanned;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
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
