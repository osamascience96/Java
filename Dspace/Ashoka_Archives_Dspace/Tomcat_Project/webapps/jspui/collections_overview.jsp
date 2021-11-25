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

    .read_more_link{
        float:right;
    }
</style>

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    <div class="container">
        <h1>Collections Overview</h1>
        <span style="font-weight:bold;">
            The Ashoka Archives established in 2017 is a custodian of rare and valuable documents related to economic reforms initiated in the 1990s, science and technology, environment and climate change, women empowerment, social, educational and political developments in the country, growth of media in various forms and all other related themes.
        </span>
        <hr/>
        <div style="padding:20px;">
            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/collections/k_ullas_karanth.PNG" class="img-circle" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>K. Ullas Karanth Papers (1982-2017)</h4>
                    <span>K. Ullas Karanth (born 1948) is a conservation zoologist and a leading tiger expert. He is the Founder and Emeritus Director of Centre for Wildlife Studies. Bengaluru, Karnataka. Although originally trained as a mechanical engineer at the National Institute of technology, Karnataka, Dr. Ullas Karanth was fascinated by wildlife since childhood. He founded the Centre of Wildlife Studies (CWS) in 1984. Inspired by Dr. George Schaller of WCS, Dr. Ullas decided </span>
                    <br/>
                    <a class="read_more_link" href="#">Read more.....</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/collections/girish_karanth.PNG" class="img-circle" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Girish karnad Papers (1900-2018)</h4>
                    <span>Girish karnad (1938-2019) was a renowned kannada playwright, author and film director. After graduating from karnataka University in 1958, Girish karnad studied philosophy, politics, and economics as a Rhodes Scholar at the University of Oxford(1980-1983). After his return to India, Girish karnad started working with the Oxford University Press in Chennai, 1983 and resigned in 1970 to devote full time to writing. At the young age of 35, he became the Director of the Film and Television Institute of India.</span>
                    <br/>
                    <a class="read_more_link" href="#">Read more.....</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/collections/suresh_kohli.PNG" class="img-circle" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Suresh Kohli Papers (1953-2016)</h4>
                    <span>Suresh Kohli (1947-2016) was a poet, writer, translator, editor, literary critic, film maker and film historian. He wrote extensively in mainstream newspapers and specialized journals, magazines on themes of literature and cenimas, and their social context. He served as the Editor at National Book Trust, the Chief Editor at Arnold Heinemann and Sterling Publishers, and Editor-in-Chief at Om Books International (2007-2010).</span>
                    <br/>
                    <a class="read_more_link" href="#">Read more.....</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <img src="<%=request.getContextPath()%>/image/collections/prab_mach.PNG" class="img-circle" width="140px" height="140px"/>
                </div>
                <div class="col-md-10">
                    <h4>Prabhakar Machwe Papers (1931-2008)</h4>
                    <span>Dr. Prabhakar Machwe (1917-1991) was a profilic writer, linguist and an authority on India literature. He graduated from Vikram University, Ujjain and obtained Masters in Philosophy, 1937, and English Literature, 1945, Agra University; Sahitya Ratna and Ph.D, Agra University, 1957. Dr.Machwe started his career as a lecturer in Madhav College, Ujjain, 1938-1948. He worked as Literary Producer, All India Radio, Nagpur, Allahabad and New Delhi, 1948-1954. He was closely associated with Sahitya Akademi from its inception in 1954 and served as Assistant Secretary,1954-1970, and Secretary, 1970-1975.</span>
                    <br/>
                    <a class="read_more_link" href="#">Read more.....</a>
                </div>
            </div>
        </div>
    </div>
</dspace:layout>
