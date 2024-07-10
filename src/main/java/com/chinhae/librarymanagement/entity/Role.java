package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Role)实体类
 *  权限表
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Integer roleID;

    private String roleName;

}

