package br.com.digitalhouse.recyclerviewlistenerexercicio.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Professor  implements Parcelable {
    private String name;
    private String course;
    private String detail;
    private int photo;

    public Professor() {
    }

    public Professor(String name, String course, String detail, int foto) {
        this.name = name;
        this.course = course;
        this.detail = detail;
        this.photo = foto;
    }

    protected Professor(Parcel in) {
        name = in.readString();
        course = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(course);
        dest.writeString(detail);
        dest.writeInt(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Professor> CREATOR = new Creator<Professor>() {
        @Override
        public Professor createFromParcel(Parcel in) {
            return new Professor(in);
        }

        @Override
        public Professor[] newArray(int size) {
            return new Professor[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int foto) {
        this.photo = foto;
    }
}
