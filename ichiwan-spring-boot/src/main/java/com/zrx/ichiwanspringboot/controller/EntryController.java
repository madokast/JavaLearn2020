package com.zrx.ichiwanspringboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrx.ichiwanspringboot.bean.DataWrapper;
import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.bean.EntryPost;
import com.zrx.ichiwanspringboot.exception.BadRequestParameterException;
import com.zrx.ichiwanspringboot.exception.ValidationFailedException;
import com.zrx.ichiwanspringboot.mail.MailWorker;
import com.zrx.ichiwanspringboot.service.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

@CrossOrigin
@RestController
@RequestMapping("/entry")
public class EntryController {

    private final Logger LOGGER = LoggerFactory.getLogger(EntryController.class);

    private final EntryService entryServiceImpl;

    private final MailWorker mailWorker;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public EntryController(EntryService entryServiceImpl, MailWorker mailWorker) {
        this.entryServiceImpl = entryServiceImpl;
        this.mailWorker = mailWorker;
    }

    @GetMapping("/find/all")
    public DataWrapper<List<EntryPost>> findAll() {
        return DataWrapper.create("all entries", entryServiceImpl.findAll());
    }

    @GetMapping("/find/page/{page}/number/{number}")
    public DataWrapper<List<EntryPost>> find(@PathVariable int page, @PathVariable int number) {
        return DataWrapper.create("find/page/" + page + "/number" + number, entryServiceImpl.findByPage(page, number));
    }

    @PostMapping("/insert")
    public DataWrapper<Null> insert(@RequestBody/*用于解析JSON对象*/ EntryItem entryItem) throws ValidationFailedException,
            JsonProcessingException {
        LOGGER.info("insert entryItem = {}", entryItem);
        entryServiceImpl.insert(entryItem);

        mailWorker.send("insert entry", objectMapper.writeValueAsString(entryItem));

        return DataWrapper.ok("entry insert");
    }

    @DeleteMapping("/last")
    public DataWrapper<Null> deleteLast() throws JsonProcessingException {
        List<EntryPost> all = entryServiceImpl.findAll();
        EntryPost lastOne = all.get(all.size() - 1);

        entryServiceImpl.deleteLastOne();

        mailWorker.send("delete last one",objectMapper.writeValueAsString(lastOne));

        return DataWrapper.ok("delete success");
    }

    @GetMapping("/project/all")
    public DataWrapper<List<String>> allProject(){
        List<String> allProjects = entryServiceImpl.findAll()
                .stream()
                .map(EntryPost::getProject)
                .distinct()
                .collect(Collectors.toList());

        return DataWrapper.create("all project",allProjects);
    }

    @GetMapping("/describing/latest")
    public DataWrapper<List<String>> latestDescribing(){
        List<String> collect = entryServiceImpl.findAll()
                .stream()
                .sorted(Comparator.comparingInt(EntryPost::getId).reversed())
                .map(EntryPost::getDescribing)
                .filter(Objects::nonNull)
                .filter(describing -> describing.length() > 0)
                .distinct()
                .limit(20)
                .collect(Collectors.toList());

        return DataWrapper.create("latest describing",collect);
    }

    @GetMapping("/total/page/by/number/{number}")
    public DataWrapper<Integer> totalPageNumber(@PathVariable int number) throws BadRequestParameterException {

        return DataWrapper.create("total page number", entryServiceImpl.totalPageNumber(number));
    }

}
