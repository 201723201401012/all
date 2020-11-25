package cc.insistor.service.impl;

import cc.insistor.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author cc
 */

@Service
public class FileUploadServiceImpl implements FileUploadService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    @Override
    public String upload(MultipartFile uploadFile, HttpServletRequest req) {
        // 上传的文件将保存在项目运行目录下的 uploadFile 文件夹，
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        System.out.println(realPath);

        // 并且在 uploadFile 文件夹中通过日期对上传的文件归类保存
        // 比如：/uploadFile/2019/06/06/32091e5f-c9e9-4506-9567-43e724f1fe37.png
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        // 对上传的文件重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            // 文件保存
            uploadFile.transferTo(new File(folder, newName));

            // 返回上传文件的访问路径
            String filePath = req.getScheme() + "://" + req.getServerName()
                    + ":" + req.getServerPort() + "/cc/uploadFile/" + format + newName;
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }
}
