package com.yupi.yupicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.yupicturebackend.model.dto.space.SpaceAddRequest;
import com.yupi.yupicturebackend.model.dto.space.SpaceQueryRequest;
import com.yupi.yupicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupicturebackend.model.entity.User;
import com.yupi.yupicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author a1234
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-04-28 23:08:48
*/
public interface SpaceService extends IService<Space> {
    /**
     * 创建空间
     * @return
     */
    public long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验空间
     */
    void validSpace(Space space, boolean add);

    /**
     * 根据空间级别自动填充限额数据
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 获取空间包装类（单条）
     *
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 获取空间包装类（分页）
     *
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 用户认证
     */
    void checkSpaceAuth(User loginUser, Space space);
}
