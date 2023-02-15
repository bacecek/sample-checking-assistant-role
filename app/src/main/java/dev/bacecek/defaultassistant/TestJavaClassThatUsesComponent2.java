package dev.bacecek.defaultassistant;

public class TestJavaClassThatUsesComponent2 {

    TestJavaClassThatUsesComponent2() {
        TestJavaClass2InComponent instance = ApplicationComponent.getInstance().testJava2();
    }

}
