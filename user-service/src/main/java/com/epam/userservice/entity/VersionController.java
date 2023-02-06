package com.epam.userservice.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VersionController {

    @Value("${info.app.version}")
    private  String version;

    @GetMapping("version")
    public String getVersion() {
        return version;
    }
}
