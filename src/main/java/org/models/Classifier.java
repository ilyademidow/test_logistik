package org.models;

/**
 * Created by Ilya Demidov
 * Project is test
 */
public class Classifier {
    private Integer start = null;
    private Integer end = null;
    private String tag = null;
    /**
     * Additional parameter for save sequence after cut period
     */
    private Integer position = null;

    public Classifier(Integer start, Integer end, String tag) {
        this.start = start;
        this.end = end;
        this.tag = tag;
    }

    public Classifier(Integer start, Integer end, String tag, Integer position) {
        this.start = start;
        this.end = end;
        this.tag = tag;
        this.position = position;
    }

    public final Integer getStart() {
        return start;
    }

    public final void setStart(Integer start) {
        this.start = start;
    }

    public final Integer getEnd() {
        return end;
    }

    public final void setEnd(Integer end) {
        this.end = end;
    }

    public final String getTag() {
        return tag;
    }

    public final void setTag(String tag) {
        this.tag = tag;
    }

    public final Integer getPosition() {
        return position;
    }

    public final void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.getStart() + " " + this.getEnd() + " " + this.getTag();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classifier)) return false;

        Classifier that = (Classifier) o;

        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        return tag.equals(that.tag);

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + tag.hashCode();
        return result;
    }
}
