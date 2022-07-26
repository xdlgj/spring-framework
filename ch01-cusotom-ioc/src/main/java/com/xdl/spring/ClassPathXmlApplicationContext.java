package com.xdl.spring;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模拟spring的实现
 * 1、通过带参构造器获得对应的配置文件
 * 2、通过dom4j解析配置文件（xml文件），得到List集合（存放bean标签中的id和class）
 * 3、通过反射得到对应的实例化对象，并放置在Map对象（遍历List集合，通过获取到的class属性，利用class.newInstance()创建实例）
 * 4、通过id属性值获取指定的实例化对象
 */
public class ClassPathXmlApplicationContext implements Factory {
    private List<Bean> beanList = new ArrayList<>(); // 存放配置文件中bean标签的信息
    private Map<String, Object> beanMap = new HashMap<>(); //存放实例化好的对象，通过id获取对应的对象
    /*通过带参构造器获得对应的配置文件*/
    public ClassPathXmlApplicationContext(String fileName) {
        /*通过dom4j解析配置文件（xml文件），得到List集合（存放bean标签中的id和class）*/
        this.parseXml(fileName);
        /*获取实例化对象*/
        this.instanceBean();
    }

    /**
     * 通过反射得到对应的实例化对象，并放置在Map对象
     * 1、判断对象集合是否为空，如果不为空，则遍历集合，获取对象的id和class属性
     * 2、通过类的全路径名反射获取实例化对象，Class.forName()
     * 3、将对应的id和实例化好的bean对象放置到map对象中
     */
    private void instanceBean() {
        //1、判断对象集合是否为空，如果不为空，则遍历集合，获取对象的id和class属性
        if (beanList != null && beanList.size() > 0) {
            for (Bean bean : beanList) {
                String id = bean.getId();
                String clazz = bean.getClazz();
                try {
                    //2、通过类的全路径名反射获取实例化对象，Class.forName()
                    Object object = Class.forName(clazz).newInstance();
                    //3、将对应的id和实例化好的bean对象放置到map对象中
                    beanMap.put(id, object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过dom4j解析配置配置文件，得到List集合
     * 1、获取解析器
     * 2、获取配置文件的URL
     * 3、通过解析器解析配置文件
     * 4、通过xpath语法解析，获取beans标签下的所有bean标签
     * 5、通过指定的解析语法，解析文档对象，返回元素集合
     * 6、判断元素集合是否为空
     * 7、如果元素集合不为空，遍历集合
     * 8、获取bean标签元素的属性（id和class）
     * 9、获取Bean对象，将id和class值设置到对象中，在将对象设置到Bean集合中
     * @param fileName
     */
    private void parseXml(String fileName) {
        //1、获取解析器
        SAXReader saxReader = new SAXReader();
        //2、获取配置文件的路径
        URL url = this.getClass().getClassLoader().getResource(fileName);
        try {
            //3、通过解析器解析配置文件
            Document document = saxReader.read(url);
            //4、通过xpath语法解析，获取beans标签下的所有bean标签
            XPath xPath = document.createXPath("beans/bean");
            //5、通过指定的解析语法，解析文档对象，返回元素集合
            List<Element> elements = xPath.selectNodes(document);
            //6、判断元素集合是否为空
            if (elements != null && elements.size() > 0) {
                //7、如果元素集合不为空，遍历集合
                for (Element element : elements) {
                    //8、获取bean标签元素的属性（id和class）
                    String id = element.attributeValue("id");
                    String clazz = element.attributeValue("class");
                    //8、获取bean标签元素的属性（id和class）
                    Bean bean = new Bean(id, clazz);
                    //9、获取Bean对象，将id和class值设置到对象中，在将对象设置到Bean集合中
                    beanList.add(bean);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过id获取对应的map对象中的value（实例化好的bean对象）
     * @param id
     * @return
     */
    @Override
    public Object getBean(String id) {
        Object object = beanMap.get(id);
        return object;
    }
}
