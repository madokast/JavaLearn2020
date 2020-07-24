package com.ruoyi.wangyuan.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wangyuan.domain.FaAdmin;
import com.ruoyi.wangyuan.service.IFaAdminService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 管理员Controller
 * 
 * @author li
 * @date 2020-07-24
 */
@RestController
@RequestMapping("/wangyuan/admin")
public class FaAdminController extends BaseController
{
    @Autowired
    private IFaAdminService faAdminService;

    /**
     * 查询管理员列表
     */
    @PreAuthorize("@ss.hasPermi('wangyuan:admin:list')")
    @GetMapping("/list")
    public TableDataInfo list(FaAdmin faAdmin)
    {
        startPage();
        List<FaAdmin> list = faAdminService.selectFaAdminList(faAdmin);
        return getDataTable(list);
    }

    /**
     * 导出管理员列表
     */
    @PreAuthorize("@ss.hasPermi('wangyuan:admin:export')")
    @Log(title = "管理员", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(FaAdmin faAdmin)
    {
        List<FaAdmin> list = faAdminService.selectFaAdminList(faAdmin);
        ExcelUtil<FaAdmin> util = new ExcelUtil<FaAdmin>(FaAdmin.class);
        return util.exportExcel(list, "admin");
    }

    /**
     * 获取管理员详细信息
     */
    @PreAuthorize("@ss.hasPermi('wangyuan:admin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(faAdminService.selectFaAdminById(id));
    }

    /**
     * 新增管理员
     */
    @PreAuthorize("@ss.hasPermi('wangyuan:admin:add')")
    @Log(title = "管理员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FaAdmin faAdmin)
    {
        return toAjax(faAdminService.insertFaAdmin(faAdmin));
    }

    /**
     * 修改管理员
     */
    @PreAuthorize("@ss.hasPermi('wangyuan:admin:edit')")
    @Log(title = "管理员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FaAdmin faAdmin)
    {
        return toAjax(faAdminService.updateFaAdmin(faAdmin));
    }

    /**
     * 删除管理员
     */
    @PreAuthorize("@ss.hasPermi('wangyuan:admin:remove')")
    @Log(title = "管理员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(faAdminService.deleteFaAdminByIds(ids));
    }
}
