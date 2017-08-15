package com.example.bravo.controller;

import com.example.bravo.action.Fight;
import com.example.bravo.dao.AttrRepository;
import com.example.bravo.dao.ResRepository;
import com.example.bravo.dao.UserRepository;
import com.example.bravo.po.Attr;
import com.example.bravo.po.User;
import com.example.bravo.vo.FightDetailVO;
import com.example.bravo.vo.PersonVO;
import com.example.bravo.vo.VO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(path = "/res")
@PropertySource("application.properties")
public class ResController {
    @Value("${file.location}")
    String location="";

    @Autowired
    ResRepository resRepository;


    @ApiImplicitParams({
    })
    @RequestMapping(value="/kind/list",method= RequestMethod.GET)
    public VO<List<String>> getKinds(){
        List<String> kinds=new ArrayList<>();
        kinds.add("combo");
        kinds.add("normal");
        kinds.add("miss");
        kinds.add("victory");
        kinds.add("fail");
        kinds.add("comboed");
        kinds.add("normaled");
        kinds.add("missed");
        return new VO(kinds);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "file",dataType = "file",paramType = "body")
    })
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public VO<String> addPic(@RequestParam(value = "type") String type,
                             @RequestParam(value = "file") MultipartFile file){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyMMdd");
        String fold=simpleDateFormat.format(date);
        try {
            File dicFile=new File(location+fold);
            dicFile.mkdirs();
            File realFile=new File(location+fold+"//"+file.getOriginalFilename());
            realFile.createNewFile();
            file.transferTo(realFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new VO<String>(null);
        }
        return new VO<String>("1");
    }
}
