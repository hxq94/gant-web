package generator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneratorUtil {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorUtil.class);
    private static final Map<String, String> prop = initProp();

    private static Map<String, String> initProp() {
        Map<String, String> map = new HashMap<>();
        map.put("author", System.getProperty("user.name"));
        try {
            String userHome = System.getProperty("user.home");

            Path userHomePath = Paths.get(userHome, new String[]{".generator"});
            if (Files.notExists(userHomePath, new LinkOption[0])) {
                Files.createDirectories(userHomePath, new FileAttribute[0]);
                logger.info("Create the [.generator] directory in [user.home] success!");
            }
            Path profile = Paths.get(userHomePath.toString(), new String[]{"generator.json"});
            if (Files.notExists(profile, new LinkOption[0])) {
                Files.createFile(profile, new FileAttribute[0]);
                logger.info("Create the [generator.json] file success!");
                BufferedWriter bw = Files.newBufferedWriter(profile, new OpenOption[0]);
                bw.write(JSON.toJSONString(map, new SerializerFeature[]{SerializerFeature.PrettyFormat}));
                bw.close();
                logger.info("Write config data in [generator.json] file success!");
            }
            String jsonStr = (String) Files.lines(profile).collect(Collectors.joining());
            logger.info("generator config = \n {}", jsonStr);

            map = (Map) JSON.parseObject(jsonStr, Map.class);
        } catch (Exception e) {
            logger.error("init generator config error", e);
        }
        return map;
    }

    public static String getConfig(String key) {
        return (String) prop.get(key);
    }

    public static String getAuthor() {
        return getConfig("author");
    }

    public static void fillJavaDocLine(JavaElement element, String comment, ClassType classType) {
        element.addJavaDocLine("/**");
        element.addJavaDocLine(" * " + comment + (classType != null ? classType.getComment() : ""));
        element.addJavaDocLine(" * ");
        element.addJavaDocLine(" * @author " + getAuthor() + " " + getDateByYYYYMD());
        element.addJavaDocLine(" * @since 南阳理工学院");
        element.addJavaDocLine(" */");
    }

    private static String getDateByYYYYMD() {
        return new SimpleDateFormat("yyyy-M-d").format(new Date());
    }
}
