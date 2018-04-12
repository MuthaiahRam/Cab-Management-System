package com.xyz.ata.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xyz.ata.bean.DriverBean;
import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;
import com.xyz.ata.bean.WrapperList;
import com.xyz.ata.service.Administrator;
import com.xyz.ata.validator.AddDriverValidator;
import com.xyz.ata.validator.AddRouteValidator;
import com.xyz.ata.validator.AddVehicleValidator;
import com.xyz.ata.validator.ModifyDriverValidator;
import com.xyz.ata.validator.ModifyRouteValidator;
import com.xyz.ata.validator.ModifyVehicleValidator;

@Controller
public class AdminController {
	@Autowired
	Administrator administrator;
	@Autowired
    AddDriverValidator driverValidator;
	
	@Autowired
    AddRouteValidator routeValidator;
	@Autowired
    AddVehicleValidator vehicleValidator;
	@Autowired
    ModifyVehicleValidator     modifyVehicleValidator;
	@Autowired
    ModifyDriverValidator     modifyDriverValidator;
	@Autowired
    ModifyRouteValidator     modifyRouteValidator;

	@RequestMapping(value = "/navigation", method = RequestMethod.GET)
	public ModelAndView showNavigation() {

		return new ModelAndView("navigation");
	}

	@RequestMapping(value = "/loginName", method = RequestMethod.GET)
	public ModelAndView showLoginName(Model model) {

		return new ModelAndView("loginName");
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView showRedirect(Model model) {

		return new ModelAndView("redirect");
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.GET)
	public ModelAndView showAddVehicle(Model model) {

		return new ModelAndView("addVehicle", "addVehicle", new VehicleBean());
	}

	@RequestMapping(value = "/deleteVehicle", method = RequestMethod.GET)
	public ModelAndView showDeleteVehicle() {
		ModelAndView model = new ModelAndView();
		WrapperList wrapperList = new WrapperList();
		wrapperList.setVehicleList(new ArrayList<VehicleBean>(administrator
				.viewAllVehicles()));
		model.addObject("VehicleIds", wrapperList);

		model.setViewName("deleteVehicle");
		return model;
	}

	@RequestMapping(value = "/modifyVehicle", method = RequestMethod.GET)
	public ModelAndView showModifyVehicle() {
		ModelAndView model = new ModelAndView();
		WrapperList wrapperList = new WrapperList();
		wrapperList.setVehicleList(new ArrayList<VehicleBean>(administrator
				.viewAllVehicles()));
		model.addObject("VehicleIds", wrapperList);

		model.setViewName("modifyVehicle");
		return model;

	}

	@RequestMapping(value = "/viewVehicle", method = RequestMethod.GET)
	public ModelAndView showViewVehicle(Model model) {
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<VehicleBean> list = administrator.viewAllVehicles();
		for (Iterator<VehicleBean> iterator = list.iterator(); iterator
				.hasNext();) {
			VehicleBean vehicleBean = (VehicleBean) iterator.next();
			ids.add(vehicleBean.getVehicleID());
		}
		model.addAttribute("vehicleIDs", ids);

		return new ModelAndView("viewVehicle", "viewVehicle", new VehicleBean());
	}
	@RequestMapping(value = "/viewBookingDetails", method = RequestMethod.GET)
	public ModelAndView showViewBookingDetails(Model model) {
		ArrayList<String> source = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();
		ArrayList<RouteBean> list = administrator.viewAllRoutes();
		for (Iterator<RouteBean> iterator = list.iterator(); iterator
				.hasNext();) {
			RouteBean routeBean=iterator.next();
			source.add(routeBean.getSource());
			destination.add(routeBean.getDestination());
		}
		ArrayList<RouteBean> availableRoutes=administrator.viewAllRoutes();
		model.addAttribute("routeList",availableRoutes);
		model.addAttribute("source", source);
		model.addAttribute("destination",destination);


		return new ModelAndView("viewBookingDetails", "viewBookingDetails", new WrapperList());
	}
	@RequestMapping(value = "/viewBookingDetails", method = RequestMethod.POST)
	public String viewBookingDetails(
			@ModelAttribute("viewBookingDetails") WrapperList wrapperList, Model model,HttpServletRequest request) {
		
		ArrayList<String> journeyDates=new ArrayList<String>();
		ArrayList<String> bookingDates=new ArrayList<String>();
		DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		ArrayList<ReservationBean> reservations=administrator.viewBookingDetails(wrapperList.getJourneyDate(),wrapperList.getSource(),wrapperList.getDestination());
		wrapperList.setReservationList(reservations);
		for (Iterator<ReservationBean> iterator = reservations.iterator(); iterator.hasNext();) {
			ReservationBean reservationBean=(ReservationBean) iterator.next();
			journeyDates.add(dateFormat.format(reservationBean.getJourneyDate()));
			bookingDates.add(dateFormat.format(reservationBean.getBookingDate()));
			
		}
		model.addAttribute("reservations",wrapperList);
		request.setAttribute("journeydates",journeyDates);
		request.setAttribute("bookingdates",bookingDates);
		return "viewBookingDetailsAction";
	}

	@RequestMapping(value = "/addDriver", method = RequestMethod.GET)
	public ModelAndView showAddDriver(Model model) {

		return new ModelAndView("addDriver", "addDriver", new DriverBean());
	}

	@RequestMapping(value = "/deleteDriver", method = RequestMethod.GET)
	public ModelAndView showDeleteDriver() {

		ModelAndView model = new ModelAndView();
		WrapperList wrapperList = new WrapperList();
		wrapperList.setDriverList(new ArrayList<DriverBean>(administrator
				.viewAllDrivers()));
		model.addObject("DriverIds", wrapperList);

		model.setViewName("deleteDriver");
		return model;
	}

	@RequestMapping(value = "/modifyDriver", method = RequestMethod.GET)
	public ModelAndView showModifyDriver() {

		ModelAndView model = new ModelAndView();
		WrapperList wrapperList = new WrapperList();
		wrapperList.setDriverList(new ArrayList<DriverBean>(administrator
				.viewAllDrivers()));
		model.addObject("driverIds", wrapperList);

		model.setViewName("modifyDriver");
		return model;
	}

	@RequestMapping(value = "/allotDriver", method = RequestMethod.GET)
	public ModelAndView showAllotDriver(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		ArrayList<String> journeyDates=new ArrayList<String>();
		ArrayList<String> bookingDates=new ArrayList<String>();
		WrapperList wrapperList = new WrapperList();
		ArrayList<ReservationBean> reservationList = administrator
				.showAllReservations();
		for (int i = 0; i < reservationList.size(); i++) {
			ReservationBean reservationBean = reservationList.get(i);
			if (reservationBean.getDriverID() !=null) {
				reservationList.remove(i);
			}

		}
		DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		for (Iterator<ReservationBean> iterator = reservationList.iterator(); iterator.hasNext();) {
			ReservationBean reservationBean=(ReservationBean) iterator.next();
			journeyDates.add(dateFormat.format(reservationBean.getJourneyDate()));
			bookingDates.add(dateFormat.format(reservationBean.getBookingDate()));
			
		}
		wrapperList.setReservationList(reservationList);
		model.addObject("reservations", wrapperList);

		model.setViewName("allotDriver");
		request.setAttribute("journeydates",journeyDates);
		request.setAttribute("bookingdates",bookingDates);
		return model;
	}
	@RequestMapping(value="/allotDriver",method=RequestMethod.POST)
	public String allotDriver(@ModelAttribute("allotDriver")WrapperList wrapperList,
		Model model) {
		if(wrapperList.getReservationBean()==null)
		{
			model.addAttribute("message","Please choose a reservation to allot driver");
			return "success";
		}
		else
		{
		DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		ReservationBean reservationBean=administrator.viewReservation(wrapperList.getReservationBean().getReservationID());
		model.addAttribute("modifyBean",reservationBean);
		
		ArrayList<DriverBean> drivers=administrator.viewAllDrivers();
		ArrayList<String> driverIDs=new ArrayList<String>();
		
		for(int i=0;i<drivers.size();i++)
		{
		
		
		if(drivers.get(i).getStatus()==null)
		
			driverIDs.add(drivers.get(i).getDriverID());
		}
		
		model.addAttribute("driverIds",driverIDs);
		model.addAttribute("journeyDate",dateFormat.format(reservationBean.getJourneyDate()));
		model.addAttribute("bookingDate",dateFormat.format(reservationBean.getBookingDate()));
		return "allotDriverAction";
		}
	}
	@RequestMapping(value = "/allotDriverAction", method = RequestMethod.POST)
	public String allotDriveraction(
			@ModelAttribute("modifyBean") ReservationBean reservationBean, Model model) {
		System.out.println("Test1"+reservationBean.getDriverID()+":");
		boolean isAlloted= administrator.allotDriver(reservationBean.getReservationID(),reservationBean.getDriverID());
		if (isAlloted)
			model.addAttribute("message", " Driver alloted successfully!! ");
		else
			model.addAttribute("message", "Failed to allot driver");
		return "success";
	}

	@RequestMapping(value = "/addRoute", method = RequestMethod.GET)
	public ModelAndView showAddRoute(Model model) {

		return new ModelAndView("addRoute", "addRoute", new RouteBean());
	}

	@RequestMapping(value = "/deleteRoute", method = RequestMethod.GET)
	public ModelAndView showDeleteRoute() {

		ModelAndView model = new ModelAndView();
		WrapperList wrapperList = new WrapperList();
		wrapperList.setRouteList(new ArrayList<RouteBean>(administrator
				.viewAllRoutes()));
		model.addObject("RouteIds", wrapperList);

		model.setViewName("deleteRoute");
		return model;
	}

	@RequestMapping(value = "/modifyRoute", method = RequestMethod.GET)
	public ModelAndView showModifyRoute() {

		ModelAndView model = new ModelAndView();
		WrapperList wrapperList = new WrapperList();
		wrapperList.setRouteList(new ArrayList<RouteBean>(administrator
				.viewAllRoutes()));
		model.addObject("routeIds", wrapperList);

		model.setViewName("modifyRoute");
		return model;
	}

	@RequestMapping(value = "/viewRoute", method = RequestMethod.GET)
	public ModelAndView showViewRoute(Model model) {

		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<RouteBean> list = administrator.viewAllRoutes();
		for (Iterator<RouteBean> iterator = list.iterator(); iterator.hasNext();) {
			RouteBean routeBean = (RouteBean) iterator.next();
			ids.add(routeBean.getRouteID());
		}
		model.addAttribute("routeIDs", ids);

		return new ModelAndView("viewRoute", "viewRoute", new RouteBean());
	}

	

	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public String addDriver(@ModelAttribute("addDriver") DriverBean driverBean,
			 BindingResult result,Model model) {
		driverValidator.validate(driverBean, result);
        if (result.hasErrors()) {
            return "addDriver";
        }
        else
        {
		driverBean.setStatus(null);
		String driverID = administrator.addDriver(driverBean);

		if (driverID != null) {
			model.addAttribute("message", "Driver added successfully with ID "
					+ driverID);
		} else {
			model.addAttribute("message", "Sorry Driver Could not be added");
		}
		return "success";
        }
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
	public String addVehicle(
			@ModelAttribute("addVehicle") VehicleBean vehicleBean,BindingResult result, Model model) {
		vehicleValidator.validate(vehicleBean, result);
        if (result.hasErrors()) {
            return "addVehicle";
        }
        else
        {
		vehicleBean.setStatus(null);
		String vehicleID = administrator.addVehicle(vehicleBean);

		if (vehicleID != null) {
			model.addAttribute("message", " added successfully with ID "
					+ vehicleID);
		} else {
			model.addAttribute("message", "Sorry Vehicle Could not be added");
		}
		return "success";
        }
	}

	@RequestMapping(value = "/deleteVehicle", method = RequestMethod.POST)
	public String deleteVehicle(
			@ModelAttribute("VehicleIds") WrapperList wrapperList, Model model) {
		
			
			
		
			
		
		ArrayList<String> list = new ArrayList<String>();
		for (Iterator<VehicleBean> iterator = wrapperList.getVehicleList()
				.iterator(); iterator.hasNext();) {
			VehicleBean bean = iterator.next();
			if (bean.isChecked()) {
				list.add(bean.getVehicleID());
			}

		}
		if(list.size()==0)
		{
			model.addAttribute("message","Please select a vehicle to delete");
			return "success";
		}
		else
		{
		administrator.deleteVehicle(list);
		model.addAttribute("message",
				"The vehicle(s) is/are successfully deleted!");
		return "success";
		}
		
	}

	@RequestMapping(value = "/modifyVehicle", method = RequestMethod.POST)
	public String modifyVehicle(
			@ModelAttribute("modifyVehicle") WrapperList wrapperList,
			Model model) {
		if(wrapperList.getVehicleBean()==null)
		{
			model.addAttribute("message","Please select a vehicle to modify");
			return "success";
		}
		else
		{
		model.addAttribute("modifyBean", administrator.viewVehicle(wrapperList
				.getVehicleBean().getVehicleID()));
		return "modifyaction";
		}
	}

	@RequestMapping(value = "/modifyaction", method = RequestMethod.POST)
	public String modifyVehicleAction(
			@ModelAttribute("modifyBean") VehicleBean vehicleBean, BindingResult result,Model model) {
		modifyVehicleValidator.validate(vehicleBean, result);
        if (result.hasErrors()) {
            return "modifyaction";
        }
        else
        {
		boolean isModified = administrator.modifyVehicle(vehicleBean);
		if (isModified)
			model.addAttribute("message", "The vehicle(s) is/are successfully modified!");
		else
			model.addAttribute("message", "failed to modify vehicles");
		return "success";
        }
	}

	@RequestMapping(value = "/viewVehicle", method = RequestMethod.POST)
	public String viewVehicle(
			@ModelAttribute("viewVehicle") VehicleBean vehicleBean, Model model) {
		String vehicleID = vehicleBean.getVehicleID();
		model.addAttribute("vehicle", administrator.viewVehicle(vehicleID));
		return "viewVehicleAction";
	}

	@RequestMapping(value = "/viewRoute", method = RequestMethod.POST)
	public String viewRoute(@ModelAttribute("viewRoute") RouteBean routeBean,
			Model model) {
		String routeID = routeBean.getRouteID();
		model.addAttribute("route", administrator.viewRoute(routeID));
		return "viewRouteAction";
	}

	@RequestMapping(value = "/addRoute", method = RequestMethod.POST)
	public String addRoute(@ModelAttribute("addRoute") RouteBean routeBean,
			BindingResult result,Model model) {
		routeValidator.validate(routeBean, result);
        if (result.hasErrors()) {
            return "addRoute";
        }
        else
        {
		String routeID = administrator.addRoute(routeBean);

		if (routeID != null) {
			model.addAttribute("message", "Route added successfully with ID "
					+ routeID);
		} else {
			model.addAttribute("message", "Sorry Route Could not be added");
		}
		return "success";
        }
	}

	@RequestMapping(value = "/deleteDriver", method = RequestMethod.POST)
	public String deleteDriver(
		
			@ModelAttribute("DriverIds") WrapperList wrapperList, Model model) {
			
		
		ArrayList<String> list = new ArrayList<String>();
		for (Iterator<DriverBean> iterator = wrapperList.getDriverList()
				.iterator(); iterator.hasNext();) {
			DriverBean bean = iterator.next();
			if (bean.isChecked()) {
				list.add(bean.getDriverID());
			}

		}
		if(list.size()==0)
		{
			model.addAttribute("message","please choose a driver to delete");
			return "success";
		}
		else
		{
		 administrator.deleteDriver(list);
		model.addAttribute("message",
				"deleted driver(s) sucessfully!");
		return "success";
		}
		
	}

	@RequestMapping(value = "/deleteRoute", method = RequestMethod.POST)
	public String deleteRoute(
			@ModelAttribute("RouteIds") WrapperList wrapperList, Model model) {
		
		ArrayList<String> list = new ArrayList<String>();
		for (Iterator<RouteBean> iterator = wrapperList.getRouteList()
				.iterator(); iterator.hasNext();) {
			RouteBean bean = iterator.next();
			if (bean.isChecked()) {
				list.add(bean.getRouteID());
			}

		}
		if(list.size()==0)
		{
			model.addAttribute("message","please choose a route to delete");
			return "success";
		}
		else
		{
		 administrator.deleteRoute(list);
		model.addAttribute("message",
				"deleted route(s)successfully!" );
		return "success";
		}
		
	}

	@RequestMapping(value = "/modifyDriver", method = RequestMethod.POST)
	public String modifyDriver(
			@ModelAttribute("modifyDriver") WrapperList wrapperList, Model model) {
		if(wrapperList.getDriverBean()==null)
		{
			model.addAttribute("message","please choose a driver to modify");
			return "success";
		}
		else
		{
		model.addAttribute("modifyBean", administrator.viewDriver(wrapperList
				.getDriverBean().getDriverID()));
		return "modifydriveraction";
		}

	}

	@RequestMapping(value = "/modifydriveraction", method = RequestMethod.POST)
	public String modifyDriverAction(
			@ModelAttribute("modifyBean") DriverBean driverBean,BindingResult result, Model model) {
		modifyDriverValidator.validate(driverBean, result);
        if (result.hasErrors()) {
            return "modifydriveraction";
        }
        else
        {
		boolean isModified = administrator.modifyDriver(driverBean);
		if (isModified)
			model.addAttribute("message", "modified driver successfully!");
		else
			model.addAttribute("message", "failed to modify driver!");
		return "success";
        }
	}

	@RequestMapping(value = "/modifyRoute", method = RequestMethod.POST)
	public String modifyRoute(
			@ModelAttribute("modifyRoute") WrapperList wrapperList, Model model) {
		if(wrapperList.getRouteBean()==null)
		{
			model.addAttribute("message","please choose a route to modify");
			return "success";
		}
		else
		{
		model.addAttribute("modifyBean", administrator.viewRoute(wrapperList
				.getRouteBean().getRouteID()));
		return "modifyrouteaction";
		}

	}

	@RequestMapping(value = "/modifyrouteaction", method = RequestMethod.POST)
	public String modifyRouteAction(
			@ModelAttribute("modifyBean") RouteBean routeBean,BindingResult result, Model model) {
		modifyRouteValidator.validate(routeBean, result);
        if (result.hasErrors()) {
            return "modifyrouteaction";
        }
        else
        {
		boolean isModified = administrator.modifyRoute(routeBean);
		if (isModified)
			model.addAttribute("message", "modified route successfully!");
		else
			model.addAttribute("message", "failed to modify route!");
		return "success";
        }
	}

}
