package domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import domain.Merchant;
import org.springframework.stereotype.Repository;

/**
 * (Merchant)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-27 17:20:04
 */
@Repository
public interface MerchantDao extends BaseMapper<Merchant> {

}

