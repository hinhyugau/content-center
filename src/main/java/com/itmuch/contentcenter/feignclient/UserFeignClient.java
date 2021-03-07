package com.itmuch.contentcenter.feignclient;

import com.itmuch.contentcenter.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: User feign
 * @Author bryan
 * @Date 2021/3/7 5:50 下午
 * @Version 1.0
 */
//@FeignClient(name = "user-center",configuration = UserFeignClientConfiguration.class)
@FeignClient(name = "user-center")
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    public UserDTO findUserBuId(@PathVariable Integer id);
}