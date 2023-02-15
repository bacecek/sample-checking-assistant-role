package dev.bacecek.defaultassistant;

import java.util.Optional;

public interface ApplicationComponent {

    MainActivity activity();

    TestJavaClassInComponent testJava();

    TestJavaClass2InComponent testJava2();

    Optional<TestJavaClass3InComponent> testJava3();

    TestJavaClass4InComponent testJava4();

    TestJavaClass5InComponent testJava5();

    TestJavaClass6InComponent testJava6();

    TestJavaClass7InComponent testJava7();

    TestJavaClass8InComponent testJava8();

    TestJavaClass9InComponent testJava9();

    TestJavaClass10InComponent testJava10();

    TestKtClassFactory ktClassFactory();

    static ApplicationComponent getInstance() {
        return new ApplicationComponent() {
            @Override
            public MainActivity activity() {
                return null;
            }

            @Override
            public TestJavaClassInComponent testJava() {
                return null;
            }

            @Override
            public TestJavaClass2InComponent testJava2() {
                return null;
            }

            @Override
            public Optional<TestJavaClass3InComponent> testJava3() {
                return null;
            }

            @Override
            public TestJavaClass4InComponent testJava4() {
                return null;
            }

            @Override
            public TestJavaClass5InComponent testJava5() {
                return null;
            }

            @Override
            public TestJavaClass6InComponent testJava6() {
                return null;
            }

            @Override
            public TestJavaClass7InComponent testJava7() {
                return null;
            }

            @Override
            public TestJavaClass8InComponent testJava8() {
                return null;
            }

            @Override
            public TestJavaClass9InComponent testJava9() {
                return null;
            }

            @Override
            public TestJavaClass10InComponent testJava10() {
                return null;
            }

            @Override
            public TestKtClassFactory ktClassFactory() {
                return null;
            }
        };
    }

}
