package com.ruoyi.wangyuan.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.wangyuan.domain.FaAdmin;

/**
 * 管理员Mapper接口
 * 
 * @author li
 * @date 2020-07-24
 */
public interface FaAdminMapper
{
    /**
     * 查询管理员
     * 
     * @param id 管理员ID
     * @return 管理员
     */
    public FaAdmin selectFaAdminById(Integer id);

    /**
     * 查询管理员列表
     * 
     * @param faAdmin 管理员
     * @return 管理员集合
     */
    public List<FaAdmin> selectFaAdminList(FaAdmin faAdmin);

    /**
     * 新增管理员
     * 
     * @param faAdmin 管理员
     * @return 结果
     */
    public int insertFaAdmin(FaAdmin faAdmin);

    /**
     * 修改管理员
     * 
     * @param faAdmin 管理员
     * @return 结果
     */
    public int updateFaAdmin(FaAdmin faAdmin);

    /**
     * 删除管理员
     * 
     * @param id 管理员ID
     * @return 结果
     */
    public int deleteFaAdminById(Integer id);

    /**
     * 批量删除管理员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFaAdminByIds(Integer[] ids);
}
