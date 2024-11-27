package com.ict.edu2.domain.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ict.edu2.domain.guestbook.service.GuestBookService;
import com.ict.edu2.domain.guestbook.vo.GuestBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guestbook")
public class GuestBookAPIController {
    @Autowired
    private GuestBookService guestBookService;

    // 전체보기
    @GetMapping("/list")
    @ResponseBody
    public List<GuestBookVO> getGuestBookList() {
        return guestBookService.getGuestBookList();
    }

    // 상세보기
    @GetMapping("/detail")
    public GuestBookVO getGuestBookDetail(@RequestParam(name = "gb_idx") String gb_idx) {
      System.out.println("Received gb_idx: " + gb_idx); // 디버깅 로그
        return guestBookService.getGuestBookDetail(gb_idx);
    }

}