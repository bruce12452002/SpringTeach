package home.bruce.lesson11;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

@Component
@Indexed // maven 必需使用 spring-context-indexer，否則編譯不會錯，但不生效
/**
 * 執行後，會在 target/classes/META-INF 生成 spring.components 檔案，可以加快加載速度
 * CandidateComponentsIndexLoader.class
 */
public class Bird {
}
