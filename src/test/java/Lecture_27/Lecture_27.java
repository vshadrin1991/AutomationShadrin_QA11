package Lecture_27;

import Yaml.YamlReader;
import org.testng.annotations.Test;

public class Lecture_27 {

    @Test
    public void test(){
        YamlReader yamlReader = new YamlReader();
        System.out.println(yamlReader.readYaml("config"));
        System.out.println(yamlReader.readYaml(Person.class, "config"));
    }
}
