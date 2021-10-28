package app.service.impl;

import app.service.BalanceChangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.BalanceChange;
import domain.dao.BalanceChangeDao;
import org.springframework.stereotype.Service;

/**
 * (BalanceChange)表服务实现类
 *
 * @author makejava
 * @since 2021-10-26 09:57:21
 */
@Service("balanceChangeService")
public class BalanceChangeServiceImpl extends ServiceImpl<BalanceChangeDao, BalanceChange> implements BalanceChangeService {

}

