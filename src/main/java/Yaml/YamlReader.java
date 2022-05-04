package Yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class YamlReader<T> {

    public Map<String, Object> readYaml(String yamlName) {
        Yaml yaml = new Yaml();
        Map<String, Object> data = new HashMap<>();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/" + yamlName + ".yaml");
            data = yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public  <T> T readYaml(Class<T> clazz, String yamlName) {
        Yaml yaml = new Yaml();
        T data = null;
        try {
            data = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/" + yamlName + ".yaml");
            data = yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
