package controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import .entity.BalanceChange;
import .service.BalanceChangeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (BalanceChange)表控制层
 *
 * @author makejava
 * @since 2021-10-26 09:57:21
 */
@RestController
@RequestMapping("balanceChange")
public class BalanceChangeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BalanceChangeService balanceChangeService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param balanceChange 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BalanceChange> page, BalanceChange balanceChange) {
        return success(this.balanceChangeService.page(page, new QueryWrapper<>(balanceChange)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.balanceChangeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param balanceChange 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BalanceChange balanceChange) {
        return success(this.balanceChangeService.save(balanceChange));
    }

    /**
     * 修改数据
     *
     * @param balanceChange 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BalanceChange balanceChange) {
        return success(this.balanceChangeService.updateById(balanceChange));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.balanceChangeService.removeByIds(idList));
    }
}

