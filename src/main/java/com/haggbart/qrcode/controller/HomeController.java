package com.haggbart.qrcode.controller;

import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/funnybanana")
    public void qrcode(HttpServletResponse response) throws IOException {

        byte[] image = QRCode.from("https://i.imgur.com/qwus7MD.jpg").stream().toByteArray();

        response.setContentType("image/png");
        InputStream is = new ByteArrayInputStream(image);
        IOUtils.copy(is, response.getOutputStream());
    }
}
