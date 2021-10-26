package controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import .entity.Rider;
import .service.RiderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Rider)表控制层
 *
 * @author makejava
 * @since 2021-10-26 09:57:19
 */
@RestController
@RequestMapping("rider")
public class RiderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RiderService riderService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param rider 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Rider> page, Rider rider) {
        return success(this.riderService.page(page, new QueryWrapper<>(rider)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.riderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param rider 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Rider rider) {
        return success(this.riderService.save(rider));
    }

    /**
     * 修改数据
     *
     * @param rider 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Rider rider) {
        return success(this.riderService.updateById(rider));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.riderService.removeByIds(idList));
    }
}

