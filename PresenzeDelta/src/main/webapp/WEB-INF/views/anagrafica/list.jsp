<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/common/parsley.css" />" type="text/css" rel="stylesheet" />   
        <link href="<c:url value="/resources/css/anagrafica/list.css" />" type="text/css" rel="stylesheet" />       
        <script src="<c:url value="/resources/js/list.js" />" type="text/javascript"></script>
    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  />       
        <hr>

        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-lg-12">
                    <div class="main-box no-header clearfix">
                        <div class="main-box-body clearfix">
                            <div class="table-responsive">
                                <div>       
                                <a class="nav-link"
                                        href="<c:url value="/anagrafica/create" />"> 
                                    <i style="width: 35px;height: 35px" class="fas fa-plus-circle"></i>Crea Anagrafica                              
                                </a>
                                </div>
                                <table class="table user-list">
                                    <thead>
                                        <tr>
                                            <th><span>User</span></th>
                                            <th><span>Created</span></th>
                                            <th class="text-center"><span>Status</span></th>
                                            <th><span>Email</span></th>
                                            <th>&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${Users}" var="user" varStatus="s">
                                            <tr>
                                                <td>
                                                    <img src="https://bootdey.com/img/Content/user_1.jpg" alt="">
                                                    <a href="#" class="user-link">Full name 1</a>
                                                    <span class="user-subhead">Member</span>
                                                </td>
                                                <td>2013/08/12</td>
                                                <td class="text-center">
                                                    <span class="label label-default">pending</span>
                                                </td>
                                                <td>
                                                    <a href="#">marlon@brando.com</a>
                                                </td>
                                                <td style="width: 20%;">
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link danger">
                                                        <span class="fa-stack">
                                                            <i class="fas fa-minus-circle"></i>
                                                            <i class="fas fa-edit"></i>
                                                        </span>
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <img src="https://bootdey.com/img/Content/user_3.jpg" alt="">
                                                    <a href="#" class="user-link">Full name 2</a>
                                                    <span class="user-subhead">Admin</span>
                                                </td>
                                                <td>2013/08/12</td>
                                                <td class="text-center">
                                                    <span class="label label-success">Active</span>
                                                </td>
                                                <td>
                                                    <a href="#">marlon@brando.com</a>
                                                </td>
                                                <td style="width: 20%;">
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link danger">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <img src="https://bootdey.com/img/Content/user_2.jpg" alt="">
                                                    <a href="#" class="user-link">Full name 3</a>
                                                    <span class="user-subhead">Member</span>
                                                </td>
                                                <td>2013/08/12</td>
                                                <td class="text-center">
                                                    <span class="label label-danger">inactive</span>
                                                </td>
                                                <td>
                                                    <a href="#">marlon@brando.com</a>
                                                </td>
                                                <td style="width: 20%;">
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link danger">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>