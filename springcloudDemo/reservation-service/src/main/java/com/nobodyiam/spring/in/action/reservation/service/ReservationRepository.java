//package com.nobodyiam.spring.in.action.reservation.service;
//
//import com.nobodyiam.spring.in.action.reservation.service.entity.Reservation;
//
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;
//
//import java.util.List;
//
//@RepositoryRestResource
//public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {
//  @RestResource(path = "by-name")
//  List<Reservation> findByReservationName(@Param("name") String reservationName);
//}
