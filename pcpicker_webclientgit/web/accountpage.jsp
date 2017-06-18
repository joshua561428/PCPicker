<%-- 
    Document   : accountpage
    Created on : 06 5, 17, 6:29:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/test.css">
    </head>
    <body>
        <div class ="banner">
            <div class ="logo">  
                <a href="${pageContext.request.contextPath}/Homepage"><img src="img/logo.png" alt="logo" /></a>
            </div>
            <div class="login_button">
                <a href="<%=request.getContextPath()%>/Login">                   
                    ${empty sessionScope.username?'Log in or Register':sessionScope.username}                    
                </a>
            </div>
            <div class ="cartsummary">
                <a href="<%=request.getContextPath()%>/ShoppingCart">                   
                    ${cartsummary}                    
                </a>
            </div>
            
            <div class ="menubar_banner">   
                <div class="buttons">
                    <form action="SearchPage" method="doGet">
                        <input type="submit" value="CPU" name="test">
                        <input type="submit" value="GPU" name="test">
                        <input type="submit" value="Memory" name="test">
                        <input type="submit" value="Motherboard" name="test">
                        <input type="submit" value="Cooler" name="test">
                        <input type="submit" value="Storage" name="test">                         
                        <input type="submit" value="Power Supply" name="test">
                        <input type="submit" value="Monitor" name="test">
                        <input type="submit" value="Keyboard" name="test">
                        <input type="submit" value="Mouse" name="test">
                    </form>
                </div>
            </div>
        </div>
        
        <div class="content">
            <div class="acount">
                Hello ${sessionScope.username}!<br>
                <input type="submit" value="Logout" name="button" onclick=location.href='${pageContext.request.contextPath}/Logout;' style="border:1px solid #ccc; padding:5px">
            </div>
            <div>
                <div class="accountbanner">
                    Active orders
                </div>
                <div class ="accountlabel">
                    Order id
                </div>
                <div class ="accountlabel">
                    Date Created
                </div>
                <div class ="accountlabel">
                    Payment Method
                </div>
                <div class ="accountlabel">
                    Number of items
                </div>
                <div class ="accountlabel">
                    Delivery Date
                </div>
                <div class ="accountlabel">
                    Total Price
                </div>                
                <div class ="borderbottom">    
                   
                </div>
                <form action ="OrderPage" method ="get">
                    <input type="hidden" name ="orderLength" value="${fn:length(orders)}">
                    <c:forEach items="${orders}" var="order" varStatus ="loopCounter">                
                        <div class ="searchItemWrapper3">  
                            <c:forEach items="${order.value}" var="details" varStatus="loopCounter2">
                                <c:choose>
                                    <c:when test="${loopCounter2.index == 0 }">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                            <input type ="hidden" name ="orderid" value ="${details.value}">
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 1}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 2}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 3}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 4}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="accountpageorderitem">
                                            ₱${details.value}
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                      



                            </c:forEach>
                            <div class="buttons2">
                                
                                <input type="submit" value="Cancel Order" name="submit${loopCounter.index}"><br>
                             </div> 
                             <div class="buttons2">
                                <input type="submit" value="View Order" name="submit${loopCounter.index}">
                                
                            </div>
                        </div><br>
                    </c:forEach>
                </form>
                    <div class="accountbanner">
                        Order History
                    </div>
                    <div class ="accountlabel">
                        Order id
                    </div>
                    <div class ="accountlabel">
                        Date Created
                    </div>
                    <div class ="accountlabel">
                        Payment Method
                    </div>
                    <div class ="accountlabel">
                        Number of items
                    </div>
                    <div class ="accountlabel">
                        Delivery Date
                    </div>
                    <div class ="accountlabel">
                        Total Price
                    </div>                
                <div class ="borderbottom">  
                 <c:forEach items="${ordersHistory}" var="order" varStatus ="loopCounter">                
                     <c:forEach items="${order.value}" var="details" varStatus="loopCounter2">
                                <c:choose>
                                    <c:when test="${loopCounter2.index == 0 }">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                            <input type ="hidden" name ="orderid" value ="${details.value}">
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 1}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 2}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 3}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:when test="${loopCounter2.index == 4}">
                                        <div class="accountpageorderitem">
                                            ${details.value}
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="accountpageorderitem">
                                            ₱${details.value}
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                      



                            </c:forEach>
                 </c:forEach>
            </div>
        </div>
    </body>
</html>
