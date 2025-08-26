package minispring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * @Description XML文档加载器接口
 * 用于将XML输入流解析为Document对象
 * @Author wazzyy
 * @Date 2025/8/25
 */
public interface DocumentLoader {

    /**
     * 从输入流加载XML文档
     *
     * @param inputStream XML输入流
     * @return 解析后的Document对象
     * @throws DocumentException XML解析异常
     */
    Document loadDocument(InputStream inputStream) throws DocumentException;
}
