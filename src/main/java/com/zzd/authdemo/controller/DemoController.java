package com.zzd.authdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zzd
 * @date : 2022/11/4
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("hello")
    // @PreAuthorize("hasAuthority('hello')")
    @PreAuthorize("@ex.hasAuthority('dev.code.pull')")
    public String hello() {
        return "hello security";
    }
}
