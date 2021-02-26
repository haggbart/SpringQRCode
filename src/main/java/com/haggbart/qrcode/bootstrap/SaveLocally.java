package com.haggbart.qrcode.bootstrap;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class SaveLocally {

    @PostConstruct
    void init() throws IOException {
        File file = QRCode.from("https://i.imgur.com/qwus7MD.jpg").to(ImageType.PNG).file();

        BufferedImage img = ImageIO.read(file);
        ImageIO.write(img, "png", new File("src\\main\\resources\\static\\funnybanana.png"));
    }
}
