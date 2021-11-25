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

    h4{
        font-weight:bold;
    }
</style>

<dspace:layout locbar="nolink" title="Outreach" >
    <h1 class="text-center">Academic Activities</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <div class="container">
            <span style="font-size:20px;">
                <span style="font-weight:bold;">13 & 14 November 2017:</span> Participation in Annual Conference of Oral History Association of India organized by OHAI, Bengaluru, and Department of History, Gauhati University
            </span>
            <br/>
            <span style="font-size:20px;">
                <span style="font-weight:bold;">06 December 2017:</span> Felicitation function of Shri Chandi Prasad Bhatt, Gandhian social activist. (Ashoka Archives was privileged to receive a collection of his private papers in October 2017)
            </span>
            <hr style="border-color:white;"/>
            <figure>
                <img src="<%=request.getContextPath()%>/image/academic_activities/workshop_image1.PNG" alt="workshop_1" width="100%" height="100%"/>
                <figcaption>
                    <span style="font-size:20px;">
                        <span style="font-weight:bold;">06 Feburary 2019</span> Workshop on the practical working of archives with Suzanne Edwards of Gloria Naylor archives, Lehigh University.
                    </span>
                </figcaption>
            </figure>
            <br/>
            <figure>
                <img src="<%=request.getContextPath()%>/image/academic_activities/workshop_image2.PNG" alt="workshop_2" width="100%" height="100%"/>
                <figcaption>
                    <span style="font-size:20px;">
                        <span style="font-weight:bold;">02 April 2019</span> Workshop on the practical working of archives with the students of Johannes Burgers, Assistant Professor, English & Digital Humanities, Ashoka University
                    </span>
                </figcaption>
            </figure>
            <br/>
            <span style="font-size:20px;">
                <span style="font-weight:bold;">19 & 20 August 2019:</span> Participation in workshop on Archival Standards & Digitization Workflows conducted by British Library, London, and hosted by Archives at NCBS, (National Centre for Biological Sciences) Bengaluru
            </span>
        </div>
    </div>
</dspace:layout>
