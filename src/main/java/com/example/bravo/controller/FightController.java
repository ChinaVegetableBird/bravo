package com.example.bravo.controller;

import com.example.bravo.action.Birth;
import com.example.bravo.action.Fight;
import com.example.bravo.dao.AttrRepository;
import com.example.bravo.dao.UserRepository;
import com.example.bravo.po.Attr;
import com.example.bravo.po.User;
import com.example.bravo.query.UserQuery;
import com.example.bravo.vo.FightDetailVO;
import com.example.bravo.vo.PersonVO;
import com.example.bravo.vo.VO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/fight")
public class FightController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AttrRepository attrRepository;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "id1",dataType = "long",paramType = "query"),
        @ApiImplicitParam(name = "id2",dataType = "long",paramType = "query")
    })
    @RequestMapping(value="/vs",method= RequestMethod.GET)
    public VO<List<FightDetailVO>> vs(@RequestParam(value = "id1") Long id1,
                                      @RequestParam(value = "id2") Long id2){
        List<Attr> attr1=attrRepository.findByUid(id1);
        List<Attr> attr2=attrRepository.findByUid(id2);
        User user1=userRepository.findOne(id1);
        User user2=userRepository.findOne(id2);
        Map<String,Integer> map1=new HashMap<>();
        for(Attr curAttr:attr1){
            map1.put(curAttr.getName(),curAttr.getValue());
        }
        PersonVO p1=new PersonVO(user1.getId(),user1.getName(),map1);
        Map<String,Integer> map2=new HashMap<>();
        for(Attr curAttr:attr2){
            map2.put(curAttr.getName(),curAttr.getValue());
        }
        PersonVO p2=new PersonVO(user2.getId(),user2.getName(),map2);
        return new VO(new Fight(p1,p2).execute());
    }
}
