package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;

@Log4j2
@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
public class UploadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/upload.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadFolder = "c:\\upload"; //폴더생성
        byte[] buffer = new byte[1024 * 1024];

        Collection<Part> parts = req.getParts();

        parts.forEach(part -> {

            String type = part.getContentType();
            if(type== null) {
                log.info("partName:" + part.getName());
                return;
            }

            String fileName = part.getSubmittedFileName();

            String uploadFileName = System.currentTimeMillis()+"_"+ fileName;

            log.info(fileName);


            //원본 파일 저장
            try(InputStream in = part.getInputStream();
                OutputStream fos = new FileOutputStream(uploadFolder + File.separator +uploadFileName);
            )   {
                while(true) {
                    int count = in.read(buffer);
                    if(count== -1) { break;}
                    fos.write(buffer,0,count);

                }
            } catch (Exception e) {
            } // 원본 파일 저장 끝

            //이미지에 대해서만 섬네일
            if(type.startsWith("image")){
            try {
                Thumbnails.of(new File(uploadFolder + File.separator +uploadFileName))
                        .size(100, 100)
                        .toFile(uploadFolder + File.separator+"s_"+uploadFileName);
            }catch(Exception e){

            }

            }

            log.info("---------------------------------------");


        });//for each
    }
}