

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="common/head.jsp"></jsp:include>
        <link href="<c:url value="/resources/css/panel.css" />" type="text/css" rel="stylesheet" />     
    </head>   
    <body>    
        <jsp:include page="common/menu.jsp" />   
        <section id="our-process" class="padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2">
                        <div class="heading-title text-center wow fadeInUp" data-wow-delay="300ms">
                            <h2 class="darkcolor bottom20 text-capitalize">Benvenuto ${user}</h2>
                            <p class="bottom0">di seguito un riepilogo delle funzioni accessibili dall'applicazione per il ruolo di Amministratore</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <ul class="process-wrapp">
                        <li class="wow fadeIn" data-wow-delay="300ms">                            
                            <span class="pro-step gradient_bg_two bottom20">
                              <i class="fas fa-users" style="vertical-align: bottom"></i>
                            </span>
                            <h4 class="font-light darkcolor bottom25">Utenti</h4>
                            <p class="bottom0">gestire gli utenti che accedono all'applicazione</p>
                        </li>
                        <li class="wow fadeIn" data-wow-delay="350ms">
                            <span class="pro-step gradient_bg_three bottom20"><i class="fas fa-address-book"></i></span>
                            <h4 class="font-light darkcolor bottom25">Anagrafiche</h4>
                            <p class="bottom0">registrare anagrafiche dei dipendenti</p>
                        </li>
                        <li class="wow fadeIn" data-wow-delay="400ms">
                            <span class="pro-step gradient_bg_one bottom20"><i class="fas fa-table"></i></span>
                            <h4 class="font-light darkcolor bottom25">Riepiloghi</h4>
                            <p class="bottom0">visualizzare il riepilogo delle attivit� degli utenti e delle ore di lavoro dei collaboratori</p>
                        </li>
                        <li class="wow fadeIn" data-wow-delay="450ms">
                            <span class="pro-step gradient_bg_four bottom20"><i class="fas fa-file-signature"></i></span>
                            <h4 class="font-light darkcolor bottom25">Qualit�</h4>
                            <p class="bottom0">caricare e scaricare documenti sulla qualit�</p>
                        </li>
                        <li class="wow fadeIn" data-wow-delay="500ms">
                            <span class="pro-step gradient_bg_five bottom20"><i class="fas fa-text-width"></i></span>
                            <h4 class="font-light darkcolor bottom25">Curricula</h4>
                            <p class="bottom0">caricare e scaricare i curricula dei collaboratori e dei candidati</p>
                        </li>
                    </ul>
                </div>
            </div>
        </section>
    </body>
</html>

