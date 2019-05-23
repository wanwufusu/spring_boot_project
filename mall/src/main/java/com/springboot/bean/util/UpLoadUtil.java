package com.springboot.bean.util;

import com.springboot.bean.MallStorage;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/23
 * @since 1.0.0
 */

public class UpLoadUtil {

    public static MallStorage upload(MultipartFile file, HttpServletRequest request, MallStorage mallStorage) throws IOException {
        String filename = file.getOriginalFilename();
        mallStorage.setName(filename);
        mallStorage.setSize((int)file.getSize());
        mallStorage.setType(file.getContentType());
        filename = UUID.randomUUID().toString() + filename;
        String[] strings = filename.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        filename = stringBuilder.toString();
        mallStorage.setKey(filename);
        //String realPath = request.getSession().getServletContext().getContextPath();
        String path = ResourceUtils.getURL("classpath:").getPath() + "/storage/" + filename;
        //Path path1 = Paths.get("/storage", filename);
        mallStorage.setDeleted(false);
        //String realPath = "upload/";
        File newFile = new File(path.toString());
        mallStorage.setUrl("http://localhost:8088/admin/storage/" + filename);
        //String absolutePath = newFile.getAbsolutePath();
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        return mallStorage;
    }
}
