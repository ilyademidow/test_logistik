package org.models;

import java.util.Comparator;

/**
 * Created by Ilya Demidov
 * Project is test
 */
public class ClassifierComparator implements Comparator<Classifier> {
    @Override
    public int compare(Classifier o1, Classifier o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        if (o1.getStart() < o2.getStart()) {
            return -1;
        } else if (o1.getStart().equals(o2.getStart())) {
            if (o1.getPosition() < o2.getPosition()) {
                return -1;
            } else if (o1.getPosition() > o2.getPosition()) {
                return 1;
            }
            return 0;
        } else {
            return 1;
        }
    }
}
