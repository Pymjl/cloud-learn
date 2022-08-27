package cuit.epoch.pymjl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cuit.epoch.pymjl.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/27 0:42
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
