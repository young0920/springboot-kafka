package com.young.springbootkafka.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.springbootkafka.constant.CodeEnum;
import com.young.springbootkafka.constant.ResultBody;
import com.young.springbootkafka.exception.BizException;
import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.pojo.User2;
import com.young.springbootkafka.service.UserService;
import com.young.springbootkafka.util.BindingResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/3 11:03
 */
@RestController
@Slf4j
@RequestMapping(value = "/api")
@Api(tags = "用户管理相关接口")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("testNotBlank")
    public ResultBody<String> testNotBlank(@Valid @RequestBody User2 user2, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String bindingMessage = BindingResultUtils.getBindingMessage(bindingResult);
            return ResultBody.error(CodeEnum.CALIBRATION_FAILS.getResultCode(), bindingMessage);
        }
        return ResultBody.success("成功");
    }

    @GetMapping("/page")
    @ApiOperation("部署测试")
    public ResultBody<PageInfo<User>> testPageHelper(@RequestParam("pageNum") Integer pageNum,
                                                     @RequestParam("pageSize") Integer pageSize) {
        //紧跟着的第一个select方法会被分页
        //后面的不会被分页，除非再次调用PageHelper.startPage
        //1.非lambda 表达式
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.testPageHelper();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        //2. lambada pageInfo  分页信息
        PageInfo<User> userPageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> userService.testPageHelper());

        //3. 返回page  没有分页信息
        Page<User> userPage = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> userService.testPageHelper());

        return ResultBody.success(pageInfo);
    }

    @GetMapping("/index")
    @ApiOperation("部署测试")
    public ResultBody<String> index() {
        //插件自动设值
        User user = new User();
        user.setId("");
        user.setUsername("");
        user.setPassword("");
        user.setRealname("");
        log.info("print log!");
        return ResultBody.success("docker 测试！！！");
    }

    @PostMapping("/user")
    @ApiOperation("插入接口")
    public ResultBody<Boolean> insert(@RequestBody User user) {
        log.info("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if (user.getUsername() == null) {
            throw new BizException("-1", "用户姓名不能为空！");
        }
        return ResultBody.success(true);
    }

    @PostMapping("/testone")
    @ApiOperation("swagger示例1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    }
    )
    public ResultBody<Boolean> addUser(String username, @RequestParam(required = true) String address) {
        return ResultBody.success(true);
    }

    @GetMapping("/testwo/{id}")
    @ApiOperation("swagger示例1")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    public ResultBody<User> getUserById(@PathVariable String id) {
        User user = new User();
        user.setId(id);
        return ResultBody.success(user);
    }


    @PutMapping("/user")
    @ApiOperation("修改接口")
    public ResultBody<Boolean> update(@RequestBody User user) {
        log.info("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str = null;
        str.equals("111");
        return ResultBody.success(true);
    }

    @DeleteMapping("/user")
    @ApiOperation("删除接口")
    public ResultBody<Boolean> delete(@RequestBody User user) {
        log.info("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return ResultBody.success(true);
    }

    @GetMapping("/user")
    @ApiOperation("获取接口")
    public ResultBody<List<User>> findByUser(User user) {
        log.info("开始查询...");
        List<User> userList = new ArrayList<>();
        User user2 = new User();
        user2.setId("1");
        user2.setUsername("xuwujing");
        user2.setPassword("xuwujing");
        userList.add(user2);
        return ResultBody.success(userList);
    }

    @GetMapping("token")
    public String testToken() {
        return userService.testToken();
    }

}
