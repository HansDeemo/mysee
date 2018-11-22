package com.njbdqn.mysee.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njbdqn.mysee.dao.ICardDAO;
import com.njbdqn.mysee.vo.Bankcards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private ICardDAO cardDAO;

    public PageInfo<Bankcards> getBean(int cp,Bankcards card){
        Page<Bankcards> pg = PageHelper.startPage(cp,10);
        cardDAO.findCand(card);
        return new PageInfo<Bankcards>(pg);
    }
}
