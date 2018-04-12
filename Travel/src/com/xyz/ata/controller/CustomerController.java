package com.xyz.ata.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xyz.ata.bean.ProfileBean;
import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;
import com.xyz.ata.bean.WrapperList;
import com.xyz.ata.service.Administrator;
import com.xyz.ata.service.Customer;
import com.xyz.ata.util.Payment;
import com.xyz.ata.util.User;
import com.xyz.ata.validator.BookVehicleValidator;
import com.xyz.ata.validator.RegisterValidator;

@Controller
public class CustomerController {
	@Autowired
	User user;
	@Autowired
	Customer customer;
	@Autowired
	Administrator administrator;
	@Autowired
	Payment payment;
	@Autowired
    RegisterValidator validator;
	@Autowired
 BookVehicleValidator bookVehicleValidator;
	private static boolean visitStatus=false;
	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public ModelAndView showRegister(Model model){
		
		return new ModelAndView("register","register",new ProfileBean());
	}
	
	
	@RequestMapping( value="/register",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("register")ProfileBean profileBean, BindingResult result,
		Model model) {
		validator.validate(profileBean, result);
        
        if (result.hasErrors()) {
            return "register";
        }
	else
	{
	String userId=user.register(profileBean);
	System.out.println(userId);
	if(userId!=null)
	{
		model.addAttribute("message"," Your User ID is "+userId+" Happy Travelling!!!");
	}
	else
	{
		model.addAttribute("message","Sorry Your ID cannot be generated!Please Register Again");
	}
	return "customer";
	}
	}
	
	
	@RequestMapping(value = "/customernavigation", method = RequestMethod.GET)

	public ModelAndView showNavigation(){
		
		return new ModelAndView("customernavigation");
	}
	
	
	@RequestMapping(value = "/viewVehiclesByType", method = RequestMethod.GET)

	public ModelAndView showViewVehiclesByType(Model model){
		
		ArrayList<String> vehicleType=new ArrayList<String>();
		ArrayList<VehicleBean> list=administrator.viewAllVehicles();
		for (Iterator<VehicleBean> iterator = list.iterator(); iterator.hasNext();) {
			VehicleBean vehicleBean = (VehicleBean) iterator.next();
			if(!(vehicleType.contains(vehicleBean.getType())))
			{
				vehicleType.add(vehicleBean.getType());
			}
			
		}
		model.addAttribute("vehicleType",vehicleType);
		
		return new ModelAndView("viewVehiclesByType","wrapperList",new WrapperList());
	}
	
	@RequestMapping(value = "/viewVehicleBySeats", method = RequestMethod.GET)

	public ModelAndView showViewVehicleBySeats(Model model){
		
		ArrayList<Integer> seats=new ArrayList<Integer>();
		ArrayList<VehicleBean> list=administrator.viewAllVehicles();
		for (Iterator<VehicleBean> iterator = list.iterator(); iterator.hasNext();) {
			VehicleBean vehicleBean = (VehicleBean) iterator.next();
			if(!(seats.contains(vehicleBean.getSeatingCapacity())))
			{
			seats.add(vehicleBean.getSeatingCapacity());
			}
		}
		model.addAttribute("seats",seats);
		
		return new ModelAndView("viewVehicleBySeats","wrapperList",new WrapperList());
	}
	@RequestMapping(value = "/viewVehicleBySeats", method = RequestMethod.POST)
	public String viewVehicleBySeats(@ModelAttribute("viewVehicleBySeats")WrapperList wrapperList,
			Model model)
	{
		int noOfSeat=wrapperList.getNoOfSeats();
		wrapperList.setVehicleList(customer.viewVehicleBySeats(noOfSeat));
		
		model.addAttribute("seats",wrapperList);
	     return "viewVehicleBySeatsAction";
	}
	
	@RequestMapping(value = "/viewAllRoutes", method = RequestMethod.GET)

	public ModelAndView showViewAllRoutes(){
		
		ModelAndView model=new ModelAndView();
		WrapperList wrapperList=new WrapperList();
		wrapperList.setRouteList(new ArrayList<RouteBean>(administrator.viewAllRoutes()));
		model.addObject("RouteIds",wrapperList);

	    model.setViewName("viewAllRoutes");
	    return model;
	}
	
	
	@RequestMapping(value = "/bookVehicle", method = RequestMethod.GET)

	public ModelAndView showBookVehicle(Model model,HttpServletRequest request){
		
		ArrayList<RouteBean> routeList=administrator.viewAllRoutes();
		ArrayList<String> boardingPoints=new ArrayList<String>();
		ArrayList<String> dropPoints=new ArrayList<String>();
		ArrayList<String> vehicleIDs=new ArrayList<String>();
		ArrayList<VehicleBean> list=administrator.viewAllVehicles();
		WrapperList wrapperList=new WrapperList();
		ArrayList<VehicleBean> freeVehicles=new ArrayList<VehicleBean>();
		for (Iterator<RouteBean> iterator = routeList.iterator(); iterator.hasNext();) {
			RouteBean bean=iterator.next();
			boardingPoints.add(bean.getSource());
			dropPoints.add(bean.getDestination());
			
			
		}
		
		
		for (Iterator<VehicleBean> iterator = list.iterator(); iterator.hasNext();) {
			VehicleBean vehicleBean = (VehicleBean) iterator.next();
			if(vehicleBean.getStatus()==null)
			{
			vehicleIDs.add(vehicleBean.getVehicleID());
			freeVehicles.add(vehicleBean);
			}
		}
		ArrayList<RouteBean> availableRoutes=administrator.viewAllRoutes();
		wrapperList.setVehicleList(freeVehicles);
		model.addAttribute("boardingPoints",boardingPoints);
		model.addAttribute("dropPoints",dropPoints);
		model.addAttribute("vehicleIDs",vehicleIDs);
		model.addAttribute("freevehicles",wrapperList);
		model.addAttribute("routeList",availableRoutes);
		if(visitStatus==true)
		{
			model.addAttribute("error","No route Available");
			visitStatus=false;
		}
		
		
		return new ModelAndView("bookVehicle","bookVehicle",new ReservationBean());
		

	}
	@RequestMapping(value = "/bookVehicle", method = RequestMethod.POST)
	public ModelAndView bookVehicle(@ModelAttribute("bookVehicle")ReservationBean reservationBean,
		Model model)
	

	{
	RouteBean routeBean=customer.getRoute(reservationBean);
	if(routeBean==null)
	
	{
		visitStatus=true;
		
		return new ModelAndView("redirect:/bookVehicle.html");
	}
	reservationBean.setRouteID(customer.getRoute(reservationBean).getRouteID());
	reservationBean.setTotalFare(customer.getFare(routeBean, reservationBean.getVehicleID()));
	DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
	model.addAttribute("journeydate",dateFormat.format(reservationBean.getJourneyDate()));
	model.addAttribute("reservation",reservationBean);
	 return new ModelAndView("bookVehicleAction");
	
	}
	@RequestMapping(value = "/bookVehicleAction", method = RequestMethod.POST)
	public String bookVehicleAction(@ModelAttribute("bookVehicle")ReservationBean reservationBean,
		Model model,HttpSession session)
	{
		boolean isCardAvailable=payment.findByCardNumber((String) session.getAttribute("loginName"),reservationBean.getCardNumber());
		if(isCardAvailable)
		{
		String paymentStatus=payment.process(reservationBean.getCardNumber(),reservationBean.getTotalFare());
		if("PAID".equals(paymentStatus))
		{
	reservationBean.setBookingDate(new Date());
	reservationBean.setBookingStatus("active");
	String reservartionID=customer.bookVehicle(reservationBean);
	model.addAttribute("message","vehicle Booked with reservation ID :"+reservartionID);
	return "success";
		
	}
		else
		{
			model.addAttribute("message","Sorry,Insufficient Balance!!");
			return "success";
		}
		}
		else
		{
			model.addAttribute("message","card details not valid");
			return "success";
		}
	}
	@RequestMapping(value = "/cancelBooking", method = RequestMethod.GET)

	public ModelAndView showCancelBooking(HttpSession session,HttpServletRequest request){
		
		
		String id=(String) session.getAttribute("loginName");
		ModelAndView model=new ModelAndView();
		WrapperList wrapperList=new WrapperList();
		ArrayList<ReservationBean> reservations=customer.viewAllReservations(id);
		wrapperList.setReservationList(reservations);
		
		ArrayList<String> journeyDates=new ArrayList<String>();
		ArrayList<String> bookingDates=new ArrayList<String>();
		DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		for (Iterator<ReservationBean> iterator = reservations.iterator(); iterator.hasNext();) {
			ReservationBean reservationBean=(ReservationBean) iterator.next();
			journeyDates.add(dateFormat.format(reservationBean.getJourneyDate()));
			bookingDates.add(dateFormat.format(reservationBean.getBookingDate()));
			
		}
		model.addObject("reservationIDs",wrapperList);
		
		request.setAttribute("journeydates",journeyDates);
		request.setAttribute("bookingdates",bookingDates);

	    model.setViewName("cancelBooking");
	    return model;
	}
	@RequestMapping(value = "/cancelBooking", method = RequestMethod.POST)
	public String cancelBooking(
			@ModelAttribute("reservationIDs") WrapperList wrapperList, Model model,HttpSession session) {
		if(wrapperList.getReservationBean()==null)
		{
			model.addAttribute("message","please choose a reservation to cancel");
			return "success";
		}
		else
		{
		ReservationBean bean=wrapperList.getReservationBean();
		if(customer.cancelBooking(session.getAttribute("loginName").toString(),bean.getReservationID()))
		{
			model.addAttribute("message","your booking is cancelled successfully!Payment will be credited after 3 working days!");
		}
		else
		{
			model.addAttribute("message","Your Booking cannot be cancelled!!");
		}
		return "success";
		}
	}
	
	
	@RequestMapping(value = "/viewCustomerBookingDetails", method = RequestMethod.GET)

	public ModelAndView showViewBookingDetails(HttpSession session,HttpServletRequest request){
		String id=(String) session.getAttribute("loginName");
		ModelAndView model=new ModelAndView();
		ArrayList<String> journeyDates=new ArrayList<String>();
		ArrayList<String> bookingDates=new ArrayList<String>();
		ArrayList<ReservationBean> reservations=customer.viewAllReservations(id);
WrapperList wrapperList=new WrapperList();
		
		wrapperList.setReservationList(reservations);
		DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		for (Iterator<ReservationBean> iterator = reservations.iterator(); iterator.hasNext();) {
			ReservationBean reservationBean=(ReservationBean) iterator.next();
			journeyDates.add(dateFormat.format(reservationBean.getJourneyDate()));
			bookingDates.add(dateFormat.format(reservationBean.getBookingDate()));
			
		}
		
		
		
		
		model.addObject("reservations",wrapperList);
		request.setAttribute("journeydates",journeyDates);
		request.setAttribute("bookingdates",bookingDates);
		

	    model.setViewName("viewCustomerBookingDetails");
	    return model;
		
	}
	
	
	
	
	
	
	@RequestMapping(value = "/printBookingDetails", method = RequestMethod.GET)

	public ModelAndView showPrintBookingDetails(){
		
		return new ModelAndView("printBookingDetails");
	}
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)

	public ModelAndView showPDF(HttpSession httpSession,Model model,HttpServletRequest request){
		
		ArrayList<ReservationBean> list=new ArrayList<ReservationBean>();	
		list=customer.viewAllReservations((String) httpSession.getAttribute("loginName"));
		
		
		if(list.size()==0)
		{
			model.addAttribute("message","You have no bookings yet!!");
			return new ModelAndView("success"); 
		}
		
		
		return new ModelAndView("pdfView","reservations",list);
	}
	
	
	@RequestMapping(value="/viewVehiclesByType",method=RequestMethod.POST)
	public String viewVehiclesByTypeAction(@ModelAttribute("viewVehicleByType")WrapperList wrapperList,
			Model model)
	{
		String seatType=wrapperList.getType();
		wrapperList.setVehicleList(customer.viewVehiclesByType(seatType));
		
		model.addAttribute("seatTypes",wrapperList);
	     return "viewVehicleByTypeAction";
	}

	

	

	

	

	

	
	
}
