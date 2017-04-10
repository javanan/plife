package com.jlife.test.pattern;

import com.jlife.pattern.subjecobserver.Oberver;
import com.jlife.pattern.subjecobserver.OberverImpl;
import com.jlife.pattern.subjecobserver.Subject;
import com.jlife.pattern.subjecobserver.SubjectImpl;
import org.junit.Test;

/**
 * Created by chen on 2017/3/9.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class SubjectOberver {

    @Test
    public void test() {

        Subject subject = new SubjectImpl();
        Oberver o1 = new OberverImpl("1");
        Oberver o2 = new OberverImpl("2");
        Oberver o3 = new OberverImpl("3");
        Oberver o4 = new OberverImpl("4");
        Oberver o5 = new OberverImpl("5");

        subject.addObserver(o1);
        subject.addObserver(o2);
        subject.addObserver(o3);
        subject.addObserver(o4);
        subject.addObserver(o5);

        subject.sendMessage("woc");
        subject.removeObserver(o3);
        subject.sendMessage("nb");

        Subject subject1 = new SubjectImpl();
        Oberver o6 = new OberverImpl(subject1);
        Oberver o7 = new OberverImpl(subject1);
        Oberver o8 = new OberverImpl(subject1);
        Oberver o9 = new OberverImpl(subject1);
        Oberver o10 = new OberverImpl(subject1);

        subject1.sendMessage("nnnn");


        Subject subject3 = new SubjectImpl();
        Oberver o11 = new OberverImpl("o11",subject3);
        Oberver o12 = new OberverImpl("o12",subject3);
        Oberver o13 = new OberverImpl("o13",subject3);
        Oberver o14 = new OberverImpl("o14",subject3);
        Oberver o15 = new OberverImpl("o15",subject3);

        subject3.sendMessage("sasdsad");
        subject3.sendMessage("dd");
    }
}
