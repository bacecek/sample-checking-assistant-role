package dev.bacecek.defaultassistant;

import java.util.Optional;

public class TestJavaClassThatUsesComponent3 {

    TestJavaClassThatUsesComponent3() {
        Optional<TestJavaClass3InComponent> instance = ApplicationComponent.getInstance().testJava3();
    }

}
