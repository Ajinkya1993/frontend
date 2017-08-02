<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<div class="container main-container">
	<h2 class="main-heading1">Your Plan</h2>
	<a href="personalDashboard.do" class="btn btn-info text-uppercase pull-right">go to dashboard</a>
	<h3 class="main-heading2">With CURANTIS</h3>
	<ul class="list-unstyled list-style-1">
		<li><a href="#" data-toggle="collapse" data-target="#Step1">Step1: Creat a Caregiver Team</a></li>
		<div id="Step1" class="collapse">
			<p>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			</p>
		</div>
		<li><a href="#" data-toggle="collapse" data-target="#Step2">Step2: Set Up your Loved-one Profile</a></li>
		<div id="Step2" class="collapse">
		    <p>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			</p>
		</div>
		<li><a href="#" data-toggle="collapse" data-target="#Step3">Step3: Find Out What You Need to Do</a></li>
		<div id="Step3" class="collapse">
		    <p>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			</p>
		</div>
		<li><a href="#" data-toggle="collapse" data-target="#Step4">Step4: Subscribe to Services</a></li>
		<div id="Step4" class="collapse in">
		    <p>
				Services we recommended for you:
			</p>
			<c:if test="${fn:contains(services, 'senior housing') || getGuide}">
				<h5>Senior Housing</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'in-home care') || getGuide}">
				<h5>In-home Care</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'vendor management') || getGuide}">
				<h5>Vendor Management</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'legal') || getGuide}">
				<h5>Legal</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'estate planning') || getGuide}">
				<h5>Estate Planning</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'taxation') || getGuide}">
				<h5>Taxation</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'financial planning') || getGuide}">
				<h5>Financial Planning</h5>
			</c:if>
			<c:if test="${fn:contains(services, 'insurance') || getGuide}">
				<h5>Insurance</h5>
			</c:if>
		</div>
	</ul>
</div>
<jsp:include page="footer.jsp"/>
