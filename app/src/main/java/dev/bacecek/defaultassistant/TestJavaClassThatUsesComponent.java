package dev.bacecek.defaultassistant;

public class TestJavaClassThatUsesComponent {

    TestJavaClassThatUsesComponent() {
        TestJavaClassInComponent instance = ApplicationComponent.getInstance().testJava();
    }

}
