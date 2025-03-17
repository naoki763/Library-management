package com.example.Library_management.controller.users;

import com.example.Library_management.model.users.User;
import com.example.Library_management.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // 利用者一覧を取得
//    @GetMapping("/get")
//    public ResponseEntity<List<User>> getUsers() {
//        List<User> user = userService.getALLUsers();
//        return ResponseEntity.ok(user);
//    }
    @GetMapping("/get")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getALLUsers());
        return "users_list";
    }

    //id毎にユーザデータを取得
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable long id){
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    //id毎にユーザデータを登録
    @PostMapping("/register")
    public ResponseEntity<String> create(@RequestBody User userForm){
        User user = userService.createUser(userForm);
        return ResponseEntity.status(200).body("登録が完了しました。");
    }
    //id毎にユーザデータを更新
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@RequestBody User userForm, @PathVariable long id){
        User user = userService.editUser(userForm, id);
        return ResponseEntity.status(200).body("更新が完了しました。");
    }
    //id毎にユーザデータを削除
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        User user = userService.deleteUser(id);
        return ResponseEntity.status(200).body("削除が完了しました。");
    }


}
