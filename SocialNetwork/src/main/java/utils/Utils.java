package utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lilly_94 on 23.11.2015.
 */
public class Utils {
    final  static String repistory="F:/repistory/";
    static  InputStream inputStream = null;
    public static String savePart(Part part){
        String fileName=null;
        System.out.println(new File("e").getAbsolutePath());
        if (part != null) {
            try {
                inputStream = part.getInputStream();
                fileName=repistory+new Object().hashCode()+".jpg";
                File file=new File(fileName);
                file.createNewFile();
                FileOutputStream out=new FileOutputStream(fileName);
                out.write(IOUtils.toByteArray(inputStream));
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return fileName;
    }

}
