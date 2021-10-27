package app.service.impl;

import app.service.RiderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.Rider;
import domain.dao.RiderDao;
import org.springframework.stereotype.Service;

/**
 * (Rider)表服务实现类
 *
 * @author makejava
 * @since 2021-10-27 17:20:03
 */
@Service("riderService")
public class RiderServiceImpl extends ServiceImpl<RiderDao, Rider> implements RiderService {

}

