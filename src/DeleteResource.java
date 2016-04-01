import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DeleteResource.java 
 * .DeleteResource
 * @author: zhangzhi
 * @date: 2014年3月19日 下午1:07:33
 */

/**
 * 
 * @author zhangzhi
 */
public class DeleteResource {

	/**
	 * 1.在Android Studio中编译运行或者运行task lint，如果在cmd运行，则在工程目录运行gradlew :lint
	 * 2.运行结束后会在工程目录生成\build\outputs\lint-results.xml文件
	 * 3.修改本程序中的路径为{ProjectHome}\build\outputs\lint-results.xml,然后运行即可。
	 * 4.由于资源引用问题，请重复运行前面三步骤直到资源全部删除为止。
	 * 5.lint有可能会错误，造成误删除，所以删除完成后可以检测工程是否完整，如果不完整则Reverse Resource
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args){
		parserXml("H:\\launcher_vr\\BoxLauncherEclipse\\build\\outputs\\lint-results.xml");
	}

	public static void parserXml(String fileName) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			Element rootElement = document.getDocumentElement();
			NodeList nodeList = rootElement.getElementsByTagName("issue");
			
			if (nodeList != null) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Element element = (Element) nodeList.item(i);
					String id = element.getAttribute("id");
					if ("UnusedResources".equals(id)) {
						NodeList location = element.getElementsByTagName("location");
						if (location != null) {
							for (int j = 0; j < location.getLength(); j++) {
								Element file = (Element) location.item(j);
								String path = file.getAttribute("file");
								
								if(!path.contains("\\res\\values")){
									File f = new File(path);
									f.delete();
									System.out.println(path);
								}
							}
						}
					}
				}
			}
			System.out.println("clean finish");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
