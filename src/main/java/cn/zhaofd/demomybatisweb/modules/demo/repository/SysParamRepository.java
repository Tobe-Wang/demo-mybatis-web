/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.repository;


import cn.zhaofd.demomybatisweb.modules.demo.dto.SysParam;
import cn.zhaofd.demomybatisweb.modules.demo.dto.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 注解方式配置的MyBatis应用示例
 */
@Mapper
public interface SysParamRepository {
    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysParam
     */
    @Select("select id, code, value, regtime from sys_param where id = #{id}")
    SysParam findById(Integer id);

    /**
     * 查询
     *
     * @param params 查询参数
     * @return {@code List<SysParam>}
     */
    @SelectProvider(type = SysParamSqlBuilder.class, method = "find")
    List<SysParam> find(Map<String, Object> params);

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return {@code List<SysUser>}
     */
    @SelectProvider(type = SysParamSqlBuilder.class, method = "findPage")
    List<SysParam> findPage(Map<String, Object> params);

    /**
     * 新增保存
     *
     * @param sysParam DTO数据传输对象
     * @return 受影响行数
     */
    @Insert("insert into sys_param(code, value, regtime) values(#{code}, #{value}, #{regtime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysParam sysParam);

    /**
     * 批量保存
     *
     * @param list 批量保存的集合
     * @return 受影响行数
     */
    @Insert({"<script>", """
            insert into sys_param(code, value, regtime) values
            <foreach item="item" collection="list" separator=",">
                (#{item.code}, #{item.value}, #{item.regtime})
            </foreach>
            """, "</script>"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveAll(List<SysParam> list);

    /**
     * 修改
     *
     * @param sysParam DTO数据传输对象
     * @return 受影响行数
     */
    @Update("update sys_param set code = #{code}, value = #{value}, regtime = #{regtime} where id = #{id}")
    int update(SysParam sysParam);

    /**
     * 删除
     *
     * @param id 主键ID
     * @return 受影响行数
     */
    @Delete("delete from sys_param where id = #{id}")
    int deleteById(Integer id);

    /**
     * 批量删除
     *
     * @param list 批量删除的集合
     * @return 受影响行数
     */
    @Delete({"<script>", """
            delete from sys_param where id in (
            <foreach item='item' collection='list' separator=','>
                #{item}
            </foreach>
            )
            """, "</script>"})
    int delete(List<Integer> list);

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return 总记录数
     */
    @SelectProvider(type = SysParamSqlBuilder.class, method = "count")
    Long count(Map<String, Object> params);

    /**
     * 调用存储过程
     *
     * @param name 姓名
     * @return {@code List<SysUser>}
     */
    // @formatter:off
    @Results(id = "mapSysUser", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "regtime", column = "regtime"),
            @Result(property = "listSysAddress", javaType = ArrayList.class, column = "id", many = @Many(select = "cn.zhaofd.demomybatisweb.modules.demo.repository.SysAddressRepository.findByUserId"))
    })
    // @formatter on
    @Select("{call proc_user(#{name,mode=IN,javaType=String,jdbcType=VARCHAR})}")
    @Options(statementType = StatementType.CALLABLE)
    List<SysUser> procUser(String name);
}
