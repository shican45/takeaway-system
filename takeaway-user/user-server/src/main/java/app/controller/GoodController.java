package controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import .entity.Good;
import .service.GoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Good)表控制层
 *
 * @author makejava
 * @since 2021-10-28 16:16:32
 */
@RestController
@RequestMapping("good")
public class GoodController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private GoodService goodService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param good 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Good> page, Good good) {
        return success(this.goodService.page(page, new QueryWrapper<>(good)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.goodService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param good 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Good good) {
        return success(this.goodService.save(good));
    }

    /**
     * 修改数据
     *
     * @param good 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Good good) {
        return success(this.goodService.updateById(good));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.goodService.removeByIds(idList));
    }
}

