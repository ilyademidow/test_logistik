package org;

import org.junit.Test;
import org.models.Classifier;

/**
 * Created by Ilya Demidov
 * Project is test
 */
public class BuilderTest {
    Builder builder = new Builder();

    @Test
    public void buildTest1() {
        Classifier[] classifiers = new Classifier[2];
        int j = 0;
        classifiers[j++] = new Classifier(10, 40, "A");
        classifiers[j++] = new Classifier(20, 50, "B");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(20, 50, "B"));
        assert sortedClassifiers[1].equals(new Classifier(10, 19, "A"));
    }

    @Test
    public void buildTest2() {
        Classifier[] classifiers = new Classifier[2];
        int j = 0;
        classifiers[j++] = new Classifier(10, 20, "A");
        classifiers[j++] = new Classifier(30, 50, "B");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(30, 50, "B"));
        assert sortedClassifiers[1].equals(new Classifier(10, 20, "A"));
    }

    @Test
    public void buildTest3() {
        Classifier[] classifiers = new Classifier[2];
        int j = 0;
        classifiers[j++] = new Classifier(10, 20, "A");
        classifiers[j++] = new Classifier(10, 50, "B");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(10, 50, "B"));
        assert sortedClassifiers[1] == null;
    }

    @Test
    public void buildTest4() {

        Classifier[] classifiers = new Classifier[4];
        int j = 0;
        classifiers[j++] = new Classifier(10, 100, "A");
        classifiers[j++] = new Classifier(20, 90, "B");
        classifiers[j++] = new Classifier(30, 70, "C");
        classifiers[j++] = new Classifier(40, 80, "D");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(91, 100, "A"));
        assert sortedClassifiers[1].equals(new Classifier(81, 90, "B"));
        assert sortedClassifiers[2].equals(new Classifier(40, 80, "D"));
        assert sortedClassifiers[3].equals(new Classifier(30, 39, "C"));
        assert sortedClassifiers[4].equals(new Classifier(20, 29, "B"));
        assert sortedClassifiers[5].equals(new Classifier(10, 19, "A"));
    }

    @Test
    public void buildTest5() {

        Classifier[] classifiers = new Classifier[4];
        int j = 0;
        classifiers[j++] = new Classifier(10, null, "A");
        classifiers[j++] = new Classifier(20, 90, "B");
        classifiers[j++] = new Classifier(30, 70, "C");
        classifiers[j++] = new Classifier(40, 80, "D");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(91, null, "A"));
        assert sortedClassifiers[1].equals(new Classifier(81, 90, "B"));
        assert sortedClassifiers[2].equals(new Classifier(40, 80, "D"));
        assert sortedClassifiers[3].equals(new Classifier(30, 39, "C"));
        assert sortedClassifiers[4].equals(new Classifier(20, 29, "B"));
        assert sortedClassifiers[5].equals(new Classifier(10, 19, "A"));
    }

    @Test
    public void buildTest6() {

        Classifier[] classifiers = new Classifier[4];
        int j = 0;
        classifiers[j++] = new Classifier(10, null, "A");
        classifiers[j++] = new Classifier(20, null, "B");
        classifiers[j++] = new Classifier(30, null, "C");
        classifiers[j++] = new Classifier(40, 80, "D");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(81, null, "C"));
        assert sortedClassifiers[1].equals(new Classifier(81, null, "B"));
        assert sortedClassifiers[2].equals(new Classifier(81, null, "A"));
        assert sortedClassifiers[3].equals(new Classifier(40, 80, "D"));
        assert sortedClassifiers[4].equals(new Classifier(30, 39, "C"));
        assert sortedClassifiers[5].equals(new Classifier(20, 29, "B"));
        assert sortedClassifiers[6].equals(new Classifier(10, 19, "A"));
    }

    @Test
    public void buildTest7() {

        Classifier[] classifiers = new Classifier[4];
        int j = 0;
        classifiers[j++] = new Classifier(10, null, "A");
        classifiers[j++] = new Classifier(20, 30, "B");
        classifiers[j++] = new Classifier(40, 80, "D");

        Classifier[] sortedClassifiers = builder.build(classifiers);

        assert sortedClassifiers[0].equals(new Classifier(81, null, "A"));
        assert sortedClassifiers[1].equals(new Classifier(40, 80, "D"));
        assert sortedClassifiers[2].equals(new Classifier(31, 39, "A"));
        assert sortedClassifiers[3].equals(new Classifier(20, 30, "B"));
        assert sortedClassifiers[4].equals(new Classifier(10, 19, "A"));
    }
}
