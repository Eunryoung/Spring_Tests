package com.itwillbs.test3_mybatis.vo;

/*
study_spring5.student 테이블 정의
---------------------------------
번호(idx) - 정수, PK, 자동증가
이름(name) - 문자 20자, NN
이메일(email) - 문자 100자, UN, NN
학년(grade) - 정수, NN
----------------------------------
CREATE DATABASE study_spring5;
USE study_spring5;
CREATE TABLE student (
	idx INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	grade INT NOT NULL
);
*/

// 학생 테이블(student)과 매핑되는 VO 클래스 정의
public class StudentVO {
	// 학생 테이블의 학생 정보 레코드 1개와 1:1로 대응하는 멤버변수 선언
	private int idx;
	private String name;
	private String email;
	private int grade;
	
	// 기본 생성자 정의 - 생략 가능
	
	// Getter/Setter 정의
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "StudentVO [idx=" + idx + ", name=" + name + ", email=" + email + ", grade=" + grade + "]";
	}
	
}













