package com.yian.sportplay2.dao;

import com.yian.sportplay2.bean.MainMenu;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface MenuDao {
    public List<MainMenu> getMenus();
}
