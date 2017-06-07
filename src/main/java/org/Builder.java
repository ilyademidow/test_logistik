package org;

import org.models.Classifier;
import org.models.ClassifierComparator;

import java.util.Arrays;

/**
 * Created by Ilya Demidov
 * Project is test
 */
public class Builder {
    ClassifierComparator comparator = new ClassifierComparator();

    public Classifier[] build(Classifier[] classifiers) {
        //Set position for save sequence after cut period
        for (int i = 0; i < classifiers.length; i++) {
            if (classifiers[i] != null && classifiers[i].getPosition() == null) {
                classifiers[i].setPosition(i);
            }
        }

        //If all periods has inner period we will cut each for
        Classifier[] sortedClassifiers = new Classifier[classifiers.length * 2];

        boolean tailWasFound = false;

        int lastItem = classifiers.length - 1;
        int sortedItemPosition = 0;
        for (int i = lastItem; i >= 0; i--) {
            //After recursion it can content a null items
            if (classifiers[i] != null) {
                //It can be after cut if "start" greater than "end"
                if (classifiers[i].getEnd() == null || classifiers[i].getEnd() > classifiers[i].getStart()) {
                    //For save sequence
                    classifiers[i].setPosition(i);
                    sortedClassifiers[sortedItemPosition++] = classifiers[i];
                }
                for (int j = i - 1; j >= 0; j--) {
                    //Previous period starts early than next period by default, cause we don't check it
                    //Check if current period is inner for previous
                    if (classifiers[i].getEnd() != null && (classifiers[j].getEnd() == null || classifiers[j].getEnd() > classifiers[i].getEnd())) {
                        tailWasFound = true;
                        //Add tail of previous period and save position for correct sort
                        sortedClassifiers[sortedItemPosition++] = new Classifier(classifiers[i].getEnd() + 1, classifiers[j].getEnd(), classifiers[j].getTag(), classifiers[j].getPosition());
                        //Cut previous period. It can become an incorrect tail, but it fixed after recursion
                        classifiers[j].setEnd(classifiers[i].getStart() - 1);
                    } else {
                        //If period finish sametime but next period is inner for previous
                        if (classifiers[j].getEnd() != null && classifiers[j].getEnd() >= classifiers[i].getStart()) {
                            classifiers[j].setEnd(classifiers[i].getStart() - 1);
                        }
                    }
                }
            }
        }

        if (tailWasFound) {
            Arrays.sort(sortedClassifiers, comparator);
            sortedClassifiers = this.build(sortedClassifiers);
        }

        return sortedClassifiers;
    }


}

