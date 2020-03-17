package com.zrx.ichiwanspringboot.controller;

import com.zrx.ichiwanspringboot.bean.EntryPost;
import com.zrx.ichiwanspringboot.service.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description
 * EntryController
 * <p>
 * Data
 * 9:47
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/entry")
public class EntryController {

    private final Logger LOGGER = LoggerFactory.getLogger(EntryController.class);

    private final EntryService entryServiceImpl;

    public EntryController(EntryService entryServiceImpl) {
        this.entryServiceImpl = entryServiceImpl;
    }

    @GetMapping("/find/all")
    public List<EntryPost> findAll(){
        // TODO 改写成标准的JSON格式
        return entryServiceImpl.findAll();
    }
}
