package cuit.epoch.pymjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.epoch.pymjl.entity.User;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/27 0:56
 **/
public interface UserService extends IService<User> {
    /**
     * 注册
     */
    void register();

    /**
     * 得到用户
     *
     * @param id id
     * @return {@code User}
     */
    User get(Long id);
}
