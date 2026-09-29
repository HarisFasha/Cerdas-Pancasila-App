package com.example.myapplication.level;

import java.util.List;

public class QuestionModel {
    private String soal;
    private List<String> pilihan;
    private String jawaban;

    // Getters and Setters

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public List<String> getPilihan() {
        return pilihan;
    }

    public void setPilihan(List<String> pilihan) {
        this.pilihan = pilihan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
