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

    .caret{
        border-top-color:#8B1615!important;
        border-bottom-color:#8B1615!important;
    }

    .filter{
        border:2px solid #e7e7e7;
        border-radius:5px;
        background:white;
    }

    .filter_body{
        padding:15px;
    }

    .filter_header, .filter_footer{
        background-color:#e7e7e7;
        padding: 15px;
    }

    .active_custom{
        background-color:#F1D2D7;
        color:#8B1615;
        font-weight:bold;
    }

    .creator_feed_item{
        color:#D67D61!important;
        font-weight:bold;
    }

    #filter_pagination{
        float:right;
    }

    .pagination > li > a{
        color:#D67D61!important;
    }
</style>

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    <div class="container">
        <h1>Advance Search</h1>
        <div class="row">
            <div class="col-md-9">
                <div class="filter">
                    <div class="filter_header">
                        <%-- filter dropdown --%>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Search
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="#">All of MIDoc</a></li>
                            </ul>
                        </div>
                        <br/>
                        <%-- filter header search --%>
                        <div class="input-group">
                            <input type="text" id="filter_input" class="form-control" placeholder="For" />
                            <span class="input-group-btn">
                                <button class="btn btn-danger" type="button">Go</button>
                            </span>
                        </div>
                    </div>
                    <div class="filter_body">
                        <h4>Add filters:</h4>
                        <h6 style="font-weight:bold;">Use filters to refine the search results.</h6>
                        <div class="row">
                            <div class="col-md-2">
                                <%-- filter1 --%>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        File No
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                        <li><a href="#">Action1</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <%-- filter2 --%>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Equals
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                                        <li><a href="#">Action1</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <%-- filter3 --%>
                                <input type="text" class="form-control" />
                            </div>
                            <div class="col-md-2">
                                <%-- buttonfilter --%>
                                <button class="btn btn-default">Add</button>
                            </div>
                        </div>
                    </div>
                    <div class="filter_footer">
                        <div class="row">
                            <div class="col-md-2"> 
                                <%-- filter1 --%>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Results/Page
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                        <li><a href="#">10</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <%-- filter2 --%>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Sort items by
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                        <li><a href="#">Relevance</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <%-- filter2 --%>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        In order
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                        <li><a href="#">Descending</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <%-- filter2 --%>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Authors/Record
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                        <li><a href="#">All</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <%-- filter2 --%>
                                <button class="btn btn-default">Update</button>
                            </div>
                        </div>
                        <br/>
                        <div class="row" style="margin-left:1px;">
                            <button class="btn btn-default">Export Metadata</button>
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="alert alert-danger" role="alert">
                    Results 1-10 of 20 (Search time:0.019 seconds).
                </div>
                <nav id="filter_pagination">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">previous</span>
                            </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">next</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-3">
                <div class="list-group">
                    <div class="list-group-item active_custom">Creator</div>
                    <a href="#" class="list-group-item creator_feed_item">Ashoka <span class="badge">2</span></a>
                    <a href="#" class="list-group-item creator_feed_item">Ashoka <span class="badge">5</span></a>
                </div>
                <div class="list-group">
                    <div class="list-group-item active_custom">Subject</div>
                    <a href="#" class="list-group-item creator_feed_item">Application for a Visitor Visa <span class="badge">3</span></a>
                    <a href="#" class="list-group-item creator_feed_item">Tourist Stream <span class="badge">3</span></a>
                    <a href="#" class="list-group-item creator_feed_item">na <span class="badge">2</span></a>
                    <a href="#" class="list-group-item creator_feed_item">Aeronautical Engineering Questions <span class="badge">1</span></a>
                    <a href="#" class="list-group-item creator_feed_item">Dell Community <span class="badge">1</span></a>
                    <a href="#" class="list-group-item creator_feed_item">IIT PORTAL : JEE, MAIN, Engineering <span class="badge">1</span></a>
                    <a href="#" class="list-group-item creator_feed_item">Apply online <span class="badge">1</span></a>
                    <a href="#" class="list-group-item creator_feed_item">Service Menu <span class="badge">1</span></a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-9">
                <div class="list-group">
                    <div class="list-group-item active_custom">Community Hits:</div>
                    <div class="list-group-item"><strong>Community Name</strong></div>
                    <a href="#" class="list-group-item creator_feed_item">Private Collection</a>
                    <a href="#" class="list-group-item creator_feed_item">Institutenal Collection</a>
                </div>
                <div class="list-group">
                    <div class="list-group-item active_custom">Collection Hits:</div>
                    <div class="list-group-item"><strong>Collection Name</strong></div>
                    <a href="#" class="list-group-item creator_feed_item">Archival Collection</a>
                    <a href="#" class="list-group-item creator_feed_item">Audio/Visual</a>
                    <a href="#" class="list-group-item creator_feed_item">Correspondence</a>
                    <a href="#" class="list-group-item creator_feed_item">Journals</a>
                    <a href="#" class="list-group-item creator_feed_item">Oral History Interview</a>
                    <a href="#" class="list-group-item creator_feed_item">Photographs</a>
                    <a href="#" class="list-group-item creator_feed_item">Speeches & Articles</a>
                </div>
                <div class="list-group">
                    <div class="list-group-item active_custom">Item Hits:</div>
                    <table class="table">
                        <thead>
                            <tr>
                                <td>Date</td>
                                <td>File No</td>
                                <td>Creator</td>
                                <td>Modified Date</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>23-Apr-2018</td>
                                <td style="color:#D67D61; font-weight:bold;">FN0001</td>
                                <td style="color:#D67D61; font-weight:bold;">Rajesh Kumar</td>
                                <td>2020-11-20T08:42:46Z</td>
                            </tr>
                            <tr>
                                <td>21-Sep-2018</td>
                                <td style="color:#D67D61; font-weight:bold;">ACES0003</td>
                                <td style="color:#D67D61; font-weight:bold;">Pawan Kumar</td>
                                <td>2020-11-21T10:58:39Z</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="list-group">
                    <div class="list-group-item active_custom">Date</div>
                    <a href="#" class="list-group-item creator_feed_item">2018 <span class="badge">4</span></a>
                    <a href="#" class="list-group-item creator_feed_item">2017 <span class="badge">2</span></a>
                    <a href="#" class="list-group-item creator_feed_item">2019 <span class="badge">1</span></a>
                    <a href="#" class="list-group-item creator_feed_item">2020 <span class="badge">1</span></a>
                </div>
                <div class="list-group">
                    <div class="list-group-item active_custom">Has File(s)</div>
                    <a href="#" class="list-group-item creator_feed_item">true <span class="badge">8</span></a>
                </div>
            </div>
        </div>
    </div>
</dspace:layout>
