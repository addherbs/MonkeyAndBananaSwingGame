package com.adipandey.monkeybanana;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Bermuda {

    public BufferedImage getBermudaImage() {
        URL bananaResource = getClass().getResource("/media/bermuda.png");
        BufferedImage bermudaImage = null;
        try {
            bermudaImage = ImageIO.read(bananaResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bermudaImage;
    }
}
