package com.imagetest;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

public class Test {

    private static String UPLOAD_DIR = "/home/ravi/IdeaProjects/ImageTest/src/main/resources/static";

//    static File input = new File("/home/ravi/IdeaProjects/ImageTest/src/main/resources/static/badge2.pdf");

    public static void main(String[] args) throws IOException {

        File input = new File("/home/ravi/IdeaProjects/ImageTest/src/main/resources/static/c7271a00-960a-11eb-8364-01b9806f3fb1.pdf");
        File whiteImage = new File(UPLOAD_DIR + File.separator  + "whiteImage.png");
        File thumbFile = new File(UPLOAD_DIR + File.separator + "thumbFile.png");
        File combinedFile = new File(UPLOAD_DIR + File.separator + "combinedFile.png");
        PDDocument document = PDDocument.load(new FileInputStream(input));
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);

        File outputfile = new File(UPLOAD_DIR + File.separator  + "test2_output.png");

        ImageIO.write(bim, "png", outputfile);
        document.close();
        createPreview(outputfile, whiteImage, combinedFile, thumbFile, 1200, 630);


        System.out.println("processForImages :: lambda invoke end at " + new Date().toString());
    }

    private static void createPreview(File originalFile, File whiteFile, File combinedFile, File thumbnailFile, int thumbWidth, int thumbHeight) {
        try {
            System.out.println("createPreview :: Execute create preview " + new Date().toString());
            Image image = ImageIO.read(originalFile);
            double thumbRatio = (double) thumbWidth / (double) thumbHeight;
            int imageWidth = (int) (image.getWidth(null) * 1.5);
            int imageHeight = (int) (image.getHeight(null) * 1.5);
            double imageRatio = (double) imageWidth / (double) imageHeight;
            if (thumbRatio < imageRatio) {
                thumbHeight = (int) (thumbWidth / imageRatio);
            } else {
                thumbWidth = (int) (thumbHeight * imageRatio);
            }
            if (imageWidth < thumbWidth && imageHeight < thumbHeight) {
                thumbWidth = imageWidth;
                thumbHeight = imageHeight;
            } else if (imageWidth < thumbWidth) {
                thumbWidth = imageWidth;
            } else if (imageHeight < thumbHeight) {
                thumbHeight = imageHeight;
            }
            //ThumbImage is responsible for generate Thumbnail image.
            BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D thumbGraphics = thumbImage.createGraphics();
            thumbGraphics.setBackground(Color.WHITE);
            thumbGraphics.setPaint(Color.WHITE);
            thumbGraphics.fillRect(0, 0, thumbWidth, thumbHeight);
            thumbGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            thumbGraphics.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
            javax.imageio.ImageIO.write(thumbImage, "png", thumbnailFile);

            //White is responsible for generate WhitePage Thumbnail image.
            //It will use for combined images.
            BufferedImage white = new BufferedImage(1200, 630, BufferedImage.TYPE_INT_RGB);
            Graphics2D whiteGraphics = white.createGraphics();
            whiteGraphics.setBackground(Color.WHITE);
            whiteGraphics.setPaint(Color.WHITE);
            whiteGraphics.fillRect(0, 0, 1200, 630);
            javax.imageio.ImageIO.write(white, "png", whiteFile);

            //Combined is responsible for generate social thumbnail with 1200*630.
            BufferedImage combined = new BufferedImage(1200, 630, BufferedImage.TYPE_INT_RGB);
            Graphics2D combinedGraphics = (Graphics2D) combined.getGraphics();
            combinedGraphics.drawImage(white, 0, 0, null);
            combinedGraphics.drawImage(thumbImage, (1200 - thumbImage.getWidth(null)) / 2, (630 - thumbImage.getHeight(null)) / 2, null);
            javax.imageio.ImageIO.write(combined, "png", combinedFile);
            System.out.println("createPreview :: Execute create preview end at " + new Date().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
