package com.njbdqn.mysee.dao;

import com.njbdqn.mysee.vo.Bankcards;

import java.util.List;

public interface ICardDAO {

    public List<Bankcards> findCand(Bankcards card);
}
