package com.example3.domain;

/**
 * Created by mlamp on 2017/7/20.
 */
public class Course {
    private Integer id;

    private String subject;

    private String score;

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }
}
