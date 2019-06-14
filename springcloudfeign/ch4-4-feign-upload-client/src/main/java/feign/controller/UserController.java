package feign.controller;

import feign.model.User;
import feign.service.IUserFeignClient;
import feign.service.UserFeignService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserFeignService userFeignService;

	@Autowired //默认是按照类型装配注入的,当找到实现类大于1时在根据byName注入
	private IUserFeignClient userFeignClient;

	/**
	 * 用于演示Feign的Get请求多参数传递
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser( @RequestBody @ApiParam(name="用户",value="传入json格式",required=true) User user){
		return userFeignService.addUser(user);
	}

	/**
	 * 用于演示Feign的Post请求多参数传递
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser( @RequestBody @ApiParam(name="用户",value="传入json格式",required=true) User user){
		return userFeignService.updateUser(user);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String getUser( @RequestParam String username){
		return userFeignClient.getUser(username);
	}
}
