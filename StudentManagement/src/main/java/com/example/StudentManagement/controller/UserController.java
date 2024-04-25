package com.example.StudentManagement.controller;

import com.example.StudentManagement.common.Result;
import com.example.StudentManagement.entity.Params;
import com.example.StudentManagement.service.UserService;
import com.example.StudentManagement.entity.User;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/findall")
    public Result findAllUser(){
        List<User> userList =userService.findAllUser();
        return Result.success(userList);
    }

    @GetMapping("/login")
    public Result login(@RequestBody User user){
        User loginUser = userService.login(user);
        return Result.success(loginUser);
    }

    @GetMapping("/findUser")
//    public Result findBySearch(Params params){
    public Result findBySearch(){
        Params paramTest = new Params();
        paramTest.setUserID("c20565914");
        paramTest.setTelephone("555-5678");
        List<User> userList = userService.findBySearch(paramTest);
        return Result.success(userList);
    }


    @GetMapping("/addUser")
//    @PostMapping("/addUser")
//    public Result save(@RequestBody User user){
    public Result addUser(){
        /**
         * 确保从客户端发起对 "/addUser" 路径的请求时使用的是 POST 方法，而不是 GET 方法
         * @return
         */
        User userTest = new User("c20565920","luckyboy","Elon Musk","elon.M@Tesla.com","1113 Apple Street, Washton","555-8081");
        userService.addUser(userTest);
        return Result.success(userTest);
    }

    @GetMapping("/modifyUser")
//    @PostMapping("/modifyUser")
//    public Result modifyUser(@RequestBody User user){
    public Result modifyUser(){
        // test to modify c20565914
        List<User> userList = (List<User>)findBySearch().getData();
        User user = userList.get(0);
        user.setEmail("ysy@emal.com");
        if (user.getUserID() == null){
            return Result.error("Already exist this user");
        }
        userService.update(user);
        return Result.success();
    }

    @GetMapping("/testDelete")
//    @DeleteMapping("/{id}")
//    public Result deleteUser(@PathVariable String id){
    public Result deleteUser(){
        // test to delete c20565914
        List<User> userList = (List<User>)findBySearch().getData();
        User user = userList.get(0);
//        userService.delete(id);
        userService.delete(user.getUserID());
        return Result.success();
    }

}
