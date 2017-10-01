package com.example.bravo.controller;

import com.example.bravo.action.Birth;
import com.example.bravo.dao.AttrRepository;
import com.example.bravo.dao.UserRepository;
import com.example.bravo.po.Attr;
import com.example.bravo.po.User;
import com.example.bravo.query.UserQuery;
import com.example.bravo.vo.VO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Resource
    HttpServletRequest request;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AttrRepository attrRepository;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "userQuery",dataType = "UserQuery",paramType = "body")
    })
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public VO<Integer> register(@RequestBody UserQuery userQuery){
        User user=new User();
        BeanUtils.copyProperties(userQuery,user);
        Map<String,Integer> attrs=new Birth(user=userRepository.save(user)).getAttrs();
        List<Attr> attrList=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:attrs.entrySet()){
            Attr attr=new Attr(user.getId(),entry.getKey(),entry.getValue());
            attrList.add(attr);
        }
        attrRepository.save(attrList);
        return new VO(user);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",dataType = "string",paramType = "query")
    })
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public VO<Integer> login(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password){
        User user=userRepository.findByNameAndPassword(username,password);
        if(user!=null){
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("password",password);
            return new VO<Integer>(12);
        }else{
            return new VO<Integer>(null);
        }
    }
}
