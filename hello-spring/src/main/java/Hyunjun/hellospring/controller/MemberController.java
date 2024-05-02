package Hyunjun.hellospring.controller;

import Hyunjun.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    // new MemberService();로 생성해서 해도 됨. 하지만 생성자를 하는 것 보다 하나만 등록해서 쓰는게 좋음.

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
