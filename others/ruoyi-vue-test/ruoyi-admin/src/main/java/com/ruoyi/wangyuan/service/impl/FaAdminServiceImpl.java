package com.ruoyi.wangyuan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wangyuan.mapper.FaAdminMapper;
import com.ruoyi.wangyuan.domain.FaAdmin;
import com.ruoyi.wangyuan.service.IFaAdminService;

/**
 * 管理员Service业务层处理
 * 
 * @author li
 * @date 2020-07-24
 */
@Service
public class FaAdminServiceImpl implements IFaAdminService 
{
    @Autowired
    private FaAdminMapper faAdminMapper;

    /**
     * 查询管理员
     * 
     * @param id 管理员ID
     * @return 管理员
     */
    @Override
    public FaAdmin selectFaAdminById(Integer id)
    {
        return faAdminMapper.selectFaAdminById(id);
    }

    /**
     * 查询管理员列表
     * 
     * @param faAdmin 管理员
     * @return 管理员
     */
    @Override
    public List<FaAdmin> selectFaAdminList(FaAdmin faAdmin)
    {
        return faAdminMapper.selectFaAdminList(faAdmin);
    }

    /**
     * 新增管理员
     * 
     * @param faAdmin 管理员
     * @return 结果
     */
    @Override
    public int insertFaAdmin(FaAdmin faAdmin)
    {
        return faAdminMapper.insertFaAdmin(faAdmin);
    }

    /**
     * 修改管理员
     * 
     * @param faAdmin 管理员
     * @return 结果
     */
    @Override
    public int updateFaAdmin(FaAdmin faAdmin)
    {
        return faAdminMapper.updateFaAdmin(faAdmin);
    }

    /**
     * 批量删除管理员
     * 
     * @param ids 需要删除的管理员ID
     * @return 结果
     */
    @Override
    public int deleteFaAdminByIds(Integer[] ids)
    {
        return faAdminMapper.deleteFaAdminByIds(ids);
    }

    /**
     * 删除管理员信息
     * 
     * @param id 管理员ID
     * @return 结果
     */
    @Override
    public int deleteFaAdminById(Integer id)
    {
        return faAdminMapper.deleteFaAdminById(id);
    }
}
