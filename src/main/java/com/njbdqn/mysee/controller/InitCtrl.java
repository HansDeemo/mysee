package com.njbdqn.mysee.controller;

import com.github.pagehelper.PageInfo;
import com.njbdqn.mysee.services.CardService;
import com.njbdqn.mysee.vo.Bankcards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class InitCtrl {
    @Autowired
    private CardService cardService;

    @InitBinder
    public void dateHandler(WebDataBinder wdb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        wdb.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }

    @RequestMapping("/search")
    public PageInfo<Bankcards> init(@RequestParam(defaultValue = "1",required = false) int cp,
                                    Bankcards card){
        return cardService.getBean(cp,card);
    }
}
