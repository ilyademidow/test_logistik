package org;

import org.models.Classifier;

/**
 * Created by Ilya Demidov
 * Project is test
 */
public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder();
        Classifier[] classifiers = new Classifier[4];
        int j = 0;
        classifiers[j++] = new Classifier(10, null, "A");
        classifiers[j++] = new Classifier(20, 30, "B");
        classifiers[j++] = new Classifier(40, 80, "D");
        System.out.println("================");
        for(Classifier c : classifiers) {
            System.out.println(c);
        }
        System.out.println("==== SORTED ====");
        for(Classifier c : builder.build(classifiers)) {
            System.out.println(c);
        }
    }
}
