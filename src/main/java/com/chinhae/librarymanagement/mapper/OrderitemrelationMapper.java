package com.chinhae.librarymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * (Orderitemrelation)表数据库访问层
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Mapper
public interface OrderitemrelationMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param relationid 主键
     * @return 实例对象
     */

    /**
     * 查询指定行数据
     *
     * @param orderitemrelation 查询条件
     * @param pageable          分页对象
     * @return 对象列表
     */


    /**
     * 统计总行数
     *
     * @param orderitemrelation 查询条件
     * @return 总行数
     */

    /**
     * 新增数据
     *
     * @param orderitemrelation 实例对象
     * @return 影响行数
     */

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orderitemrelation> 实例对象列表
     * @return 影响行数
     */

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orderitemrelation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */

    /**
     * 修改数据
     *
     * @param orderitemrelation 实例对象
     * @return 影响行数
     */

    /**
     * 通过主键删除数据
     *
     * @param relationid 主键
     * @return 影响行数
     */

}

