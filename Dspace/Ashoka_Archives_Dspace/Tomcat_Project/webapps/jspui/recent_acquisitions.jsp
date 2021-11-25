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

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    
    <h1 class="text-center">Recent Acquisitions</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <ol>
            <h4>
                <li>
                    Prabhakar Machwe Papers - Hindi, English and Marathi writer and poet
                    <br/>
                    <span style="font-weight:normal;">
                        The Ashoka Archives had the privilege to acquire the papers of Prabhakar Machwe from his daughter Smt. Chetana Kohli. These include correspondance with his contemporaries, such as S. RadhaKrishnan, Kishorial G. Mashruwala, Haribhau Upadhyaya, B. V. Warerkar, Yashpal, and Shivmangal Singh 'Suman'; articles on Hindi literature, short stories, etc. The Collection also comprises his rare books in English, Hindi and Marathi.
                    </span>
                </li>
            </h4>
            <h4>
                <li>
                    Mainstream Journal - Current Affairs Weekly
                    <br/>
                    <span style="font-weight:normal;">
                        Mainstream has been providing objective analysis of divergent contemporary issues since its inception in 1962. The collection of these volumes from 1962 to 2020 has been donated to Ashoka Archives by Shri Sumit Chakravartty, Editor-in Cheif and Publisher of Mainstream. It is a very useful soruce material for the study and research on modern and contemporary history of India.
                    </span>
                </li>
            </h4>
            <h4>
                <li>
                    Prerna Singh Bindra Papers - Wildlife Conservationist, journalist, and writer
                    <br/>
                    <span style="font-weight:normal;">
                        The Ashoka Archives received papers from Ms. Prerna Bindra comprising her correspondance carried out as a Trustee of Bagh Foundation and as a member of State Board for Wildlife, Uttarakhand, and Standing Committee, National Board for Wildlife. These relate to wildlife habitat, environmental issues of important concern, tiger conservation, and related reports.
                    </span>
                </li>
            </h4>
            <h4>
                <li>
                    Ullas Karanth Papers - Wildlife Conservationist and tiger expert
                    <br/>
                    <span style="font-weight:normal;">
                        Dr. Ullas Karanth donated another installment of his papers relating to wildlife conservation. These include among others, correspondance with forest departments of Central and State Governments, National Tiger Conservation Authority, IGNFA, WWF, various academic institutions, print and film media, and NGO's; articles, notes and reports on conservation projects, resdement and wildlie legal, camera trapping photo nagatives/tiger mapping; and copies of contracts, MoUs and agreements.
                    </span>
                </li>
            </h4>
        </ol>
    </div>
</dspace:layout>
