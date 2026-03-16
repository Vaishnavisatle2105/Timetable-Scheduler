<%@page import="com.util.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="com.dao.*" %>
<%@page import="com.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style>
    /* 1. Global Reset and Base Styles */
    *{
        margin:0;
        padding:0;
        box-sizing: border-box; /* Crucial for better layout management */
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body{
        background:#ecf0f1; /* Light background */
    }

    .container{
        display:flex;
        min-height:100vh; /* Use min-height to allow content to grow */
    }

    /* 2. LEFT ASIDE (Sidebar) */
    aside{
        width:250px;
        background:#2c3e50; /* Dark blue/gray */
        color:white;
        padding:20px 0;
        transition: transform 0.3s ease-in-out; /* For mobile sidebar slide */
        flex-shrink: 0; /* Prevents shrinking on larger screens */
    }

    aside h2{
        text-align:center;
        margin-bottom:30px;
        font-size:26px;
        padding: 0 20px;
        color: #f1c40f; /* Yellow accent */
    }

    aside ul{list-style:none;}
    aside ul li{
        padding:12px 20px;
        font-size:18px;
        cursor:pointer;
        margin-bottom: 5px;
        display: flex;
        align-items: center;
    }
    aside ul li i {
        margin-right: 10px;
    }
    aside ul li:hover, aside ul li.active{
        background:#34495e; /* Slightly lighter on hover */
        border-left: 5px solid #438bd2; /* Blue accent line */
    }

    /* 3. RIGHT SIDE (Main Content) */
    main{
        flex:1;
        padding:30px;
        overflow-y: auto; /* Allows scrolling if content is long */
    }
    
    .header-info{
        margin-bottom: 25px;
        border-bottom: 1px solid #bdc3c7;
        padding-bottom: 15px;
    }
    .header-info p{ 
        font-family: 'Georgia', serif;
        font-size: 16px;
        color: #7f8c8d;
        line-height: 1.5;
        margin-top: 5px;
    }
    .title{
        font-size:32px;
        font-weight:600;
        color:#2c3e50; /* Darker title color */
    }

    .content-box{
        min-height:70vh; /* Use min-height */
        background:white;
        padding:30px;
        border-radius:8px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1); /* Subtle shadow */
    }
    
    /* Content Box Headings */
    .content-box h2{
        color:#3498db;
        font-size: 24px;
        margin-bottom: 20px;
        border-bottom: 2px solid #ecf0f1;
        padding-bottom: 10px;
    }

    /* Form Elements */
    label{
        font-weight:600;
        margin-top:20px;
        margin-bottom: 5px;
        display:block;
        color: #34495e;
    }

    select, button{
        padding:10px;
        border:1px solid #ccc;
        border-radius:4px;
        font-size:16px;
        transition: border-color 0.3s;
    }
    select{
        width: 100%; /* Full width in content box */
        max-width:300px;
        margin-bottom:15px;
    }
    select:focus{
        border-color: #3498db;
        outline: none;
    }
    
    button{
        background: #2ecc71; /* Green button */
        color: white;
        border: none;
        cursor: pointer;
        margin-top:15px;
        padding: 10px 20px;
    }
    button:hover{
        background: #27ae60;
    }

    /* Mobile Menu Toggle */
    .menu-toggle {
        display: none; /* Hidden on large screens */
        position: fixed;
        top: 15px;
        left: 15px;
        z-index: 100;
        background: #3498db;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 20px;
    }
    
    /* 4. Responsive Design (Media Queries) */
    @media (max-width: 768px) {
        /* Mobile/Tablet View */
        .container {
            flex-direction: column; /* Stacks elements vertically */
        }

        aside {
            width: 100%;
            height: auto;
            position: fixed; /* Sidebar slides from the left */
            transform: translateX(-100%);
            z-index: 50;
            top: 0;
            bottom: 0;
            padding-top: 70px; /* Space for the header/menu icon */
        }
        
        aside.open {
            transform: translateX(0); /* Slides in */
        }
        
        main {
            padding: 20px;
            padding-top: 70px; /* Space for the fixed header/menu icon */
        }
        
        .menu-toggle {
            display: block; /* Show menu icon */
        }

        .title {
            font-size: 28px;
        }

        .header-info {
            padding-top: 0;
        }
    }
</style>
</head>
<body>

<button class="menu-toggle" onclick="toggleSidebar()">
    <i class="fas fa-bars"></i>
</button>

<div class="container">

    <aside id="sidebar">
        <h2><i class="fas fa-graduation-cap"></i> DASHBOARD</h2>

        <ul>
            <li class="active" onclick="showSubjects(this)"><i class="fas fa-book"></i> Subjects</li>
            <li onclick="showTimetable(this)"><i class="fas fa-table"></i> Time-Table</li>
            <li onclick="showNotifications(this)"><i class="fas fa-bell"></i> Notifications</li>
            <li onclick="showSettings(this)"><i class="fas fa-cog"></i> Settings</li>
        </ul>
    </aside>
 <a href="${pageContext.request.contextPath}/index.jsp">go back</a>
    <main>
   
        <div class="header-info">
            <div class="title">Student Dashboard</div>
            <p>Welcome back! Use the menu to manage your courses, view your timetable, and stay up-to-date with announcements.</p>
        </div>
        
        <div class="content-box" id="contentArea">
            <h3>👈 Please select an option from the menu on the left to get started.</h3>
        </div>
    </main>

</div>


<script>
    const contentArea = document.getElementById("contentArea");
    const sidebar = document.getElementById("sidebar");

    // Helper function to set active link
    function setActive(element) {
        // Remove 'active' class from all list items
        document.querySelectorAll('aside ul li').forEach(li => {
            li.classList.remove('active');
        });
        // Add 'active' class to the clicked element
        element.classList.add('active');
    }

    // Mobile Sidebar Toggle
    function toggleSidebar() {
        sidebar.classList.toggle('open');
    }
    
    function fetchSubjects() {
        let branch = document.getElementById("selectBranch").value;
        let sem = document.getElementById("selectSem").value;

        // Branch short format
       /* if(branch.includes("CSE")) branch = "CSE";
        if(branch.includes("DS")) branch = "DS";
        if(branch.includes("ECE")) branch = "ECE";*/

        // Semester number extract
        sem = sem.charAt(0);  // "4th Semester" → "4"

        // ----------- SIMPLE SERVLET CALL -------------
        fetch("../ShowSubjects?branch=" + branch + "&semester=" + sem)
            .then(response => response.text())
            .then(data => {
                document.getElementById("subjects-list").innerHTML = data;
            });
    }


    // SUBJECTS SECTION
    function showSubjects(element){
        setActive(element);
        // Close sidebar on mobile after selection
        if(window.innerWidth <= 768) toggleSidebar(); 

        contentArea.innerHTML =
        `
            <h2><i class="fas fa-book-open"></i> Course Subjects</h2>
            
            <p style="margin-bottom: 25px;">View the subject list for your specific program and semester.</p>
             <form action="${pageContext.request.contextPath}/views/viewStd_subject.jsp">
            <div style="display: flex; gap: 20px; flex-wrap: wrap;">
                <div style="flex: 1; min-width: 250px;">
               
                    <label for="selectBranch">Select Branch:</label>
                    <select id="selectBranch"
                        name="dept_id"
                            required="required"
                            class="form-select form-control"
                          >
                        <option>-- Select Branch --</option>
                            <%
                            
                            
                List<Department> list1 = DAOFactory.getDepartmentDao().getAllDepartments();

    try {
        for(Department d: list1){
        	%>
        
        <option value="<%= d.getDept_id() %>">
                <%=d.getDept_name() %>
        </option>

<%
        }
      
    } catch(Exception e) {
        out.println(e);
    }
%>

                          </select>
                        
                </div>
                <div style="flex: 1; min-width: 250px;">
                    <label for="selectSem">Select Semester:</label>
                    <select id="selectSem"
                    class="form-select form-control"
                            name="sem"
                           required="required" 
                         >
                        <option>-- Select Semester --</option>
                        <option value="1 sem">1st semester</option>
                        <option value="2 sem">2nd Semester</option>
                        <option value="3 sem">3rd Semester</option>
                        <option value="4 sem">4th Semester</option>
                        <option value="5 sem">5th Semester</option>
                        <option value="6 sem">6th Semester</option>
                        <option value="7 sem">7th Semester</option>
                        <option value="8 sem">8th Semester</option>
                    </select>
                </div>
            </div>
            
            <button type ="submit">Show Subjects</button> 
            <div id="subjects-list" style="margin-top: 30px;">
                </div>
               </form>
        `;
    }

    // TIMETABLE SECTION
    function showTimetable(element){
        setActive(element);
        if(window.innerWidth <= 768) toggleSidebar();

        contentArea.innerHTML =
        `
            <h2><i class="fas fa-calendar-alt"></i> Class Time-Table</h2>
            <p style="margin-bottom: 25px;">Select your course details to view the weekly class schedule.</p>
            <form action="${pageContext.request.contextPath}/views/show_timetable.jsp">

            <div style="display: flex; gap: 20px; flex-wrap: wrap;">
                <div style="flex: 1; min-width: 250px;">
                    <label for="selectBranchT">Select Branch:</label>
                    <select id="selectBranchT" id="defaultSelect"
                          name="dept_id"
                            required="required"
                            class="form-select form-control"
                            
                          >
                            <%
                            
                            
                List<Department> list = DAOFactory.getDepartmentDao().getAllDepartments();

    try {
        for(Department d: list){
        	%>
        
        <option value="<%= d.getDept_id() %>">
                <%=d.getDept_name() %>
        </option>

<%
        }
      
    } catch(Exception e) {
        out.println(e);
    }
%>

                          </select>
                </div>
                <div style="flex: 1; min-width: 250px;">
                    <label for="selectSemT">Select Semester:</label>
                    <select id="selectSemT"class="form-select form-control"
                        name="sem"
                            required="required" 
                          >
                         <option>-- Select Semester --</option>
                         <option value="1 sem">1st semester</option>
                         <option value="2 sem">2nd Semester</option>
                         <option value="3 sem">3rd Semester</option>
                         <option value="4 sem">4th Semester</option>
                         <option value="5 sem">5th Semester</option>
                         <option value="6 sem">6th Semester</option>
                         <option value="7 sem">7th Semester</option>
                         <option value="8 sem">8th Semester</option>
                     </select>
                    
                </div>
            </div>
            <label for="y">Year:</label>
            <input type="text" id="y" name="year" placeholder="Enter year e.g. 20yy-yy" style="padding:10px; border:1px solid #ccc; width: 100%; max-width:300px; border-radius:4px;">
            <br><br>
            <button type="submit">Show Time-Table</button>
            <div id="timetable-display" style="margin-top: 30px;">
                </div>
                </form>
        `;
    }

    // NOTIFICATION SECTION
    function showNotifications(element){
        setActive(element);
        if(window.innerWidth <= 768) toggleSidebar();

        contentArea.innerHTML =
        `
            <h2><i class="fas fa-bullhorn"></i> Notifications & Announcements</h2>
            <div style="margin-top: 20px; padding: 20px; border: 1px dashed #438bd2; border-radius: 6px; background: #f9fbfc;">
                <p style="color: #7f8c8d;">No new notifications available at this time. Check back soon for updates on exams, holidays, and events!</p>
            </div>
            <ul style="list-style: disc; margin-left: 20px; margin-top: 20px; color: #34495e;">
                <li>**Old:** Deadline for fee submission extended to Nov 30.</li>
                <li>**Old:** Workshop on Data Structures scheduled for next Monday.</li>
            </ul>
        `;
    }
    
    // SETTINGS SECTION (Added for better content)
    function showSettings(element){
        setActive(element);
        if(window.innerWidth <= 768) toggleSidebar();

        contentArea.innerHTML =
        `
            <h2><i class="fas fa-user-cog"></i> Account Settings</h2>
            <form>
                <label>Student ID:</label>
                <input type="text" value="STU12345" disabled style="padding:10px; border:1px solid #ccc; width: 100%; max-width:300px; border-radius:4px;">
                
                <label for="email">Contact Email:</label>
                <input type="email" id="email" value="student@university.edu" style="padding:10px; border:1px solid #ccc; width: 100%; max-width:300px; border-radius:4px;">
                
                <label for="password">Change Password:</label>
                <input type="password" id="password" placeholder="Enter new password" style="padding:10px; border:1px solid #ccc; width: 100%; max-width:300px; border-radius:4px;">
                
                <button type="submit">Update Profile</button>
            </form>
        `;
    }

    // Automatically load Subjects on page load (optional)
    document.addEventListener('DOMContentLoaded', (event) => {
        const defaultLink = document.querySelector('aside ul li.active');
        if (defaultLink) {
            showSubjects(defaultLink);
        }
    });
</script>

</body>
</html>