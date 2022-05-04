package Lecture_27;

import geb.spock.GebSpec;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import spock.lang.Specification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class YamlTest extends GebSpec {

    @Test
    public void test() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("src/test/java/Lecture_27/customer.yml");

        HashMap<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
    }


}
