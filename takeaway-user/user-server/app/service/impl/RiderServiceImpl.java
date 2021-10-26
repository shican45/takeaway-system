package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import .dao.RiderDao;
import .entity.Rider;
import .service.RiderService;
import org.springframework.stereotype.Service;

/**
 * (Rider)表服务实现类
 *
 * @author makejava
 * @since 2021-10-26 09:57:19
 */
@Service("riderService")
public class RiderServiceImpl extends ServiceImpl<RiderDao, Rider> implements RiderService {

}

