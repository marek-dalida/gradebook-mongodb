package com.mongo_db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Mark")
public class Mark {

    @Id
    private long id;
    private float markValue;
    private String markDescription;
    private String date;
    private int markWage;
    private Student student;
    private Teacher teacher;
    private Subject subject;

    public Mark() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMarkValue() {
        return markValue;
    }

    public void setMarkValue(float markValue) {
        this.markValue = markValue;
    }

    public String getMarkDescription() {
        return markDescription;
    }

    public void setMarkDescription(String markDescription) {
        this.markDescription = markDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMarkWage() {
        return markWage;
    }

    public void setMarkWage(int markWage) {
        this.markWage = markWage;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", markValue=" + markValue +
                ", markDescription='" + markDescription + '\'' +
                ", date=" + date +
                ", markWage=" + markWage +
                ", student=" + student +
                ", teacher=" + teacher +
                ", subject=" + subject +
                '}';
    }
}
