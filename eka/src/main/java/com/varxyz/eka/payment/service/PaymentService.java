package com.varxyz.eka.payment.service;

import java.sql.Date;
import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.payment.domain.Payment;
import com.varxyz.eka.student.domain.Student;

/*
 * 결제 서비스는 학원관리자가 관리하는 서비스 입니다
 * */
public interface PaymentService {
	//학원관리자는 결제정보를 등록 할 수 있어야 한다
	public boolean addPayment(Payment payment);
	
	//학원관리자는 결제정보를 수정 할 수 있어야 한다
	public boolean updatePayment(Payment payment);
	
	//학원관리자는 결제정보를 삭제 할 수 있어야 한다
	public boolean deletePayment(Payment payment);

	/*
	 * 학원관리자는 다양한 결제정보를 조회할 수 있어야 한다 
	 * */
	
	//학원관리자는 학원의 모든 결제정보를 확인 할 수 있다.
	public List<Payment> findAllAcademyPayment(Academy academy);
	
	//학원관리자는 학원에 결제타입에 따른 결제정보들를 확인 할 수 있다
	public List<Payment> findAcademyPaymentsByAccessType(Academy academy, String accessType);
	
	//학원관리자는 일정 날짜에 결제정보들를 확인 할 수 있다
	public List<Payment> findAcademyPaymentsByRegDate(Academy academy, Date regdate);
	
	// 학원관리자는 일정 금액이상 에 대한 결제정보들을 확인 할 수 있다.
	public List<Payment> findAcademyPaymentsByUpPrice(Academy academy, double Price);

	// 학원관리자는 일정 금액이하 에 대한 결제정보들을 확인 할 수 있다.
	public List<Payment> findAcademyPaymentsByDownPrice(Academy academy, double Price);

	// 학원관리자는 일정 금액에 대한 결제정보들을 확인 할 수 있다.
	public List<Payment> findAcademyPaymentsByPrice(Academy academy, double Price);
	
	// 학원관리자는 학생의 정보로 결제정보들을 가져올 수 있어야 한다.
	public List<Payment> findAcademyPaymentsByStudent(Academy academy, Student student);
	
	// 학원관리자는 특정 학생이 결제한 특정 결제정보 하나를 가져올 수 있어야 한다
	public Payment findAcademyPaymentsByStudentAndRegDate(Academy academy, Student student, Date regDate);
	
}
