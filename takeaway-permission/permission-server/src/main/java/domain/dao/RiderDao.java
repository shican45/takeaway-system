package domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import domain.Rider;
import org.springframework.stereotype.Repository;

/**
 * (Rider)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-27 17:20:03
 */
@Repository
public interface RiderDao extends BaseMapper<Rider> {

}

