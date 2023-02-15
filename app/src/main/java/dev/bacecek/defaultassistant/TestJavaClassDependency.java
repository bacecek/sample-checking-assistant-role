package dev.bacecek.defaultassistant;

public class TestJavaClassDependency {
    TestJavaClassThatUsesComponent kek = getKek();

    public void lol(TestJavaClassThatUsesComponent component) {
        kek = component;
    }

    private TestJavaClassThatUsesComponent getKek() {
        return kek;
    }

}
