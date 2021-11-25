<%@page import="org.dspace.core.factory.CoreServiceFactory"%>
<%@page import="org.dspace.core.service.NewsService"%>
<%@page import="org.dspace.content.service.CommunityService"%>
<%@page import="org.dspace.content.factory.ContentServiceFactory"%>
<%@page import="org.dspace.content.service.ItemService"%>
<%@page import="org.dspace.core.Utils"%>
<%@page import="org.dspace.content.Bitstream"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.dspace.org/dspace-tags.tld" prefix="dspace" %>

<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.jsp.jstl.core.*" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocaleSupport" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.dspace.core.I18nUtil" %>
<%@ page import="org.dspace.app.webui.util.UIUtil" %>
<%@ page import="org.dspace.app.webui.components.RecentSubmissions" %>
<%@ page import="org.dspace.content.Community" %>
<%@ page import="org.dspace.browse.ItemCounter" %>
<%@ page import="org.dspace.content.Item" %>
<%@ page import="org.dspace.services.ConfigurationService" %>
<%@ page import="org.dspace.services.factory.DSpaceServicesFactory" %>

<style>
    .undernavigation{
        background: white;
    }
</style>

<dspace:layout locbar="nolink" title="About Us" >
    <div class="container-fluid" style="background-color:white; padding: 20px 0 20px 0;">
        <h1 class="text-center">Ashoka Archives of Contemporary India</h1>
        <div class="container" style="border: 5px solid #e4e4e4; padding:10px; border-radius:10px;">
            <p style="font-weight:bold; font-size:20px;">
                The Ashoka Archives of Comtemporary India was set up in 2017 with a vision to archive and 
                preserve primary soruce material for the study of modern and contemporary history of India with 
                major thrust on polity, economy and society. The basic aim was to create a major centre for 
                historical and social science research in the country.
            </p>
            <p style="font-weight:bold; font-size:20px;">
                Keeping in mind the latest trends in social research, the main focus of Ashoka Archives is to
                collect documents related to economic reforms initiated in the 1990s, science and technology, 
                environment and climate change, women empowerment, social, educational and political developments
                in the country, growth of media in various forms and all other related themes.
            </p>
        </div>

        <h1 class="text-center">Archives Team</h1>
        <div class="container" style="border: 5px solid #e4e4e4; padding:25px; border-radius:10px;">
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/eshwara_venkatesam.PNG" alt="eshwara_venkatesam" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Eshwara Venkatesam</h4>
                    <h5>Pro Vice-Chancellor (Development, Placements and Alumni Relations)</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/mahesh_rangarajan.PNG" alt="mahesh_rangarajan" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Mahesh Rangarajan</h4>
                    <h5>Chair (Hon.), Ashoka Archives of Contemporary India, and Vice Chancellor of Krea University</h5>
                    <h6>Sricity, AP.</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/deepa_bhatnagar.PNG" alt="deepa_bhatnagar" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Deepa Bhatnagar</h4>
                    <h5>Director, Ashoka Archives of Contemporary India</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/neelam_vatsa.PNG" alt="neelam_vatsa" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Neelam Vatsa</h4>
                    <h5>Assistant Director of Ashoka Archives of Contemporary India</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/deepshikha_salooja.PNG" alt="deepshikha_salooja" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Deepshikha Salooja</h4>
                    <h5>Senior Archivist & Manager, Ashoka Archives of Contemporary India</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/dharmendra_singh_rawat.PNG" alt="dharmendra_singh_rawat" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Dharmendra Singh Rawat</h4>
                    <h5>Senior Archivist & Digitization Coordinator Ashoka Archives of Contemporary India</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/shivani_bajpai.PNG" alt="shivani_bajpai" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Shivani Bajpai</h4>
                    <h5>Archives Associate Ashoka Archives of Contemporary India</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/aboutus/ravin_kumar.PNG" alt="ravin_kumar" class="img-rounded" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Ravin Kumar</h4>
                    <h5>Senior Manager Administration</h5>
                    <h6>Ashoka University</h6>
                </div>
            </div>
        </div>
    </div>
</dspace:layout>
